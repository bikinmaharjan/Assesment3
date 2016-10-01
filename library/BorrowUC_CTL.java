
package library;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import library.BorrowUC_UI;
import library.interfaces.EBorrowState;
import library.interfaces.IBorrowUI;
import library.interfaces.IBorrowUIListener;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.daos.IMemberDAO;
import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import library.interfaces.hardware.ICardReader;
import library.interfaces.hardware.ICardReaderListener;
import library.interfaces.hardware.IDisplay;
import library.interfaces.hardware.IPrinter;
import library.interfaces.hardware.IScanner;
import library.interfaces.hardware.IScannerListener;

public class BorrowUC_CTL
implements ICardReaderListener,
IScannerListener,
IBorrowUIListener {
    private ICardReader reader;
    private IScanner scanner;
    private IPrinter printer;
    private IDisplay display;
    private int scanCount = 0;
    private IBorrowUI ui;
    private EBorrowState state;
    private IBookDAO bookDAO;
    private IMemberDAO memberDAO;
    private ILoanDAO loanDAO;
    private List<IBook> bookList;
    private List<ILoan> loanList;
    private IMember borrower;
    private JPanel previous;
    private static /* synthetic */ int[] $SWITCH_TABLE$library$interfaces$EBorrowState;

    public BorrowUC_CTL(ICardReader reader, IScanner scanner, IPrinter printer, IDisplay display, IBookDAO bookDAO, ILoanDAO loanDAO, IMemberDAO memberDAO) {
        this.bookDAO = bookDAO;
        this.memberDAO = memberDAO;
        this.loanDAO = loanDAO;
        this.ui = new BorrowUC_UI(this);
        this.reader = reader;
        reader.addListener(this);
        this.scanner = scanner;
        scanner.addListener(this);
        this.printer = printer;
        this.display = display;
        this.state = EBorrowState.CREATED;
    }

    public void initialise() {
        this.previous = this.display.getDisplay();
        this.display.setDisplay((JPanel)((Object)this.ui), "Borrow UI");
        this.setState(EBorrowState.INITIALIZED);
    }

    public void close() {
        this.display.setDisplay(this.previous, "Main Menu");
    }

    @Override
    public void cardSwiped(int memberID) {
        boolean borrowing_restricted;
        float amountOwing;
        System.out.println("cardSwiped: got " + memberID);
        if (!this.state.equals((Object)EBorrowState.INITIALIZED)) {
            throw new RuntimeException(String.format("BorrowUC_CTL : cardSwiped : illegal operation in state: %s", new Object[]{this.state}));
        }
        this.borrower = this.memberDAO.getMemberByID(memberID);
        if (this.borrower == null) {
            this.ui.displayErrorMessage(String.format("Member ID %d not found", memberID));
            return;
        }
        boolean overdue = this.borrower.hasOverDueLoans();
        boolean atLoanLimit = this.borrower.hasReachedLoanLimit();
        boolean hasFines = this.borrower.hasFinesPayable();
        boolean overFineLimit = this.borrower.hasReachedFineLimit();
        boolean bl = borrowing_restricted = overdue || atLoanLimit || overFineLimit;
        if (borrowing_restricted) {
            this.setState(EBorrowState.BORROWING_RESTRICTED);
        } else {
            this.setState(EBorrowState.SCANNING_BOOKS);
        }
        int mID = this.borrower.getID();
        String mName = String.valueOf(this.borrower.getFirstName()) + " " + this.borrower.getLastName();
        String mContact = this.borrower.getContactPhone();
        this.ui.displayMemberDetails(mID, mName, mContact);
        if (hasFines) {
            amountOwing = this.borrower.getFineAmount();
            this.ui.displayOutstandingFineMessage(amountOwing);
        }
        if (overdue) {
            this.ui.displayOverDueMessage();
        }
        if (atLoanLimit) {
            this.ui.displayAtLoanLimitMessage();
        }
        if (overFineLimit) {
            System.out.println("State: " + (Object)((Object)this.state));
            amountOwing = this.borrower.getFineAmount();
            this.ui.displayOverFineLimitMessage(amountOwing);
        }
        String loanString = this.buildLoanListDisplay(this.borrower.getLoans());
        this.ui.displayExistingLoan(loanString);
    }

    @Override
    public void bookScanned(int barcode) {
        System.out.println("bookScanned: got " + barcode);
        if (this.state != EBorrowState.SCANNING_BOOKS) {
            throw new RuntimeException(String.format("BorrowUC_CTL : bookScanned : illegal operation in state: %s", new Object[]{this.state}));
        }
        this.ui.displayErrorMessage("");
        IBook book = this.bookDAO.getBookByID(barcode);
        if (book == null) {
            this.ui.displayErrorMessage(String.format("Book %d not found", barcode));
            return;
        }
        if (book.getState() != EBookState.AVAILABLE) {
            this.ui.displayErrorMessage(String.format("Book %d is not available: %s", new Object[]{book.getID(), book.getState()}));
            return;
        }
        if (this.bookList.contains(book)) {
            this.ui.displayErrorMessage(String.format("Book %d already scanned: ", book.getID()));
            return;
        }
        ++this.scanCount;
        this.bookList.add(book);
        ILoan loan = this.loanDAO.createLoan(this.borrower, book);
        this.loanList.add(loan);
        this.ui.displayScannedBookDetails(book.toString());
        this.ui.displayPendingLoan(this.buildLoanListDisplay(this.loanList));
        if (this.scanCount >= 5) {
            this.setState(EBorrowState.CONFIRMING_LOANS);
        }
    }

    private void setState(EBorrowState state) {
        System.out.println("Setting state: " + (Object)((Object)state));
        this.state = state;
        this.ui.setState(state);
        switch (BorrowUC_CTL.$SWITCH_TABLE$library$interfaces$EBorrowState()[state.ordinal()]) {
            case 2: {
                this.reader.setEnabled(true);
                this.scanner.setEnabled(false);
                break;
            }
            case 3: {
                this.reader.setEnabled(false);
                this.scanner.setEnabled(true);
                this.bookList = new ArrayList<IBook>();
                this.loanList = new ArrayList<ILoan>();
                this.scanCount = this.borrower.getLoans().size();
                this.ui.displayScannedBookDetails("");
                this.ui.displayPendingLoan("");
                break;
            }
            case 4: {
                this.reader.setEnabled(false);
                this.scanner.setEnabled(false);
                this.ui.displayConfirmingLoan(this.buildLoanListDisplay(this.loanList));
                break;
            }
            case 5: {
                this.reader.setEnabled(false);
                this.scanner.setEnabled(false);
                for (ILoan loan : this.loanList) {
                    this.loanDAO.commitLoan(loan);
                }
                this.printer.print(this.buildLoanListDisplay(this.loanList));
                this.close();
                break;
            }
            case 7: {
                this.reader.setEnabled(false);
                this.scanner.setEnabled(false);
                this.close();
                break;
            }
            case 6: {
                this.reader.setEnabled(false);
                this.scanner.setEnabled(false);
                this.ui.displayErrorMessage(String.format("Member %d cannot borrow at this time.", this.borrower.getID()));
                break;
            }
            default: {
                throw new RuntimeException("Unknown state");
            }
        }
    }

    @Override
    public void cancelled() {
        this.setState(EBorrowState.CANCELLED);
    }

    @Override
    public void scansCompleted() {
        this.setState(EBorrowState.CONFIRMING_LOANS);
    }

    @Override
    public void loansConfirmed() {
        this.setState(EBorrowState.COMPLETED);
    }

    @Override
    public void loansRejected() {
        System.out.println("Loans Rejected");
        this.setState(EBorrowState.SCANNING_BOOKS);
    }

    private String buildLoanListDisplay(List<ILoan> loans) {
        StringBuilder bld = new StringBuilder();
        for (ILoan ln : loans) {
            if (bld.length() > 0) {
                bld.append("\n\n");
            }
            bld.append(ln.toString());
        }
        return bld.toString();
    }

    static /* synthetic */ int[] $SWITCH_TABLE$library$interfaces$EBorrowState() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$library$interfaces$EBorrowState;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[EBorrowState.values().length];
        try {
            arrn[EBorrowState.BORROWING_RESTRICTED.ordinal()] = 6;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[EBorrowState.CANCELLED.ordinal()] = 7;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[EBorrowState.COMPLETED.ordinal()] = 5;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[EBorrowState.CONFIRMING_LOANS.ordinal()] = 4;
        }
        catch (NoSuchFieldError v4) {}
        try {
            arrn[EBorrowState.CREATED.ordinal()] = 1;
        }
        catch (NoSuchFieldError v5) {}
        try {
            arrn[EBorrowState.INITIALIZED.ordinal()] = 2;
        }
        catch (NoSuchFieldError v6) {}
        try {
            arrn[EBorrowState.SCANNING_BOOKS.ordinal()] = 3;
        }
        catch (NoSuchFieldError v7) {}
        $SWITCH_TABLE$library$interfaces$EBorrowState = arrn;
        return $SWITCH_TABLE$library$interfaces$EBorrowState;
    }
}


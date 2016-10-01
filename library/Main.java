//Main class for the code
//test1
package library;

import library.hardware.CardReader;
import library.hardware.Display;
import library.hardware.Printer;
import library.hardware.Scanner;

import java.util.Calendar;
import java.util.Date;

import library.interfaces.IMainListener;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.daos.IMemberDAO;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import library.panels.MainPanel;

public class Main implements IMainListener {

	private CardReader reader;
	private Scanner scanner;
	private Printer printer;
	private Display display;
	private IBookDAO bookDAO;
	private ILoanDAO loanDAO;
	private IMemberDAO memberDAO;
	
	public Main() {
		reader = new CardReader();
		scanner = new Scanner();
		printer = new Printer();
		display = new Display();
		
		setupTestData();
	}


	public void showGUI() {		
		reader.setVisible(true);
		scanner.setVisible(true);
		printer.setVisible(true);
		display.setVisible(true);
	}

	
	@Override
	public void borrowBooks() {
		BorrowUC_CTL ctl = new BorrowUC_CTL(reader, scanner, printer, display, 
				 null, null, null);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ctl.initialise();
            }
        });		
	}

	
	private void setupTestData() {
        IBook[] book = new IBook[16];
		IMember[] member = new IMember[6];
		
		 
		
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
				
		//create a member with overdue loans		
		for (int i=0; i<2; i++) {
			ILoan loan = loanDAO.createLoan(member[1], book[i]);
			loanDAO.commitLoan(loan);
		}
		cal.setTime(now);
		cal.add(Calendar.DATE, ILoan.LOAN_PERIOD + 1);
		Date checkDate = cal.getTime();		
		loanDAO.updateOverDueStatus(checkDate);
		
		//create a member with maxed out unpaid fines
		member[2].addFine(10.0f);
		
		//create a member with maxed out loans
		for (int i=2; i<7; i++) {
			ILoan loan = loanDAO.createLoan(member[3], book[i]);
			loanDAO.commitLoan(loan);
		}
		
		//a member with a fine, but not over the limit
		member[4].addFine(5.0f);
		
		//a member with a couple of loans but not over the limit
		for (int i=7; i<9; i++) {
			ILoan loan = loanDAO.createLoan(member[5], book[i]);
			loanDAO.commitLoan(loan);
		}
	}

	
	public static void main(String[] args) {
		
        // start the GUI
		Main main = new Main();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	main.display.setDisplay(new MainPanel(main), "Main Menu");
                main.showGUI();
            }
        });
	}

	
}

/*
 * Team  10 JUnit testing
 */
package library.daos;

import java.util.Date;
import java.util.List;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team 10
 */
public class LoanMapDAOTest {

	public LoanMapDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getLoanByID method, of class LoanMapDAO.
	 */
	@Test
	public void testGetLoanByID() {
		try {
			System.out.println("getLoanByID");
			int id = 0;
			LoanMapDAO instance = null;
			ILoan expResult = null;
			ILoan result = instance.getLoanByID(id);
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of getLoanByBook method, of class LoanMapDAO.
	 */
	@Test
	public void testGetLoanByBook() {
		try {
			System.out.println("getLoanByBook");
			IBook book = null;
			LoanMapDAO instance = null;
			ILoan expResult = null;
			ILoan result = instance.getLoanByBook(book);
			assertEquals(expResult, result);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of listLoans method, of class LoanMapDAO.
	 */
	@Test
	public void testListLoans() {
		try {
			System.out.println("listLoans");
			LoanMapDAO instance = null;
			List<ILoan> expResult = null;
			List<ILoan> result = instance.listLoans();
			assertEquals(expResult, result);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of findLoansByBorrower method, of class LoanMapDAO.
	 */
	@Test
	public void testFindLoansByBorrower() {
		try {
			System.out.println("findLoansByBorrower");
			IMember borrower = null;
			LoanMapDAO instance = null;
			List<ILoan> expResult = null;
			List<ILoan> result = instance.findLoansByBorrower(borrower);
			assertEquals(expResult, result);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of findLoansByBookTitle method, of class LoanMapDAO.
	 */
	@Test
	public void testFindLoansByBookTitle() {
		try {
			System.out.println("findLoansByBookTitle");
			String title = "";
			LoanMapDAO instance = null;
			List<ILoan> expResult = null;
			List<ILoan> result = instance.findLoansByBookTitle(title);
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of updateOverDueStatus method, of class LoanMapDAO.
	 */
	@Test
	public void testUpdateOverDueStatus() {
		try {
			System.out.println("updateOverDueStatus");
			Date currentDate = null;
			LoanMapDAO instance = null;
			instance.updateOverDueStatus(currentDate);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of findOverDueLoans method, of class LoanMapDAO.
	 */
	@Test
	public void testFindOverDueLoans() {
		try {
			System.out.println("findOverDueLoans");
			LoanMapDAO instance = null;
			List<ILoan> expResult = null;
			List<ILoan> result = instance.findOverDueLoans();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of createLoan method, of class LoanMapDAO.
	 */
	@Test
	public void testCreateLoan() {
		try {
			System.out.println("createLoan");
			IMember borrower = null;
			IBook book = null;
			LoanMapDAO instance = null;
			ILoan expResult = null;
			ILoan result = instance.createLoan(borrower, book);
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of commitLoan method, of class LoanMapDAO.
	 */
	@Test
	public void testCommitLoan() {
		try {
			System.out.println("commitLoan");
			ILoan loan = null;
			LoanMapDAO instance = null;
			instance.commitLoan(loan);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

}

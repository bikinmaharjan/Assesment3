/*
 * JUnit testing by team10
 */
package library.daos;

import java.util.Date;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team10
 */
public class LoanHelperTest {

	public LoanHelperTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of makeLoan method, of class LoanHelper.
	 */
	@Test
	public void testMakeLoan() {
		try {
			System.out.println("makeLoan");
			IBook book = null;
			IMember borrower = null;
			Date borrowDate = null;
			Date dueDate = null;
			LoanHelper instance = new LoanHelper();
			ILoan expResult = null;
			ILoan result = instance.makeLoan(book, borrower, borrowDate, dueDate);
			assertEquals(expResult, result);
		} catch (IllegalArgumentException e) {
			fail("The test fails if the user enters inappropriate argument");
		}
	}

}

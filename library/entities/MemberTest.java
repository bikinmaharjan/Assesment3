/*
 * Test for Book.java
 * JUnit testing by team 10
 */
package library.entities;

import java.util.List;
import library.interfaces.entities.EMemberState;
import library.interfaces.entities.ILoan;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team 10
 */
public class MemberTest {

	public MemberTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of hasOverDueLoans method, of class Member.
	 */
	@Test
	public void testHasOverDueLoans() {
		try {
			System.out.println("hasOverDueLoans");
			Member instance = null;
			boolean expResult = false;
			boolean result = instance.hasOverDueLoans();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of hasReachedLoanLimit method, of class Member.
	 */
	@Test
	public void testHasReachedLoanLimit() {
		try {
			System.out.println("hasReachedLoanLimit");
			Member instance = null;
			boolean expResult = false;
			boolean result = instance.hasReachedLoanLimit();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of hasFinesPayable method, of class Member.
	 */
	@Test
	public void testHasFinesPayable() {
		try {
			System.out.println("hasFinesPayable");
			Member instance = null;
			boolean expResult = false;
			boolean result = instance.hasFinesPayable();
			assertEquals(expResult, result);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of hasReachedFineLimit method, of class Member.
	 */
	@Test
	public void testHasReachedFineLimit() {
		try {
			System.out.println("hasReachedFineLimit");
			Member instance = null;
			boolean expResult = false;
			boolean result = instance.hasReachedFineLimit();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getFineAmount method, of class Member.
	 */
	@Test
	public void testGetFineAmount() {
		try {
			System.out.println("getFineAmount");
			Member instance = null;
			float expResult = 0.0F;
			float result = instance.getFineAmount();
			assertEquals(expResult, result, 0.0);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of addFine method, of class Member.
	 */
	@Test
	public void testAddFine() {
		try {
			System.out.println("addFine");
			float fine = 0.0F;
			Member instance = null;
			instance.addFine(fine);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of payFine method, of class Member.
	 */
	@Test
	public void testPayFine() {
		try {
			System.out.println("payFine");
			float payment = 0.0F;
			Member instance = null;
			instance.payFine(payment);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of addLoan method, of class Member.
	 */
	@Test
	public void testAddLoan() {
		try {
			System.out.println("addLoan");
			ILoan loan = null;
			Member instance = null;
			instance.addLoan(loan);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getLoans method, of class Member.
	 */
	@Test
	public void testGetLoans() {
		try {
			System.out.println("getLoans");
			Member instance = null;
			List<ILoan> expResult = null;
			List<ILoan> result = instance.getLoans();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of removeLoan method, of class Member.
	 */
	@Test
	public void testRemoveLoan() {
		try {
			System.out.println("removeLoan");
			ILoan loan = null;
			Member instance = null;
			instance.removeLoan(loan);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getState method, of class Member.
	 */
	@Test
	public void testGetState() {
		try {
			System.out.println("getState");
			Member instance = null;
			EMemberState expResult = null;
			EMemberState result = instance.getState();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getFirstName method, of class Member.
	 */
	@Test
	public void testGetFirstName() {
		try {
			System.out.println("getFirstName");
			Member instance = null;
			String expResult = "";
			String result = instance.getFirstName();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getLastName method, of class Member.
	 */
	@Test
	public void testGetLastName() {
		try {
			System.out.println("getLastName");
			Member instance = null;
			String expResult = "";
			String result = instance.getLastName();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getContactPhone method, of class Member.
	 */
	@Test
	public void testGetContactPhone() {
		try {
			System.out.println("getContactPhone");
			Member instance = null;
			String expResult = "";
			String result = instance.getContactPhone();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getEmailAddress method, of class Member.
	 */
	@Test
	public void testGetEmailAddress() {
		try {
			System.out.println("getEmailAddress");
			Member instance = null;
			String expResult = "";
			String result = instance.getEmailAddress();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of getID method, of class Member.
	 */
	@Test
	public void testGetID() {
		try {
			System.out.println("getID");
			Member instance = null;
			int expResult = 0;
			int result = instance.getID();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

	/**
	 * Test of toString method, of class Member.
	 */
	@Test
	public void testToString() {
		try {
			System.out.println("toString");
			Member instance = null;
			String expResult = "";
			String result = instance.toString();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null");
		}
	}

}

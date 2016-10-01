/*
 * Test for Book.java
 * JUnit testing by team 10
 */
package library.entities;

import java.util.Date;
import library.interfaces.entities.ELoanState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.IMember;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team10
 */
public class LoanTest {
    
    public LoanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of commit method, of class Loan.
     */
    @Test
    public void testCommit() {
    	try{
	        System.out.println("commit works fine");
	        int loanId = 0;
	        Loan instance = null;
	        instance.commit(loanId);
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of complete method, of class Loan.
     */
    @Test
    public void testComplete() {
    	try{
        System.out.println("complete");
        Loan instance = null;
        instance.complete();
    	}
    	
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of isOverDue method, of class Loan.
     */
    @Test
    public void testIsOverDue() {
    	try{
	        System.out.println("isOverDue");
	        Loan instance = null;
	        boolean expResult = false;
	        boolean result = instance.isOverDue();
	        assertEquals(expResult, result);
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of checkOverDue method, of class Loan.
     */
    @Test
    public void testCheckOverDue() {
    	try{
	        System.out.println("checkOverDue");
	        Date currentDate = null;
	        Loan instance = null;
	        boolean expResult = false;
	        boolean result = instance.checkOverDue(currentDate);
	        assertEquals(expResult, result);
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getBorrower method, of class Loan.
     */
    @Test
    public void testGetBorrower() {
    	try{
	        System.out.println("getBorrower");
	        Loan instance = null;
	        IMember expResult = null;
	        IMember result = instance.getBorrower();
	        assertEquals(expResult, result);
    	}
    	
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getBook method, of class Loan.
     */
    @Test
    public void testGetBook() {
    	try{
	        System.out.println("getBook");
	        Loan instance = null;
	        IBook expResult = null;
	        IBook result = instance.getBook();
	        assertEquals(expResult, result);
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getID method, of class Loan.
     */
    @Test
    public void testGetID() {
        try{
	    	System.out.println("getID");
	        Loan instance = null;
	        int expResult = 0;
	        int result = instance.getID();
	        assertEquals(expResult, result);
        }
        catch(NullPointerException e){
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of getState method, of class Loan.
     */
    @Test
    public void testGetState() {
        try{
	    	System.out.println("getState");
	        Loan instance = null;
	        ELoanState expResult = null;
	        ELoanState result = instance.getState();
	        assertEquals(expResult, result);
        }
        catch(NullPointerException e){
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of toString method, of class Loan.
     */
    @Test
    public void testToString() {
        try{
        	System.out.println("toString");
        	Loan instance = null;
            String expResult = "";
            String result = instance.toString();
            assertEquals(expResult, result);
        }
        
        catch(NullPointerException e){
        	fail("The method doesn't accept if the value is Null");
        }
        
    }
    
}

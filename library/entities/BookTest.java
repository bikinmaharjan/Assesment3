/*
 * Test for Book.java
 * JUnit testing by team 10
 */
package library.entities;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.ILoan;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team10
 */
public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of borrow method, of class Book.
     */
    @Test
    public void testBorrow() {
        try{
        	System.out.println("borrow works fine");
        	ILoan loan = null;
            Book instance = null;
            instance.borrow(loan);
        }
        catch(NullPointerException e){
        	
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of getLoan method, of class Book.
     */
    @Test
    public void testGetLoan() {
    	try{
	        System.out.println("getLoan works fine");
	        Book instance = null;
	        ILoan expResult = null;
	        ILoan result = instance.getLoan();
	        assertEquals(expResult, result);
    	}
        
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of returnBook method, of class Book.
     */
    @Test
    public void testReturnBook() {
    	try{
    		System.out.println("returnBook works fine");
    		boolean damaged = false;
    		Book instance = null;
    		instance.returnBook(damaged);
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of lose method, of class Book.
     */
    @Test
    public void testLose() {
    	try{
    		System.out.println("lose works fine");
    		Book instance = null;
    		instance.lose();
    	}
    	
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of repair method, of class Book.
     */
    @Test
    public void testRepair() {
        try{
        	System.out.println("repair works fine");
        	Book instance = null;
            instance.repair();
        }
        
        
        catch(NullPointerException e){
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of dispose method, of class Book.
     */
    @Test
    public void testDispose() {
    	try{
	        System.out.println("dispose is working fine");
	        Book instance = null;
	        instance.dispose();
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getState method, of class Book.
     */
    @Test
    public void testGetState() {
    	try{
	        System.out.println("getState works fine");
	        Book instance = null;
	        EBookState expResult = null;
	        EBookState result = instance.getState();
	        assertEquals(expResult, result);
    	}
    	
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
    	try{
        System.out.println("getAuthor works");
        Book instance = null;
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    	}
    	
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
    	try{
	        System.out.println("getTitle");
	        Book instance = null;
	        String expResult = "";
	        String result = instance.getTitle();
	        assertEquals(expResult, result);
    	}
    	
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
    	try{
	        System.out.println("toString");
	        Book instance = null;
	        String expResult = "";
	        String result = instance.toString();
	        assertEquals(expResult, result);
    	}
    	catch(NullPointerException e){
    		fail("The method doesn't accept if the value is Null");
    	}
    }
    
}

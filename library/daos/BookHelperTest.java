/*
 * JUnit testing by team 10
 */
package library.daos;

import library.interfaces.entities.IBook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team10
 */
public class BookHelperTest {
    
    public BookHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of makeBook method, of class BookHelper.
     */
    @Test
    public void testMakeBook() {
    	try{
        System.out.println("makeBook");
        String author = "";
        String title = "";
        String callNumber = "";
        int id = 0;
        BookHelper instance = new BookHelper();
        IBook expResult = null;
        IBook result = instance.makeBook(author, title, callNumber, id);
        assertEquals(expResult, result);
    	}
    	
        catch(IllegalArgumentException e){
        	fail("The test fails if the user enters inappropriate argument");
        }
    }
    
}

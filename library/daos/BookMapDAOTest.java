/*
 * JUnit testing by Team 10
 */
package library.daos;

import java.util.List;
import library.interfaces.entities.IBook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team10
 */
public class BookMapDAOTest {

	public BookMapDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of addBook method, of class BookMapDAO.
	 */
	@Test
	public void testAddBook() {
		try {
			System.out.println("addBook");
			String author = "";
			String title = "";
			String callNo = "";
			BookMapDAO instance = null;
			IBook expResult = null;
			IBook result = instance.addBook(author, title, callNo);
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of getBookByID method, of class BookMapDAO.
	 */
	@Test
	public void testGetBookByID() {
		try {
			System.out.println("getBookByID");
			int id = 0;
			BookMapDAO instance = null;
			IBook expResult = null;
			IBook result = instance.getBookByID(id);
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of listBooks method, of class BookMapDAO.
	 */
	@Test
	public void testListBooks() {
		try {
			System.out.println("listBooks");
			BookMapDAO instance = null;
			List<IBook> expResult = null;
			List<IBook> result = instance.listBooks();
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of findBooksByAuthor method, of class BookMapDAO.
	 */
	@Test
	public void testFindBooksByAuthor() {
		try {
			System.out.println("findBooksByAuthor");
			String author = "";
			BookMapDAO instance = null;
			List<IBook> expResult = null;
			List<IBook> result = instance.findBooksByAuthor(author);
			assertEquals(expResult, result);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of findBooksByTitle method, of class BookMapDAO.
	 */
	@Test
	public void testFindBooksByTitle() {
		try {
			System.out.println("findBooksByTitle");
			String title = "";
			BookMapDAO instance = null;
			List<IBook> expResult = null;
			List<IBook> result = instance.findBooksByTitle(title);
			assertEquals(expResult, result);
		} catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

	/**
	 * Test of findBooksByAuthorTitle method, of class BookMapDAO.
	 */
	@Test
	public void testFindBooksByAuthorTitle() {
		try {
			System.out.println("findBooksByAuthorTitle");
			String author = "";
			String title = "";
			BookMapDAO instance = null;
			List<IBook> expResult = null;
			List<IBook> result = instance.findBooksByAuthorTitle(author, title);
			assertEquals(expResult, result);
		}

		catch (NullPointerException e) {
			fail("The method doesn't accept if the value is Null.");
		}
	}

}

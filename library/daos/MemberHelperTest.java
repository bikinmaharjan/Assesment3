/*
 * JUnit testing by Team10
 */
package library.daos;

import library.interfaces.entities.IMember;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team10
 */
public class MemberHelperTest {

	public MemberHelperTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
     * Test of makeMember method, of class MemberHelper.
     */
    @Test
    public void testMakeMember() {
    	try{
        System.out.println("makeMember");
        String firstName = "";
        String lastName = "";
        String contactPhone = "";
        String emailAddress = "";
        int id = 0;
        MemberHelper instance = new MemberHelper();
        IMember expResult = null;
        IMember result = instance.makeMember(firstName, lastName, contactPhone, emailAddress, id);
        assertEquals(expResult, result);
    	}
    	catch (IllegalArgumentException e) {
			fail("The test fails if the user enters inappropriate argument");
    	}
    }
}

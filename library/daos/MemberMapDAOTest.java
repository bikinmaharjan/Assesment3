package library.daos;

import java.util.List;
import library.interfaces.entities.IMember;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team 10
 */
public class MemberMapDAOTest {
    
    public MemberMapDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addMember method, of class MemberMapDAO.
     */
    @Test
    public void testAddMember() {
    	try{
        System.out.println("addMember");
        String firstName = "";
        String lastName = "";
        String contactPhone = "";
        String emailAddress = "";
        MemberMapDAO instance = null;
        IMember expResult = null;
        IMember result = instance.addMember(firstName, lastName, contactPhone, emailAddress);
        assertEquals(expResult, result);
    	}
    	
    	catch (NullPointerException e) {
    		fail("The method doesn't accept if the value is Null");
    	}
    }

    /**
     * Test of getMemberByID method, of class MemberMapDAO.
     */
    @Test
    public void testGetMemberByID() {
        try{
    	System.out.println("getMemberByID");
        int id = 0;
        MemberMapDAO instance = null;
        IMember expResult = null;
        IMember result = instance.getMemberByID(id);
        assertEquals(expResult, result);
        }
        catch (NullPointerException e) {
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of listMembers method, of class MemberMapDAO.
     */
    @Test
    public void testListMembers() {
        try{
    	System.out.println("listMembers");
        MemberMapDAO instance = null;
        List<IMember> expResult = null;
        List<IMember> result = instance.listMembers();
        assertEquals(expResult, result);
        }
        catch (NullPointerException e) {
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of findMembersByLastName method, of class MemberMapDAO.
     */
    @Test
    public void testFindMembersByLastName() {
        try{
    	System.out.println("findMembersByLastName");
        String lastName = "";
        MemberMapDAO instance = null;
        List<IMember> expResult = null;
        List<IMember> result = instance.findMembersByLastName(lastName);
        assertEquals(expResult, result);
        }
        catch (NullPointerException e) {
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of findMembersByEmailAddress method, of class MemberMapDAO.
     */
    @Test
    public void testFindMembersByEmailAddress() {
        try{
    	System.out.println("findMembersByEmailAddress");
        String emailAddress = "";
        MemberMapDAO instance = null;
        List<IMember> expResult = null;
        List<IMember> result = instance.findMembersByEmailAddress(emailAddress);
        assertEquals(expResult, result);
        }
        
        catch (NullPointerException e) {
        	fail("The method doesn't accept if the value is Null");
        }
    }

    /**
     * Test of findMembersByNames method, of class MemberMapDAO.
     */
    @Test
    public void testFindMembersByNames() {
        try{
        System.out.println("findMembersByNames");
        String firstName = "";
        String lastName = "";
        MemberMapDAO instance = null;
        List<IMember> expResult = null;
        List<IMember> result = instance.findMembersByNames(firstName, lastName);
        assertEquals(expResult, result);
        }
        catch (NullPointerException e) {
        	fail("The method doesn't accept if the value is Null");
        }
    }
    
}

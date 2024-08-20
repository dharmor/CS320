// David S. Harmor
// 07-15-2024
// SNHU CS320 : Module 3

package ContactsClass;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


public class ContactTest {
	
	
	/**************************************************************************************************************************/
	// ContactID Tests
	// Requirements:
    // The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
    // The contact ID shall not be null and shall not be updatable.
	
    @Test
    public void testContactCreationSuccess() {
        // Test successful creation of a contact
    	Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
        assertAll("Inital contact creation",
    	()-> assertNotNull(contact), // Test if Contact object was created
        // Test each field was correctly set
    	()-> assertTrue(contact.getContactID().equals("ID123456")),
    	()-> assertTrue(contact.getFirstName().equals("Tommy"),"Contact should be Tommy"),
    	()-> assertTrue(contact.getLastName().equals("Tutone")),
    	()-> assertTrue(contact.getPhone().equals("5858675309"),"Phone should be 5858675309"),
    	()-> assertTrue(contact.getAddress().equals("2061 Nowhere Dr")));
        
    }
          
    
    @Test
    public void testContactIDFailure() {
        // Test creation of a contact with a null contactID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null,"Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
        });
    }

    /**************************************************************************************************************************/
    // First Name Tests
    // Requirements:
    // The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
    // The contact ID shall not be null and shall not be updatable.
    
    @Test    
    public void testSetFirstNameNullFailure() {
        // Test setting an invalid first name
       Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
       assertThrows(IllegalArgumentException.class, () -> {
           contact.setFirstName(null);
        });
       assertNotNull(contact.getFirstName());
              
    }
    
    @Test    
    public void testFirstNameLengthFailure() {
        // Test setting an invalid first name
        Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
       assertThrows(IllegalArgumentException.class, () -> {
           contact.setFirstName("Tommy1234567");
        });
       assertNotNull(contact.getFirstName());
    }
    
    /**************************************************************************************************************************/
    // Last Name Tests
    // Requirements
    // The contact object shall have a required lastName String field that cannot be longer than 10 characters. 
    // The lastName field shall not be null.
    
    
    @Test    
    public void testLastNameLengthFailure() {
        // Test setting an invalid first name
        Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
       assertThrows(IllegalArgumentException.class, () -> {
           contact.setLastName("Tutone12345");
        });
       assertNotNull(contact.getLastName());
    }
    
    @Test    
    public void testSetLastNameNullFailure() {
        // Test setting an invalid last name
        Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
       assertThrows(IllegalArgumentException.class, () -> {
           contact.setLastName(null);
        });
       assertNotNull(contact.getLastName());
              
    }
    
    /**************************************************************************************************************************/
    // Phone Tests
    // Requirements:    
    // The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
    // The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
 
    @Test    
    public void testSetPhoneLengthFailure() {
        // Test setting for an invalid phone number length
       Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
       assertThrows(IllegalArgumentException.class, () -> {
           contact.setPhone("58586753097");
        });
       assertNotNull(contact.getPhone());
    }
    
    @Test    
    public void testSetPhoneNumberNullFailure() {
        // Test setting an invalid last name
        Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
       assertThrows(IllegalArgumentException.class, () -> {
           contact.setPhone(null);
        });
       assertNotNull(contact.getPhone());
              
    }
    
    /**************************************************************************************************************************/
    // Address Tests
    // Requirements:    
    // The contact object shall have a required address field that must be no longer than 30 characters. 
    // The address field shall not be null.
    
       @Test    
       public void testSetAddressLengthFailure() {
           // Test setting for an invalid phone number length
          Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
          assertThrows(IllegalArgumentException.class, () -> {
              contact.setAddress("2061 Nowhere Dr12345678901234567");
           });  
          assertNotNull(contact.getAddress());              
       }
       
       @Test    
       public void testSetAdressNullFailure() {
           // Test setting an invalid last name
           Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
          assertThrows(IllegalArgumentException.class, () -> {
              contact.setAddress(null);
           });
          assertNotNull(contact.getAddress());
                 
       }
   
}

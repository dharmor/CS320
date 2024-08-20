// David S. Harmor
// 07-15-2024
// SNHU CS320 : Module 3

package ContactsClass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ContactServiceTest {

    private ContactService service;
    
    /**************************************************************************************************************************/
    // Setup needed prior to each test
    
    @BeforeEach
    public void setUp() {
        service = new ContactService(); // Create service object for each test
    }
    
    
    /**************************************************************************************************************************/
    // Clears the tasks HashMap after each test to ensure test isolation.
    // @throws Exception	
   
	 @AfterEach
	 void tearDown() throws Exception {
		 service.ClearContacts();		 
	 }
    
    /**************************************************************************************************************************/
    // Test for adding a valid Contact 
    
    @Test
    public void testAddContactSuccess() {

    	// Create new Contact
        Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
        
        assertNotNull(service);  // Check that the database service is valid
        
        service.addContact(contact); // Add Contact to in memory database
        
        // Check that all fields were added correctly
        assertEquals("ID123456", contact.getContactID());
        assertEquals("Tommy", contact.getFirstName());
        assertEquals("Tutone", contact.getLastName());
        assertEquals("5858675309", contact.getPhone());
        assertEquals("2061 Nowhere Dr", contact.getAddress());
    }

    /**************************************************************************************************************************/
    // Test for unique Contact ID
    // Requirements
    // The contact service shall be able to add contacts with a unique ID.
    
    @Test
    public void testAddContactFailure() {
        Contact contact = new Contact("ID123456", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact); // Attempting to add duplicate ID's
        });
    }

    /**************************************************************************************************************************/
    // Test for deleting a Contact based on Contact ID
    // Requirements:
    // The contact service shall be able to delete contacts per contact ID.

    @Test
    public void testDeleteContact() {
    	// Create new Contact
        Contact contact = new Contact("ID124322", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
        service.addContact(contact); // Add new Contact to database
        service.deleteContact("ID124322"); // Delete Contact
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("ID124322"); // Attempting to delete a non-existent contact
        });
        Contact testContact = service.getContact("ID124322"); // Attempt to get deleted contact
        assertNull(testContact); // If the return value is null then the delete was successful
        
    }
    

    /**************************************************************************************************************************/
    // Requirements:
    // The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
    //    firstName
    //    lastName
    //    Number
    //    Address

    @Test
    public void testUpdateContactSuccess() {
    	// Create new Contact
        Contact contact = new Contact("ID74508", "Tommy", "Tutone", "5858675309", "2061 Nowhere Dr");
        
        // Add contact to in memory database
        service.addContact(contact);
        
        //Update contact fields with new data using previous ContactID
        service.updateContact("ID74508", "Kimbra", "Lee", "7163280081", "2061 Tomorrow Dr");
        
        // Check that the updated data is correct
        assertEquals("ID74508", contact.getContactID()); // This field is not updatable, so the value should not change
        assertEquals("Kimbra", contact.getFirstName());
        assertEquals("Lee", contact.getLastName());
        assertEquals("7163280081", contact.getPhone());
        assertEquals("2061 Tomorrow Dr", contact.getAddress());
       
    }

   
}

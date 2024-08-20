// David S. Harmor
// 07-15-2024
// SNHU CS320 : Module 3

package ContactsClass;

import java.util.HashMap;
import java.util.Map;


public class ContactService {

    
    // Create an empty hash map by declaring object of string and Contact type
    private final Map<String, Contact> contacts = new HashMap<>();
    
    /**************************************************************************************************************************/
    // Requirements:
    // The contact service shall be able to add contacts with a unique ID.
  
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) { // Test if contactID exists or is null
            throw new IllegalArgumentException("Contact exists or invalid");
        }
        contacts.put(contact.getContactID(), contact); // Add contact to in memory storage
    }

    /**************************************************************************************************************************/
    // Requirements:
    // The contact service shall be able to delete contacts per contact ID
    
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {  // Test if contacts exists
            throw new IllegalArgumentException("Contact does not exist");
        }
        contacts.remove(contactId); // Delete contact from memory storage       
    }

    /**************************************************************************************************************************/
    // Requirements:
    // The contact service shall be able to update contact fields per contact ID. 
    // The following fields are updatable:
    //    firstName
    //    lastName
    //    phone number
    //    address    
    
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        
    	Contact contact = contacts.get(contactId);   // Get Contact by ID  
        
    	//Update Contact's information
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);         
    }
    
    /**************************************************************************************************************************/
    // Get Contact base on contactID provided
    public Contact getContact(String contactId) {
        
    	Contact contact = contacts.get(contactId);      // Get contact based on ID
        
        return contact;
    }
    
    /**************************************************************************************************************************/
    // Remove all contacts
    
    public void ClearContacts() {
        
    	contacts.clear();        
        
    }
}

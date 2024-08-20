// David S. Harmor
// 07-15-2024
// SNHU CS320 : Module 3

package ContactsClass;

public class Contact {
	
  // Requirements Fields 
  private String contactID; // Contact Unique identifier  *not modifiability after initial set up
  private String firstName; // Contact first name
  private String lastName;  // Contact last name
  private String phone;     // Contact phone number
  private String address;   // Contact address

  /**************************************************************************************************************************/
  // Initialize Contact object 
  // ContactID can only be set up on initial creation of a Contact object
  
  public Contact(String contactID, String firstName, String lastName, String phone, String address) 
  {
	   setContactID(contactID);
	   setFirstName(firstName);
	   setLastName(lastName);
	   setPhone(phone);
	   setAddress(address);     
  }

  /**************************************************************************************************************************/
  // ContactID
  // Requirements:
  // The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
  // The contact ID shall not be null and shall not be updatable.
      
  private void setContactID(String contactID) 
  {
      if (contactID == null ||contactID.length() > 10) 
      {
          throw new IllegalArgumentException("Invalid Contact ID");
      }
      this.contactID = contactID;
  }

  // Get contact ID
  public String getContactID()
  {
      return contactID;
  }

  /**************************************************************************************************************************/
  // First Name
  // Requirements:
  // The contact object shall have a required firstName String field that cannot be longer than 10 characters.
  // The firstName field shall not be null.
  
  public void setFirstName(String firstName) 
  {
      if (firstName == null || firstName.length() > 10) 
      {
          throw new IllegalArgumentException("Invalid first name");
      }
      this.firstName = firstName;
  }

  // Get first name
  public String getFirstName() 
  {
      return firstName;
  }
  
  /**************************************************************************************************************************/
  // Last Name
  // Requirements:
  // The contact object shall have a required lastName String field that cannot be longer than 10 characters.
  // The lastName field shall not be null.

  public void setLastName(String lastName) 
  {
      if (lastName == null || lastName.length() > 10) 
      {
        throw new IllegalArgumentException("Invalid last name");
      }
    	  
      this.lastName = lastName;
  }
  
  // Get last name
  public String getLastName() 
  {	  
      return lastName;
  }

 
  /**************************************************************************************************************************/
  // Phone Number
  // Requirements:
  // The contact object shall have a required phone String field that must be exactly 10 digits. 
  // The phone field shall not be null.

  public void setPhone(String phone) 
  {
      if (phone == null || phone.length() != 10 ) 
      {
          throw new IllegalArgumentException("Invalid phone number");
      }
      this.phone = phone;
  }

  // Get phone number
  public String getPhone() 
  {
      return phone;
  }
  
  /**************************************************************************************************************************/
  // Address
  // Requirements:
  // The contact object shall have a required address field that must be no longer than 30 characters.
  // The address field shall not be null.
  
  public void setAddress(String address) 
  {
      if (address == null || address.length() > 30) 
      {
          throw new IllegalArgumentException("Invalid address");
      }
      this.address = address;
  }
  
  // Get address
  public String getAddress() 
  {
      return address;
  }
}

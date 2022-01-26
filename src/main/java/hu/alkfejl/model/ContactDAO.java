package hu.alkfejl.model;

import hu.alkfejl.model.bean.Contact;

import java.util.List;

public interface ContactDAO {
	
	boolean addContact(Contact c);

	List<Contact> listContact();

	boolean delete(int contactId);

	Contact getContactById(int contactId);

	Contact updateContact(Contact contact);

}

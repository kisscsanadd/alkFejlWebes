package hu.alkfejl.model;


import hu.alkfejl.model.bean.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ContactDAODBImpl implements ContactDAO {

  private static final String CONN = "jdbc:sqlite:contact.db";
  private static final String ADD_CONTACT = "INSERT INTO contact (name, birth, email, phone, address, organization, position) VALUES (?,?,?,?,?,?,?);";
  private static final String LIST_CONTACT = "SELECT * FROM contact;";
  private static final String DELETE_CONTACT = "DELETE FROM Contact WHERE id=?;";
  private static final String UPDATE_CONTACT = "UPDATE Contact SET name=?, birth=?, email=?, phone=? , address=? , organization=? , position=? WHERE id=?;";
  private static final String GET_CONTACT_BY_ID = "SELECT * FROM Contact WHERE id=?;";

  private static ContactDAODBImpl instance;




  public static ContactDAODBImpl getInstance() {
    return instance;
  }

  public ContactDAODBImpl() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public boolean addContact(Contact contact) {
    
    try (Connection c = DriverManager.getConnection(CONN); PreparedStatement pst = c.prepareStatement(ADD_CONTACT)) {

      pst.setString(1, contact.getName());
      pst.setString(2, contact.getBirth());
      pst.setString(3, contact.getEmail());
      pst.setString(4, contact.getPhone());
      pst.setString(5, contact.getAddress());
      pst.setString(6, contact.getOrganization());
      pst.setString(7, contact.getPosition());

      return pst.executeUpdate() == 1;
      
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Contact> listContact() {
    
    List<Contact> contacts = new ArrayList<Contact>();

    try (Connection c = DriverManager.getConnection(CONN); Statement st = c.createStatement()) {

      ResultSet rs = st.executeQuery(LIST_CONTACT);

      while (rs.next()) {
        contacts.add(new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return contacts;

  }

  @Override
  public boolean delete(int contactId) {
    try (Connection c = DriverManager.getConnection(CONN);
         PreparedStatement pst = c.prepareStatement(DELETE_CONTACT)) {

      pst.setInt(1, contactId);

      return pst.executeUpdate() == 1;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }


  }

  @Override
  public Contact getContactById(int contactId) {
    try (Connection c = DriverManager.getConnection(CONN);
         PreparedStatement pst = c.prepareStatement(GET_CONTACT_BY_ID)) {

      pst.setInt(1, contactId);
      ResultSet rs = pst.executeQuery();

      while (rs.next()) {
        Contact contact = new Contact();
        contact.setId(rs.getInt("id"));
        contact.setName(rs.getString("name"));
        contact.setBirth(rs.getString("birth"));
        contact.setEmail(rs.getString("email"));
        contact.setPhone(rs.getString("phone"));
        contact.setAddress(rs.getString("address"));
        contact.setOrganization(rs.getString("organization"));
        contact.setPosition(rs.getString("position"));

        return contact;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Contact updateContact(Contact contact) {
    try (Connection c = DriverManager.getConnection(CONN);
         PreparedStatement pst = c.prepareStatement(UPDATE_CONTACT)) {

      pst.setString(1, contact.getName());
      pst.setString(2, contact.getBirth());
      pst.setString(3, contact.getEmail());
      pst.setString(4, contact.getPhone());
      pst.setString(5, contact.getAddress());
      pst.setString(6, contact.getOrganization());
      pst.setString(7, contact.getPosition());
      pst.setInt(8, contact.getId());

      pst.executeUpdate();
      return contact;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}

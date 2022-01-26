package hu.alkfejl.controller;

import hu.alkfejl.model.ContactDAO;
import hu.alkfejl.model.ContactDAODBImpl;
import hu.alkfejl.model.bean.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ContactDAO dao = new ContactDAODBImpl();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("utf-8");
    Contact c = new Contact();

    try {
      c.setName(request.getParameter("name"));
      c.setEmail(request.getParameter("email"));
      c.setAddress(request.getParameter("address"));
      c.setBirth(request.getParameter("birth"));
      c.setPhone(request.getParameter("phone"));
      c.setOrganization(request.getParameter("organization"));
      c.setPosition(request.getParameter("position"));

      if(dao.addContact(c)) {
        response.sendRedirect("pages/list_contact.jsp");
      }
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("contactList", dao.listContact());
  }
}

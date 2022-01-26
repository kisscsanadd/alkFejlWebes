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

@WebServlet("/UpdateContact")
public class UpdateContact extends HttpServlet {

    private ContactDAO dao = ContactDAODBImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contactIdStr = req.getParameter("contactId");

        if(contactIdStr != null && !contactIdStr.isEmpty()){
            int contactId = Integer.parseInt(contactIdStr);
            Contact contact = dao.getContactById(contactId);
            req.setAttribute("contact", contact);
        }

        req.getRequestDispatcher("pages/add_contact.jsp").forward(req, resp);

    }
}

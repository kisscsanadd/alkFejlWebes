package hu.alkfejl.controller;

import hu.alkfejl.model.ContactDAO;
import hu.alkfejl.model.ContactDAODBImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {

    private ContactDAO dao = ContactDAODBImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int contactId = Integer.parseInt(req.getParameter("contactId"));
        dao.delete(contactId);
        resp.sendRedirect("pages/list_contact.jsp");

    }
}

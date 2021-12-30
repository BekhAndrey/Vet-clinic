package com.bekh.vetclinic.servlet;

import com.bekh.vetclinic.dao.PersonDAO;
import com.bekh.vetclinic.dao.PersonDAOImpl;
import com.bekh.vetclinic.model.PersonEntity;
import com.bekh.vetclinic.util.PasswordUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private final PersonDAO personDAO = new PersonDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.html");
        rd.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PersonEntity person = personDAO.findByEmail(email);
        if(PasswordUtils.verifyUserPassword(password, person.getPassword())){
            HttpSession session = req.getSession();
            session.setAttribute("username", email);
            resp.sendRedirect("persons");
        } else resp.sendRedirect("login");
    }
}

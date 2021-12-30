package com.bekh.vetclinic.servlet;

import com.bekh.vetclinic.dao.PersonDAO;
import com.bekh.vetclinic.dao.PersonDAOImpl;
import com.bekh.vetclinic.model.PersonEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="PersonServlet", urlPatterns = "/persons")
public class PersonServlet extends HttpServlet {

    private PersonDAO personDAO = new PersonDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.writeValue(out, personDAO.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        PersonEntity newPerson = mapper.readValue(req.getReader(), PersonEntity.class);
        personDAO.save(newPerson);
        mapper.writeValue(out,newPerson);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        PersonEntity personToUpdate = mapper.readValue(req.getReader(), PersonEntity.class);
        personDAO.update(personToUpdate);
        mapper.writeValue(out,personToUpdate);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        PersonEntity personToDelete = mapper.readValue(req.getReader(), PersonEntity.class);
        personDAO.delete(personToDelete);
        mapper.writeValue(out,personToDelete);
    }
}

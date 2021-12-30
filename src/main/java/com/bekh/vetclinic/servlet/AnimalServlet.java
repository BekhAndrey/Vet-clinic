package com.bekh.vetclinic.servlet;

import com.bekh.vetclinic.dao.AnimalDAO;
import com.bekh.vetclinic.dao.AnimalDAOImpl;
import com.bekh.vetclinic.dao.PersonDAO;
import com.bekh.vetclinic.dao.PersonDAOImpl;
import com.bekh.vetclinic.model.AnimalEntity;
import com.bekh.vetclinic.model.PersonEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AnimalServlet", urlPatterns = "/animals")
public class AnimalServlet extends HttpServlet {

    private final PersonDAO personDAO = new PersonDAOImpl();
    private final AnimalDAO animalDAO = new AnimalDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.writeValue(out, animalDAO.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        AnimalEntity newAnimal = mapper.readValue(req.getReader(), AnimalEntity.class);
        PersonEntity owner = personDAO.findById(newAnimal.getOwner().getId());
        newAnimal.setOwner(owner);
        animalDAO.save(newAnimal);
        mapper.writeValue(out,newAnimal);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        AnimalEntity animalToUpdate = mapper.readValue(req.getReader(), AnimalEntity.class);
        animalDAO.update(animalToUpdate);
        mapper.writeValue(out,animalToUpdate);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        AnimalEntity animalToDelete = mapper.readValue(req.getReader(), AnimalEntity.class);
        animalDAO.delete(animalToDelete);
        mapper.writeValue(out,animalToDelete);
    }
}

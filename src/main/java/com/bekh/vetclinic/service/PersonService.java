package com.bekh.vetclinic.service;

import com.bekh.vetclinic.dao.PersonDAO;
import com.bekh.vetclinic.dao.PersonDAOImpl;
import lombok.NoArgsConstructor;
import com.bekh.vetclinic.model.PersonEntity;

import java.util.List;

@NoArgsConstructor
public class PersonService {
    private final PersonDAO noteDAO = new PersonDAOImpl();

    public PersonEntity findById(Long id){
        return noteDAO.findById(id);
    }

    public void save(PersonEntity person){
        noteDAO.save(person);
    }

    public void update(PersonEntity person){
        noteDAO.update(person);
    }

    public void delete(PersonEntity person){
        noteDAO.delete(person);
    }

    public List<PersonEntity> findAll(){
        return noteDAO.findAll();
    }
}

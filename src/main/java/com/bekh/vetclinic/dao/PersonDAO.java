package com.bekh.vetclinic.dao;

import com.bekh.vetclinic.model.PersonEntity;

import java.util.List;

public interface PersonDAO {
    PersonEntity findById(Long id);
    PersonEntity findByEmail(String email);
    void save(PersonEntity person);
    void update(PersonEntity person);
    void delete(PersonEntity person);
    List<PersonEntity> findAll();
}

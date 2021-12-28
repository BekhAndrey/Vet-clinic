package com.bekh.vetclinic.dao;

import com.bekh.vetclinic.model.AnimalEntity;

import java.util.List;

public interface AnimalDAO {
    AnimalEntity findById(Long id);
    void save(AnimalEntity animal);
    void update(AnimalEntity animal);
    void delete(AnimalEntity animal);
    List<AnimalEntity> findAll();
}

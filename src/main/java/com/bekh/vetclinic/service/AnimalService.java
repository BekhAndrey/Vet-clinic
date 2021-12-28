package com.bekh.vetclinic.service;

import com.bekh.vetclinic.dao.AnimalDAO;
import com.bekh.vetclinic.dao.AnimalDAOImpl;
import lombok.NoArgsConstructor;
import com.bekh.vetclinic.model.AnimalEntity;

import java.util.List;

@NoArgsConstructor
public class AnimalService {
    private final AnimalDAO animalDAO = new AnimalDAOImpl();

    public AnimalEntity findById(Long id){
        return animalDAO.findById(id);
    }

    public void save(AnimalEntity animal){
        animalDAO.save(animal);
    }

    public void update(AnimalEntity animal){
        animalDAO.update(animal);
    }

    public void delete(AnimalEntity animal){
        animalDAO.delete(animal);
    }

    public List<AnimalEntity> findAll(){
        return animalDAO.findAll();
    }
}

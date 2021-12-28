package dao;

import model.PersonEntity;

import java.util.List;

public interface PersonDAO {
    PersonEntity findById(Long id);
    void save(PersonEntity person);
    void update(PersonEntity person);
    void delete(PersonEntity person);
    List<PersonEntity> findAll();
}

package com.bekh.vetclinic.dao;

import com.bekh.vetclinic.model.NoteEntity;

import java.util.List;

public interface NoteDAO {
    NoteEntity findById(Long id);
    void save(NoteEntity note);
    void update(NoteEntity note);
    void delete(NoteEntity note);
    List<NoteEntity> findAll();
}

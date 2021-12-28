package com.bekh.vetclinic.service;

import com.bekh.vetclinic.dao.NoteDAO;
import com.bekh.vetclinic.dao.NoteDAOImpl;
import lombok.NoArgsConstructor;
import com.bekh.vetclinic.model.NoteEntity;

import java.util.List;

@NoArgsConstructor
public class NoteService {
    private final NoteDAO noteDAO = new NoteDAOImpl();

    public NoteEntity findById(Long id){
        return noteDAO.findById(id);
    }

    public void save(NoteEntity note){
        noteDAO.save(note);
    }

    public void update(NoteEntity note){
        noteDAO.update(note);
    }

    public void delete(NoteEntity note){
        noteDAO.delete(note);
    }

    public List<NoteEntity> findAll(){
        return noteDAO.findAll();
    }
}

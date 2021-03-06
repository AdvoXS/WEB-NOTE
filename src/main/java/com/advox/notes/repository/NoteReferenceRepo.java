package com.advox.notes.repository;

import com.advox.notes.model.NoteGroup;
import com.advox.notes.model.NoteReference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteReferenceRepo extends CrudRepository<NoteReference, Long> {
    NoteReference getById(long id);

    List<NoteReference> findAll();

    List<NoteReference> getByRefGroup(NoteGroup group);

    NoteReference deleteById(long id);
}

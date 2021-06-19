package com.advox.notes.repository;

import com.advox.notes.model.NoteGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteGroupRepo extends CrudRepository<NoteGroup, Long> {
        NoteGroup getById(long id);
        NoteGroup getByName(String name);

        List<NoteGroup> findAll();
}

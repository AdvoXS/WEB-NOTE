package com.advox.notes.repository;

import com.advox.notes.model.NoteGroup;
import com.advox.notes.model.NoteTask;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteTaskRepo extends CrudRepository<NoteTask, Long> {
    NoteTask getById(long id);
    List<NoteTask> getByTaskGroup(NoteGroup group);
}

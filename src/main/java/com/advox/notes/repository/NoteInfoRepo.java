package com.advox.notes.repository;

import com.advox.notes.model.NoteGroup;
import com.advox.notes.model.NoteInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteInfoRepo extends CrudRepository<NoteInfo, Long> {
    NoteInfo getById(long id);
    List<NoteInfo> getByNoteGroup(NoteGroup group);
}

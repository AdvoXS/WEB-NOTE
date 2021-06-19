package com.advox.notes.controller;

import com.advox.notes.model.NoteGroup;
import com.advox.notes.repository.NoteGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteGroupDataController {
    @Autowired
    NoteGroupRepo groupRepo;

    @GetMapping(value = "/group")
    public List<NoteGroup> getAllGroups(){
        return groupRepo.findBy();
    }
}

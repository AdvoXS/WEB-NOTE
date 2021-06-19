package com.advox.notes.controller;

import com.advox.notes.model.NoteReference;
import com.advox.notes.repository.NoteGroupRepo;
import com.advox.notes.repository.NoteReferenceRepo;
import com.advox.notes.service.NoteReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reference")
public class NoteReferenceDataController {
    private final NoteReferenceRepo refRepo;
    private final NoteGroupRepo groupRepo;
    @Autowired
    NoteReferenceService refService;

    public NoteReferenceDataController(NoteReferenceRepo refRepo, NoteGroupRepo groupRepo) {
        this.refRepo = refRepo;
        this.groupRepo = groupRepo;
    }


    @GetMapping
    public List<NoteReference> getRefs() {
        List<NoteReference> refs = refRepo.findAll();
        return refs;
    }

    @GetMapping("/{id}")
    public NoteReference getRefById(@PathVariable long id) {
        return refRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createRef(@RequestBody NoteReference reference) {
        if (reference != null) {
            if (reference.getRefGroup() == null) {
                reference.setRefGroup(groupRepo.getById(1));
            }
            reference.setCreateDate(LocalDate.now());
            String refString = refService.getReference(reference.getReference());
            reference.setReference(refString);
            NoteReference savedReference = refRepo.save(reference);
            try {
                return ResponseEntity.created(new URI("/reference/" + savedReference.getId())).body(savedReference);
            } catch (URISyntaxException e) {
                e.printStackTrace();
                return null;
            }

        } else return ResponseEntity.status(412).body("Запрещенное создание объекта");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRefById(@PathVariable Long id, @RequestBody NoteReference reference) {
        NoteReference currentRef = refRepo.findById(id).orElseThrow(RuntimeException::new);
        currentRef.setHead(reference.getHead());
        currentRef.setReference(reference.getReference());
        currentRef.setRefGroup(reference.getRefGroup());
        currentRef.setCreateDate(reference.getCreateDate());
        currentRef.setDescription(reference.getDescription());
        currentRef.setId(reference.getId());
        currentRef = refRepo.save(currentRef);
        return ResponseEntity.ok(currentRef);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRefById(@PathVariable Long id) {
        refRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

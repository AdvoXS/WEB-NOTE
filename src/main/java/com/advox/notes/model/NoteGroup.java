package com.advox.notes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Группа
 */
@Data
@Entity
@Table(name = "note_group", schema = "public")
public class NoteGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy="taskGroup", cascade = CascadeType.ALL)
    private Set<NoteTask> noteTasks;

    @OneToMany(mappedBy="noteGroup", cascade = CascadeType.ALL)
    private Set<NoteInfo> noteInfos;

    @OneToMany(mappedBy="refGroup", cascade = CascadeType.ALL)
    private Set<NoteReference> noteReferences;
}

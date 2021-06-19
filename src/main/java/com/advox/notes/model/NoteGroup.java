package com.advox.notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Группа
 */
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "note_group", schema = "public")
public class NoteGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "taskGroup", cascade = CascadeType.PERSIST)
    private Set<NoteTask> noteTasks;
    @JsonIgnore
    @OneToMany(mappedBy = "noteGroup", cascade = CascadeType.PERSIST)
    private Set<NoteInfo> noteInfos;
    @JsonIgnore
    @OneToMany(mappedBy = "refGroup", cascade = CascadeType.PERSIST)
    private Set<NoteReference> noteReferences;

}

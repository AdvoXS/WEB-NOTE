package com.advox.notes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Заметка
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "note", schema = "public")
public class NoteInfo {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private NoteGroup noteGroup;

    private String head;

    private String body;

    private LocalDate createDate;
}

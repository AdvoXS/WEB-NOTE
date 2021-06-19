package com.advox.notes.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Ссылка
 */
@Data
@Entity
@Table(name = "reference", schema = "public")
public class NoteReference {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private NoteGroup refGroup;

    private LocalDate createDate;

    private String head;

    private String description;

    private String reference;


}

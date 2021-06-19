package com.advox.notes.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Задача
 */
@Data
@Entity
@Table(name = "task", schema = "public")
public class NoteTask {
    @Id
    @Generated
    private long id;

    @ManyToOne
    @JoinColumn(name="group_id", nullable=false)
    private NoteGroup taskGroup;

    private int priority;

    private int type;

    private double progress;

    private String description;

    private LocalDate createDate;

    private LocalDate endDate;
}

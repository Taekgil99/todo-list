package com.example.todoapp.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tasks {
    public static final String COLUMN_TITLE_NAME = "title";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long tasksId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long order;

    @Column(nullable = false)
    private boolean completed;

    public Object getCompleted() {
        this.completed = completed;
    }
}
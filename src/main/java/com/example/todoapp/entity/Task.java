package com.example.todoapp.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long taskId;

    @Column(nullable = false)
    private String title;

    @Column(name = "orders", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

}
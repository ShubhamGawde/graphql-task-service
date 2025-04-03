package com.taskmanagement.taskservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;  // Enum: TODO, IN_PROGRESS, COMPLETED

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;  // Enum: LOW, MEDIUM, HIGH

    private LocalDateTime dueDate;

    @Column(name = "createdAt", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;  // Auto-set by SQL Server

    @Column(name = "updatedAt", nullable = false, insertable = false)
    private LocalDateTime updatedAt;  // Auto-updated by SQL Server trigger

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;
}
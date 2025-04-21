package com.taskmanagement.taskservice.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum TaskPriority {
    LOW, MEDIUM, HIGH, NONE
}

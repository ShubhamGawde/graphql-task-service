package com.taskmanagement.taskservice.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum TaskStatus {
    TODO, IN_PROGRESS, COMPLETED
}

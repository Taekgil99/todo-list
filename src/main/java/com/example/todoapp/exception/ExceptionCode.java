package com.example.todoapp.exception;

import lombok.Getter;

public enum ExceptionCode {
    TASKS_NOT_FOUND(404, "Task not found"),
    TASKS_EXISTS(409, "Task exists"),

    ORDER_NOT_FOUND(404, "Order not found"),

    NOT_IMPLEMENTATION(501, "Not Implementation"),
    INVALID_MEMBER_STATUS(400, "Invalid member status");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}

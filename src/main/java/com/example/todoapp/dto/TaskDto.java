package com.example.todoapp.dto;

import lombok.*;


public class TaskDto {
    private String url;
    @Getter
    @AllArgsConstructor
    public static class Post {
        private String title;
        private String order;
        private Boolean completed;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private String title;
        private String order;
        private Boolean completed;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private Long taskId;
        private String title;
        private Long order;
        private Boolean completed;
        private String url;
    }

}

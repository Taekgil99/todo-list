package com.example.todoapp.dto;

import lombok.Setter;

@Setter
public class TasksDto {
    public class Post {
        private String title;
        private String order;
        private boolean completed;
    }

    public class Patch {
        private String title;
        private String order;
        private boolean completed;
    }

    public class Response {
        private Long taskId;
        private String title;
        private Long order;
        private boolean completed;
    }

}

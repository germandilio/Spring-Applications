package ru.germandilio.spring_boot_crud_project.controllers.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorServerResponse {
    private int code;
    private String message;
}

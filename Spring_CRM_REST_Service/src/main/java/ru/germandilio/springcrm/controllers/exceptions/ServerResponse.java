package ru.germandilio.springcrm.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServerResponse {
    private int status;
    private String message;
    private long timeStamp;
}

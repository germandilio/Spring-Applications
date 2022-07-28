package ru.germandilio.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        // implement in platform independent way
        var student = jsonMapper.readValue(new File(String.valueOf(Paths.get("src", "data", "sample-full.json"))), Student.class);

        System.out.println("student.toString() = " + student.toString());
    }
}

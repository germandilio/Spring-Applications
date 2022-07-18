package ru.germandilio.hibernatedemo.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

class JdbcConnectionTest {
    @Test
    public void testJdbcConnection() {
        Assertions.assertDoesNotThrow(() -> {
            String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
            String user = "hbstudent";
            String password = "hbstudent";

            Connection databaseConnection = DriverManager.getConnection(url, user, password);
            databaseConnection.close();
        });
    }
}
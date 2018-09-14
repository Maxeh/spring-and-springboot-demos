package com.maxeh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;

@Controller
@ResponseBody
public class JdbcController {

    // simple JDBC test
    @RequestMapping("/jdbc")
    public String welcome() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful.");
            return "Connection successful.";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "Connection failed.";
    }
}

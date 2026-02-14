package task2.app.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbTestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbtest")
    public String test() throws Exception {
        try (Connection con = dataSource.getConnection()) {
            return "Connected: " + con.getMetaData().getDatabaseProductName();
        }
    }
}
package com.homework.crudimpl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {

  String url = "jdbc:postgresql://localhost:5432/crudimpl";
  String username = "postgres";
  String password = "postgres";

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }
}

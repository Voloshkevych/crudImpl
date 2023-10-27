package com.homework.crudimpl.DAO;

import com.homework.crudimpl.model.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO {

  private DatabaseConnection databaseConnection;

  @Autowired
  public AuthorDAO(DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public Connection getConnection() {
    try {
      return databaseConnection.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Author> getAllAuthors() {
    List<Author> authors = new ArrayList<>();
    String query = "SELECT * FROM authors";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Author author = Author.builder()
            .id(resultSet.getInt("id"))
            .name(resultSet.getString("name"))
            .nationality(resultSet.getString("nationality"))
            .build();
        authors.add(author);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return authors;
  }

  public void createAuthor(Author author) {
    String query = "INSERT INTO authors (name, nationality) VALUES (?, ?)";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, author.getName());
      preparedStatement.setString(2, author.getNationality());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Author findAuthorById(int id) {
    Author author = null;

    String query = "SELECT * FROM authors WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        author = Author.builder()
            .id(resultSet.getInt("id"))
            .name(resultSet.getString("name"))
            .nationality(resultSet.getString("nationality"))
            .build();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return author;
  }

  public void updateAuthor(Author author) {
    String query = "UPDATE authors SET name = ?, nationality = ? WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, author.getName());
      preparedStatement.setString(2, author.getNationality());
      preparedStatement.setInt(3, author.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void deleteAuthorById(int id) {
    String query = "DELETE FROM authors WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

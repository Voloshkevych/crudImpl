package com.homework.crudimpl.DAO;

import com.homework.crudimpl.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

  private DatabaseConnection databaseConnection;

  @Autowired
  public BookDAO(DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public Connection getConnection() {
    try {
      return databaseConnection.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Book> getAllBooks() {
    List<Book> books = new ArrayList<>();
    String query = "SELECT * FROM books";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Book book = Book.builder()
            .id(resultSet.getInt("id"))
            .title(resultSet.getString("title"))
            .isbn(resultSet.getString("isbn"))
            .build();
        books.add(book);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return books;
  }

  public void createBook(Book book) {
    String query = "INSERT INTO books (title, isbn) VALUES (?, ?)";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, book.getTitle());
      preparedStatement.setString(2, book.getIsbn());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Book findBookById(int id) {
    String query = "SELECT * FROM books WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return Book.builder()
            .id(resultSet.getInt("id"))
            .title(resultSet.getString("title"))
            .isbn(resultSet.getString("isbn"))
            .build();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  public void updateBook(Book book) {
    String query = "UPDATE books SET title = ?, isbn = ? WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, book.getTitle());
      preparedStatement.setString(2, book.getIsbn());
      preparedStatement.setInt(3, book.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void deleteBookById(int id) {
    String query = "DELETE FROM books WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


}

package com.homework.crudimpl;

import com.homework.crudimpl.DAO.AuthorDAO;
import com.homework.crudimpl.DAO.BookDAO;
import com.homework.crudimpl.DAO.DatabaseConnection;
import com.homework.crudimpl.model.Author;
import com.homework.crudimpl.model.Book;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudImplApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrudImplApplication.class, args);

    testAuthorCRUD();
    testBookCRUD();
  }

  public static void testAuthorCRUD() {

    DatabaseConnection databaseConnection = new DatabaseConnection();
    AuthorDAO authorDAO = new AuthorDAO(databaseConnection);

    // Create a new Author
    Author newAuthor = Author.builder()
        .name("New Author")
        .nationality("Unknown")
        .build();
    authorDAO.createAuthor(newAuthor);
    System.out.println("Created new author.");

    // Read an Author by id
    Author readAuthor = authorDAO.findAuthorById(1);
    if (readAuthor != null) {
      System.out.println("Read author: " + readAuthor);
    } else {
      System.out.println("Author not found.");
    }

    // Update an Author
    if (readAuthor != null) {
      readAuthor.setName("Updated Author");
      authorDAO.updateAuthor(readAuthor);
      System.out.println("Updated author.");
    }

    // Get All Authors
    List<Author> allAuthors = authorDAO.getAllAuthors();
    System.out.println("All authors: " + allAuthors);

    // Delete an Author
    authorDAO.deleteAuthorById(1);
    System.out.println("Deleted author.");
  }

  public static void testBookCRUD() {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    BookDAO bookDAO = new BookDAO(databaseConnection);

    // Create a new Book
    Book newBook = Book.builder()
        .title("New Book")
        .isbn("1234567890123")
        .build();
    bookDAO.createBook(newBook);
    System.out.println("Created new book.");

    // Read a Book by id
    Book readBook = bookDAO.findBookById(1);
    if (readBook != null) {
      System.out.println("Read book: " + readBook);
    } else {
      System.out.println("Book not found.");
    }

    // Update a Book
    if (readBook != null) {
      readBook.setTitle("Updated Book");
      bookDAO.updateBook(readBook);
      System.out.println("Updated book.");
    }

    // Get All Books
    List<Book> allBooks = bookDAO.getAllBooks();
    System.out.println("All books: " + allBooks);

    // Delete a Book
    bookDAO.deleteBookById(1);
    System.out.println("Deleted book.");
  }

}

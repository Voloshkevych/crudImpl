CREATE TABLE authors (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         nationality VARCHAR(255)
);

CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       isbn VARCHAR(13) UNIQUE
);

INSERT INTO authors (name, nationality) VALUES ('George Orwell', 'British');
INSERT INTO authors (name, nationality) VALUES ('Jane Austen', 'British');
INSERT INTO authors (name, nationality) VALUES ('Mark Twain', 'American');
INSERT INTO authors (name, nationality) VALUES ('F. Scott Fitzgerald', 'American');
INSERT INTO authors (name, nationality) VALUES ('J.K. Rowling', 'British');
INSERT INTO authors (name, nationality) VALUES ('J.R.R. Tolkien', 'British');
INSERT INTO authors (name, nationality) VALUES ('Ernest Hemingway', 'American');
INSERT INTO authors (name, nationality) VALUES ('William Shakespeare', 'British');
INSERT INTO authors (name, nationality) VALUES ('Leo Tolstoy', 'Russian');
INSERT INTO authors (name, nationality) VALUES ('Agatha Christie', 'British');
INSERT INTO authors (name, nationality) VALUES ('Stephen King', 'American');
INSERT INTO authors (name, nationality) VALUES ('Isaac Asimov', 'American');

INSERT INTO books (title, isbn) VALUES ('1984', '978-0451524935');
INSERT INTO books (title, isbn) VALUES ('Pride and Prejudice', '978-1503290563');
INSERT INTO books (title, isbn) VALUES ('Adventures of Huckleberry Finn', '978-0486280615');
INSERT INTO books (title, isbn) VALUES ('The Great Gatsby', '978-0743273565');
INSERT INTO books (title, isbn) VALUES ('Harry Potter and the Philosopher''s Stone', '978-0747532743');
INSERT INTO books (title, isbn) VALUES ('The Lord of the Rings', '978-0618640157');
INSERT INTO books (title, isbn) VALUES ('The Old Man and the Sea', '978-0684801223');
INSERT INTO books (title, isbn) VALUES ('Romeo and Juliet', '978-0743477116');
INSERT INTO books (title, isbn) VALUES ('War and Peace', '978-1400079988');
INSERT INTO books (title, isbn) VALUES ('Murder on the Orient Express', '978-0062073501');
INSERT INTO books (title, isbn) VALUES ('The Shining', '978-0307743657');
INSERT INTO books (title, isbn) VALUES ('Foundation', '978-0553293357');

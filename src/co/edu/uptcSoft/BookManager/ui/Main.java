package co.edu.uptcSoft.BookManager.ui;

import co.edu.uptcSoft.BookManager.logic.*;
import co.edu.uptcSoft.BookManager.model.*;
import co.edu.uptcSoft.BookManager.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("CÓMO PROGRAMAR EN JAVA.", "PAUL J. Y HARVEY M. DEITEL",2008);
        Book book2 = new Book("Software Architecture Patterns", "Mark Richards", 2015);
        Book book3 = new Book("FUNDAMENTOS DE BASES DE DATOS", "Abraham Silberschatz", 2002);

        // Create a list of books
        List<Book> books = List.of(book1, book2, book3);

        // Create the file manager
        FileManager fileManager = new FileManager("books.txt");

        // Create the book manager
        BookManager bookManager = new BookManager(fileManager);

        // Save the books to a file
        bookManager.saveBooks(books);

        // Load the books from the file
        List<Book> loadedBooks = bookManager.loadBooks();

        // Print the loaded books
        for (Book book : loadedBooks) {
            System.out.println(book);
        }
    }
}

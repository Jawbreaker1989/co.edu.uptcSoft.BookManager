package co.edu.uptcSoft.BookManager.logic;

import co.edu.uptcSoft.BookManager.model.*;
import co.edu.uptcSoft.BookManager.persistence.*;

import java.util.List;

public class BookManager {
    private FileManager fileManager;

    public BookManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void saveBooks(List<Book> books) {
        fileManager.saveBooks(books);
    }

    public List<Book> loadBooks() {
        return fileManager.loadBooks();
    }
}

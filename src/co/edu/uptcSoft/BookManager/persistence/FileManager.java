package co.edu.uptcSoft.BookManager.persistence;

import co.edu.uptcSoft.BookManager.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String file;

    public FileManager(String file) {
        this.file = file;
    }

    public void saveBooks(List<Book> books) {
        try (Writer writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (Book book : books) {
                bufferedWriter.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPublicationYear() + "\n");
            }
            System.out.println("Books saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (Reader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    int publicationYear = Integer.parseInt(parts[2]);
                    books.add(new Book(title, author, publicationYear));
                }
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}

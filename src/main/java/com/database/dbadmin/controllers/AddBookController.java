package com.database.dbadmin.controllers;

import com.database.dbadmin.HelloApplication;
import com.database.dbadmin.database.BookDataBase;
import com.database.dbadmin.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.Date;

public class AddBookController {
    BookDataBase bookDataBase = new BookDataBase();
    HelloApplication helloApplication = new HelloApplication();

    @FXML
    public DatePicker date;
    @FXML
    public TextField name;

    @FXML
    public TextField author;

    @FXML
    public TextField pages;

    @FXML
    public TextField genre;

    @FXML
    public TextField description;

    @FXML
    public TextField publisher;

    @FXML
    public Label result;


    public void close(ActionEvent actionEvent) {
        helloApplication.close();
    }

    public void toMain(ActionEvent actionEvent) {
        helloApplication.changeScene("main-page.fxml");
    }

    public void createBook(ActionEvent actionEvent) {
        Book book = new Book();
        book.setPublisher_name(publisher.getText());
        book.setPages(Integer.parseInt(pages.getText()));
        Date date1 = Date.valueOf(date.getValue());
        book.setPublication_date(date1);
        book.setAuthor(author.getText());
        book.setBook_name(name.getText());
        book.setGenre(genre.getText());
        book.setBook_brief_description(description.getText());
        book.setPublisher_name(publisher.getText());
        bookDataBase.save(book);
        clear();
        result.setText("Сохранено");
    }
    public void clear(){
        publisher.clear();
        pages.clear();
        name.clear();
        author.clear();
        date.setValue(null);
        genre.clear();
        description.clear();
    }
}

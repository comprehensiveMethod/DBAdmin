package com.database.dbadmin.controllers;

import com.database.dbadmin.HelloApplication;
import com.database.dbadmin.database.BookDataBase;
import com.database.dbadmin.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Date;
import java.time.LocalDate;

public class UpdateBookController {
    private HelloApplication helloApplication = new HelloApplication();
    @FXML
    Label book_id;
    Book book;
    @FXML
    public void initialize(){
        book_id.setText(StaticDataTransfer.book.getId().toString());
        book = StaticDataTransfer.book;
        name.setText(book.getBook_name());
        author.setText(book.getAuthor());
        pages.setText(book.getPages()+"");
        genre.setText(book.getGenre());
        description.setText(book.getBook_brief_description());
        publisher.setText(book.getPublisher_name());
        date.setValue(book.getPublication_date().toLocalDate());
    }
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


    public void updateBook(ActionEvent actionEvent) {
        BookDataBase bookDataBase = new BookDataBase();
        book.setId(StaticDataTransfer.book.getId());
        book.setPublisher_name(publisher.getText());
        book.setPages(Integer.parseInt(pages.getText()));
        Date date1 = Date.valueOf(date.getValue());
        book.setPublication_date(date1);
        book.setAuthor(author.getText());
        book.setBook_name(name.getText());
        book.setGenre(genre.getText());
        book.setBook_brief_description(description.getText());
        book.setPublisher_name(publisher.getText());
        bookDataBase.update(book);
        helloApplication.changeScene("library.fxml");
    }

    public void toMain(ActionEvent actionEvent) {
        helloApplication.changeScene("library.fxml");
    }
}

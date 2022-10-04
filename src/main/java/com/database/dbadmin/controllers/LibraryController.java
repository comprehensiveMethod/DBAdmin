package com.database.dbadmin.controllers;

import com.database.dbadmin.HelloApplication;
import com.database.dbadmin.database.BookDataBase;
import com.database.dbadmin.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LibraryController {
    HelloApplication helloApplication = new HelloApplication();
    @FXML
    public Text info;

    @FXML
    public Button deleteButton;

    @FXML
    public Button updateButton;
    @FXML
    public ListView<Book> bookListView;

    Book book = new Book();
    BookDataBase bookDataBase = new BookDataBase();

    public void close(ActionEvent actionEvent) {
        helloApplication.close();
    }

    public void toMain(ActionEvent actionEvent) {
        helloApplication.changeScene("main-page.fxml");
    }


    @FXML
    public void initialize(){

        bookListView.getItems().addAll(bookDataBase.getAll());
        deleteButton.setVisible(false);
        updateButton.setVisible(false);
    }



    public void showInfo(MouseEvent mouseEvent) {
        book = bookListView.getSelectionModel().getSelectedItem();
        info.setText(
                "Номер " + book.getId() + "\n"+
                "Автор " + book.getAuthor() + "\n"+
                "Название " + book.getBook_name() + "\n"+ "Дата публикации: " + book.getPublication_date().toString() +"\n"+
                "Издание " + book.getPublisher_name() +"\n"+
                "Жанр " + book.getGenre() +"\n"+  "Кол-во страниц "+ book.getPages() + "\n"+
                "Краткое содержание " + book.getBook_brief_description() +"\n"
        );
        deleteButton.setVisible(true);
        updateButton.setVisible(true);
    }

    public void deleteBook(ActionEvent actionEvent) {
        bookDataBase.delete(book);
        bookListView.getItems().clear();
        bookListView.getItems().addAll(bookDataBase.getAll());
    }

    public void updateBook(ActionEvent actionEvent) {
        StaticDataTransfer.book = bookListView.getSelectionModel().getSelectedItem();
        helloApplication.changeScene("updateBook.fxml");
    }
}

package com.database.dbadmin.controllers;

import com.database.dbadmin.HelloApplication;
import com.database.dbadmin.database.BookDataBase;
import com.database.dbadmin.models.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LibraryController {
    HelloApplication helloApplication = new HelloApplication();
    @FXML
    public Text info;

    @FXML
    public ListView<Book> bookListView;



    public void close(ActionEvent actionEvent) {
        helloApplication.close();
    }

    public void toMain(ActionEvent actionEvent) {
        helloApplication.changeScene("main-page.fxml");
    }


    @FXML
    public void initialize(){
        BookDataBase bookDataBase = new BookDataBase();
        bookListView.getItems().addAll(bookDataBase.getAll());
    }


    //TODO починить вывод в info
    public void showInfo(MouseEvent mouseEvent) {
        Book book = bookListView.getSelectionModel().getSelectedItem();
        info.setText(
                "Номер " + book.getId() + "\n"+
                "Автор " + book.getAuthor() + "\n"+
                "Название " + book.getBook_name() + "\n"+ "Дата публикации: " + book.getPublication_date().toString() +"\n"+
                "Издание " + book.getPublisher_name() +"\n"+
                "Жанр " + book.getGenre() +"\n"+  "Кол-во страниц"+ book.getPages() + "\n"+
                "Краткое содержание" + book.getBook_brief_description() +"\n"
        );
    }
}

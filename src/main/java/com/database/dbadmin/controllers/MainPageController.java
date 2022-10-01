package com.database.dbadmin.controllers;

import com.database.dbadmin.HelloApplication;
import javafx.event.ActionEvent;

public class MainPageController {
    public HelloApplication helloApplication = new HelloApplication();



    public void AddOrder(ActionEvent actionEvent) {

    }

    public void AddClient(ActionEvent actionEvent) {

    }

    public void AddProvider(ActionEvent actionEvent) {

    }

    public void AddSupply(ActionEvent actionEvent) {

    }

    public void AddBook(ActionEvent actionEvent) {
        helloApplication.changeScene("add-book-page.fxml");
    }

    public void close(ActionEvent actionEvent) {
        helloApplication.close();
    }

    public void SelectBook(ActionEvent actionEvent) {

    }
}

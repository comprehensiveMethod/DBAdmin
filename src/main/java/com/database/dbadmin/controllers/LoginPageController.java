package com.database.dbadmin.controllers;

import com.database.dbadmin.HelloApplication;
import com.database.dbadmin.database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginPageController {
    @FXML
    public TextField name;
    private short counter;
    @FXML
    public PasswordField pass;
    @FXML
    public Label warnMsg;

    public HelloApplication helloApplication = new HelloApplication();
    public void loginButtonClick(ActionEvent actionEvent) {

        if(counter>=3){
            helloApplication.close();
        }
        try {
            DBConnection dbConnection = new DBConnection(name.getText(),pass.getText());
            dbConnection.checkConnection();

            helloApplication.changeScene("main-page.fxml");
        } catch (SQLException e) {
            counter++;
            int attempts = 4-counter;
            warnMsg.setText("Wrong login/password, attempts left: " +attempts);
        }


    }

    public void close(ActionEvent actionEvent) {
        helloApplication.close();
    }
}

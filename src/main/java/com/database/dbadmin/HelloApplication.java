package com.database.dbadmin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class HelloApplication extends Application {
    public static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        openStage("login-page.fxml", stage, 600, 400);

    }
    private void openStage(String fxml, Stage stage, int width, int height) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        stage.setTitle("DBAdmin 4");
        stage.setResizable(false);

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setScene(scene);
        stage.show();
    }

    public void openStage(String fxml) throws IOException {
        openStage(fxml, new Stage(), 600, 400);
    }

    public void openStage(String fxml, int width, int height) throws IOException {
        openStage(fxml, new Stage(), width, height);
    }
    public void close(){
        stg.close();
    }

    public void changeScene(String fxml){
        try {
            Parent pane = FXMLLoader.load(getClass().getResource(fxml));
            stg.getScene().setRoot(pane);

        } catch (IOException ex){
            System.err.println(ex.getMessage()+"\n"+ ex.getCause());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
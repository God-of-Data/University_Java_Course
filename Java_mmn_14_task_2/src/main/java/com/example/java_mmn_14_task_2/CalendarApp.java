package com.example.java_mmn_14_task_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CalendarApp.class.getResource("calendar.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 390);

        stage.setTitle("Calendar");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}

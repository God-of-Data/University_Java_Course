package com.example.java_mmn_13_task_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HangmanGameApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HangmanGameApp.class.getResource("hangman.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setTitle("Hangman Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
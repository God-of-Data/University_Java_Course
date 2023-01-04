package com.example.java_mmn_13_task_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TriviaApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(TriviaApp.class.getResource("trivia_game.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setTitle("Trivia Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
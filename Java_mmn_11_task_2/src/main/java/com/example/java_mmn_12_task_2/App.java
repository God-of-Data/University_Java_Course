package com.example.java_mmn_12_task_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 400, 435);

        stage.setTitle("Game of Life Simulation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {

        launch();
    }

}

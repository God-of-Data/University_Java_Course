package com.example.java_mmn_12_task_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShapeDrawerApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ShapeDrawerApp.class.getResource("shapes_drawing_board.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        stage.setTitle("Shape Drawer");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
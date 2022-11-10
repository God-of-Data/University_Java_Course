package com.example.java_mmn_12_task_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AppController {


    @FXML
    private void initialize() {

        MainView.drawBoard();
    }


    @FXML
    protected static void onNextGenerationButtonClick(ActionEvent actionEvent) {

        MainView.getGameSimulation().calculateNextGenerationMatrix();

        MainView.drawBoard();
    }

}

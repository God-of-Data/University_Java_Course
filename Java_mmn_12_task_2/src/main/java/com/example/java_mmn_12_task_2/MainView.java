package com.example.java_mmn_12_task_2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class MainView extends VBox {

    private static final int BOARD_SIZE = 400;

    private static Canvas canvas;

    private static ToolBar toolbar;

    private static Button nextGenerationButton;

    private static Affine affine;

    private static GameOfLife gameSimulation;


    public MainView() {

        int numberOfCellsInRow = 10;
        int numberOfCellsInColumn = 10;

        gameSimulation = new GameOfLife(numberOfCellsInColumn, numberOfCellsInRow);


        canvas = new Canvas(BOARD_SIZE, BOARD_SIZE);


        nextGenerationButton = new Button("Next Generation");

        nextGenerationButton.setOnAction(AppController::onNextGenerationButtonClick);


        toolbar = new ToolBar();

        toolbar.getItems().addAll(nextGenerationButton);


        this.getChildren().addAll(toolbar, canvas);


        affine = new Affine();

        affine.appendScale(BOARD_SIZE / numberOfCellsInColumn, BOARD_SIZE / numberOfCellsInRow);
    }

    public static GameOfLife getGameSimulation() {

        return gameSimulation;
    }

    public static void drawBoard() {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setTransform(affine);
        gc.setFill(Color.WHEAT);
        gc.fillRect(0, 0, 450, 450);


        gc.setFill(Color.BLACK);

        for (int rowIndex = 0; rowIndex < gameSimulation.getSimulationMatrixHeight(); rowIndex++) {

            for (int columnIndex = 0; columnIndex < gameSimulation.getSimulationMatrixWidth(); columnIndex++) {

                if (gameSimulation.cellIsDead(rowIndex, columnIndex)) {

                    gc.fillRect(columnIndex, rowIndex, 1, 1);
                }
            }
        }


        int strokeSize
                = Math.max(gameSimulation.getSimulationMatrixHeight(), gameSimulation.getSimulationMatrixWidth());

        gc.setStroke(Color.RED);
        gc.setLineWidth(0.05);

        for (int rowIndex = 0; rowIndex <= gameSimulation.getSimulationMatrixHeight(); rowIndex++) {

            gc.strokeLine(0, rowIndex, strokeSize, rowIndex);

        }

        for (int columnIndex = 0; columnIndex <= gameSimulation.getSimulationMatrixWidth(); columnIndex++) {

            gc.strokeLine(columnIndex, 0, columnIndex, strokeSize);

        }
    }

}

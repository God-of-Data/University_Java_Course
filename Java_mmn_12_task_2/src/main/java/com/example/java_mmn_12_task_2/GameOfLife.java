package com.example.java_mmn_12_task_2;
import java.util.Arrays;
import java.util.Random;

public class GameOfLife {

    private static final double INITIAL_LIVE_CELL_RATIO = 0.25;

    private int simulationMatrixWidth;

    private int simulationMatrixHeight;

    private int initializationSize;

    private boolean[][] matrixOfLife;


    public GameOfLife(Integer simulationWidth, Integer simulationHeight) {

        this.simulationMatrixWidth = simulationWidth;
        this.simulationMatrixHeight = simulationHeight;

        Double initializationSizeCalculation
                = (this.simulationMatrixHeight * this.simulationMatrixWidth * INITIAL_LIVE_CELL_RATIO) + 1;

        this.initializationSize = initializationSizeCalculation.intValue();

        this.matrixOfLife = new boolean[simulationMatrixHeight][simulationMatrixWidth];

        this.initializeMatrixOfLife();
    }


    private void initializeMatrixOfLife() {

        for (int rowIndex = 0; rowIndex < this.simulationMatrixHeight; rowIndex++) {

            for (int columnIndex = 0; columnIndex < this.simulationMatrixWidth; columnIndex++) {

                matrixOfLife[rowIndex][columnIndex] = false;
            }
        }


        Integer[] randomRowIndices = new Integer[this.initializationSize];
        Integer[] randomColumnIndices = new Integer[this.initializationSize];

        Random generator = new Random();

        Arrays.setAll(randomRowIndices, randomIndex -> { return generator.nextInt(this.simulationMatrixHeight); });
        Arrays.setAll(randomColumnIndices, randomIndex -> { return generator.nextInt(this.simulationMatrixWidth); });


        for (int index = 0; index < this.initializationSize; index++) {

            this.matrixOfLife[randomRowIndices[index]][randomColumnIndices[index]] = true;
        }
    }


    public int getSimulationMatrixWidth() {

        return simulationMatrixWidth;
    }


    public int getSimulationMatrixHeight() {

        return simulationMatrixHeight;
    }

    public boolean cellIsAlive(int rowIndex, int columnIndex) {

        boolean indicesAreInRange
                = (rowIndex >= 0) && (columnIndex >= 0) && (rowIndex < this.simulationMatrixHeight) && (columnIndex < this.simulationMatrixWidth);

        if(indicesAreInRange) {

            boolean cellIsAlive = this.matrixOfLife[rowIndex][columnIndex];

            return  cellIsAlive;
        }

        return false;
    }


    public boolean cellIsDead(int rowIndex, int columnIndex) {

        boolean indicesAreInRange
                = (rowIndex >= 0) && (columnIndex >= 0) && (rowIndex < this.simulationMatrixHeight) && (columnIndex < this.simulationMatrixWidth);

        if(indicesAreInRange) {

            boolean cellIsDead = !(this.matrixOfLife[rowIndex][columnIndex]);

            return  cellIsDead;
        }

        return true;
    }


    public int countNeighboringCells(int rowIndex, int columnIndex) {

        int neighborCounter = 0;


        neighborCounter += this.cellIsAlive(rowIndex - 1, columnIndex - 1) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex - 1, columnIndex) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex - 1, columnIndex + 1) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex, columnIndex - 1) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex, columnIndex + 1) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex + 1, columnIndex - 1) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex + 1, columnIndex) ? 1 : 0;

        neighborCounter += this.cellIsAlive(rowIndex + 1, columnIndex + 1) ? 1 : 0;


        return neighborCounter;
    }


    public void calculateNextGenerationMatrix() {

        boolean[][] nextGenerationMatrix = new boolean[this.simulationMatrixHeight][this.simulationMatrixWidth];;


        for (int rowIndex = 0; rowIndex < this.simulationMatrixHeight; rowIndex++) {

            for (int columnIndex = 0; columnIndex < this.simulationMatrixWidth; columnIndex++) {

                int neighboringCellsAmount = this.countNeighboringCells(rowIndex, columnIndex);


                if (this.cellIsDead(rowIndex, columnIndex) && (neighboringCellsAmount == 3)) {

                    nextGenerationMatrix[rowIndex][columnIndex] = true;
                }

                else if (this.cellIsAlive(rowIndex, columnIndex) && (neighboringCellsAmount <= 1)) {

                    nextGenerationMatrix[rowIndex][columnIndex] = false;
                }

                else if (this.cellIsAlive(rowIndex, columnIndex) && (neighboringCellsAmount >= 4)) {

                    nextGenerationMatrix[rowIndex][columnIndex] = false;
                }

                else if (this.cellIsAlive(rowIndex, columnIndex) && (neighboringCellsAmount >= 2) && (neighboringCellsAmount <= 3)) {

                    nextGenerationMatrix[rowIndex][columnIndex] = true;
                }

                else {

                    nextGenerationMatrix[rowIndex][columnIndex] = false;
                }
            }
        }

        this.matrixOfLife = nextGenerationMatrix;
    }

}
package com.example.java_mmn_12_task_2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class ShapeDrawerController {

    private static GraphicsContext gc;


    @FXML
    private Canvas drawingBoard;

    @FXML
    private void initialize() throws CloneNotSupportedException {

        /**
         * Attaching drawingBoard canvas to GraphicsContext object.
         */
        gc = drawingBoard.getGraphicsContext2D();

        /**
         * Creating a new ArrayList and putting in it 6 random MyShape objects.
         */
        Random generator = new Random();

        ArrayList<MyShape> shapes = new ArrayList<MyShape>();
        ArrayList<MyShape> clonedShapes = new ArrayList<MyShape>();

        MyShape tempShape;

        tempShape = new MyLine(generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), Color.RED);

        shapes.add(tempShape);

        tempShape = new MyLine(generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), Color.RED);

        shapes.add(tempShape);

        tempShape = new MyRectangle(generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), Color.RED, true);

        shapes.add(tempShape);

        tempShape = new MyRectangle(generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), Color.RED, true);

        shapes.add(tempShape);

        tempShape = new MyOval(generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), Color.RED, true);

        shapes.add(tempShape);

        tempShape = new MyOval(generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), generator.nextDouble(200), Color.RED, true);

        shapes.add(tempShape);

        /**
         * Duplicating all object in ArrayList shapes and putting in another ArrayList
         * after changing their X1,Y1,shapeColor,shapeFilled attributes.
         */
        for(MyShape currShape : shapes) {

            tempShape = (MyShape) currShape.clone();

            tempShape.setShapeColor(Color.GREEN);

            tempShape.setX1(tempShape.getX1() + 10);

            tempShape.setY1(tempShape.getY1() + 10);

            if (tempShape instanceof MyBoundedShape) {

                ((MyBoundedShape) tempShape).setShapeFilled(false);
            }

            clonedShapes.add(tempShape);
        }


        /**
         * Scanning both MyShape ArrayList and drawing their objects using drawShape method.
         */
        for(MyShape currShape : shapes) {

            currShape.drawShape(gc);
        }

        for(MyShape currShape : clonedShapes) {

            currShape.drawShape(gc);
        }
    }

}
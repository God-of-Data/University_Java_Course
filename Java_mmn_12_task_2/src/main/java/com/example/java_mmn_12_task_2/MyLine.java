package com.example.java_mmn_12_task_2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape{

    public MyLine(double X1, double Y1, double X2, double Y2, Color shapeColor) {

        super(X1, Y1, X2, Y2, shapeColor);
    }


    /**
     * Calculates MyLine object's length by using X1,Y1,X2,Y2 attributes as coordinates.
     *
     * @return MyLine object's length as double type.
     */
    private double calculateLineLength() {

        double lineLength
                = Math.sqrt(Math.pow(this.getX2() - this.getX1(), 2) + Math.pow(this.getY2() - this.getY1(), 2));

        return lineLength;
    }

    /**
     * Draws MyLine object by using GraphicsContext object and shapeColor attribute.
     *
     * @param gc The GraphicsContext object that is attached to object to be drawn on.
     */
    @Override
    public void drawShape(GraphicsContext gc) {

        gc.setStroke(this.getShapeColor());

        gc.strokeLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
    }


    /**
     * Checks if to MyLine objects are equal by comparing calculateLineLength method results.
     *
     * @param obj The second object in the comparison.
     *
     * @return True if objects are equal and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {

            return true;
        }

        if (!(obj instanceof MyLine)) {

            return false;
        }

        MyLine other = (MyLine) obj;

        boolean linesAreEquals = this.calculateLineLength() == other.calculateLineLength();

        return linesAreEquals;
    }
}

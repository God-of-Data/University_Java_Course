package com.example.java_mmn_12_task_2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyBoundedShape{


    public MyRectangle(double X1, double Y1, double X2,  double Y2, Color shapeColor, boolean shapeFilled) {

        super(X1, Y1, X2, Y2, shapeColor, shapeFilled);
    }


    /**
     * Draws MyRectangle object by using GraphicsContext object and shapeColor,shapeFilled attributes.
     *
     * @param gc The GraphicsContext object that is attached to object to be drawn on.
     */
    @Override
    public void drawShape(GraphicsContext gc) {

        gc.setFill(this.getShapeColor());

        /**
         * Checking shapeFilled attribute value to determine whether shape drawing should be filled.
         */
        if (this.shapeIsFilled()){

            gc.fillRect(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }

        else {

            gc.strokeRect(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }

    }

    /**
     * Checks if to MyRectangle objects are equal by comparing their X2,Y2 attributes.
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

        if (!(obj instanceof MyRectangle)) {

            return false;
        }

        MyRectangle other = (MyRectangle) obj;

        boolean shapesAreEquals = (this.getX2() == other.getX2()) && (this.getY2() == other.getY2());

        return shapesAreEquals;
    }
}

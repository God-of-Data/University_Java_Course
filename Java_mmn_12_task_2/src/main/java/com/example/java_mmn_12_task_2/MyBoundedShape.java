package com.example.java_mmn_12_task_2;

import javafx.scene.paint.Color;

public abstract class MyBoundedShape extends MyShape{

    private boolean shapeFilled;


    public MyBoundedShape(double X1, double Y1, double X2, double Y2, Color shapeColor, boolean shapeFilled) {

        super(X1, Y1, X2, Y2, shapeColor);

        this.setShapeFilled(shapeFilled);
    }

    public void setShapeFilled(boolean shapeFilled) {

        this.shapeFilled = shapeFilled;
    }

    public boolean shapeIsFilled() {

        return this.shapeFilled;
    }

    /**
     * Returns formatted MyBoundedShape object in string by putting all object attributes in string.
     *
     * @return MyBoundedShape as a formatted string.
     */
    @Override
    public String toString() {

        String formattedObject
                = "MyBoundedShape{"
                    + "X1 = " + this.getX1()
                    + ", Y1 = " + this.getY1()
                    + ", X2 = " + this.getX2()
                    + ", Y2 = " + this.getY2()
                    + ", shapeColor = " + this.getShapeColor().toString()
                    + ", shapeFilled = " + this.shapeIsFilled()
                + '}';;

        return formattedObject;
    }
}

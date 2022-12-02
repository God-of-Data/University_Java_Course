package com.example.java_mmn_12_task_2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape implements Cloneable{

    private double X1;

    private double Y1;

    private double X2;

    private double Y2;

    private Color shapeColor;


    public MyShape(double X1, double Y1, double X2, double Y2, Color shapeColor) {

        this.setX1(X1);

        this.setY1(Y1);

        this.setX2(X2);

        this.setY2(Y2);

        this.setShapeColor(shapeColor);
    }


    public void setX1(double X1) {

        this.X1 = X1;
    }

    public void setX2(double X2) {

        this.X2 = X2;
    }

    public void setY1(double Y1) {

        this.Y1 = Y1;
    }

    public void setY2(double Y2) {

        this.Y2 = Y2;
    }

    public void setShapeColor(Color shapeColor) {

        this.shapeColor = shapeColor;
    }

    public double getX1() {

        return this.X1;
    }

    public double getX2() {

        return this.X2;
    }

    public double getY1() {

        return this.Y1;
    }

    public double getY2() {

        return this.Y2;
    }

    public Color getShapeColor() {

        return this.shapeColor;
    }


    public abstract void drawShape(GraphicsContext gc);

    /**
     * Returns cloned MyShape object by using Object clone method to create duplicate object.
     *
     * @return Clone of MyShape object.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    /**
     * Returns formatted MyShape object in string by putting all object attributes in string.
     *
     * @return MyShape as a formatted string.
     */
    @Override
    public String toString() {

            String formattedObject
                    = "MyShape{"
                        + "X1 = " + this.getX1()
                        + ", Y1 = " + this.getY1()
                        + ", X2 = " + this.getX2()
                        + ", Y2 = " + this.getY2()
                        + ", shapeColor = " + this.getShapeColor().toString()
                    + '}';

            return formattedObject;
    }

}

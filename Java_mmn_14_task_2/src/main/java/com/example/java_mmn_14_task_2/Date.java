package com.example.java_mmn_14_task_2;

import java.util.Objects;

public class Date {

    private int day;

    private int month;

    private int year;

    public Date(int day, int month, int year) {

        this.setDay(day);

        this.setMonth(month);

        this.setYear(year);
    }

    private void setDay(int day) {

        this.day = day;
    }

    private void setMonth(int month) {

        this.month = month;
    }

    private void setYear(int year) {

        this.year = year;
    }

    public int getDay() {

        return day;
    }

    public int getMonth() {

        return month;
    }

    public int getYear() {

        return year;
    }


    @Override
    public int hashCode() {

        return Objects.hash(this.getDay(), this.getMonth(), this.getYear());
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }

        if (!(obj instanceof Date)) {

            return false;
        }

        Date date = (Date) obj;

        boolean datesAreEqual
                = (day == date.day) && (month == date.month) && (year == date.year);

        return datesAreEqual;
    }


    @Override
    public String toString() {

        return "Date{"
                + "day = " + this.getDay()
                + ", month = " + this.getMonth()
                + ", year = " + this.getYear()
                + '}';
    }
}

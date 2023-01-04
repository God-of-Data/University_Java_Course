package com.example.java_mmn_14_task_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Optional;

public class CalendarController {

    private final int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH) + 1;

    private final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    private final String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


    @FXML private Button btn29;
    @FXML private Button btn30;
    @FXML private Button btn31;

    @FXML public Text column1;
    @FXML public Text column2;
    @FXML public Text column3;
    @FXML public Text column4;
    @FXML public Text column5;
    @FXML public Text column6;
    @FXML public Text column7;

    @FXML private ComboBox<Integer> monthCB;
    @FXML private ComboBox<Integer> yearCB;


    private HashMap<Date, String> memoMap = new HashMap<Date, String>();

    private TextInputDialog td = new TextInputDialog();


    @FXML
    public void initialize(){

        column1.setText("Please select Year and Month and press Show.");
        column2.setText("");
        column3.setText("");
        column4.setText("");
        column5.setText("");
        column6.setText("");
        column7.setText("");

        monthCB.setValue(CURRENT_MONTH);
        yearCB.setValue(CURRENT_YEAR);

        handleComboBox();
    }


    /**
     * Receives Memo from user and saves it by the details
     * of the chosen date in memoMap.
     */
    @FXML
    private void btnAddMeeting(ActionEvent event) {

        td.setTitle("Memo");
        td.setHeaderText("Enter memo");


        /**
         * Listening to which button user has clicked.
         */
        Button clickedDayButton = (Button)event.getSource();

        /**
         * Getting the date by looking at the ComboBoxes values and clicked button id.
         */
        Date chosenDate
                = new Date(Integer.parseInt(clickedDayButton.getId()), monthCB.getValue(), yearCB.getValue());

        //retrieve memo or set a new one

        /**
         * Checking if memo is in map.
         * If so, retrieving it. Otherwise, setting a new one.
         */
        if(memoMap.get(chosenDate) != null) {

            System.out.println("There is a memo for this date.");

            td.getEditor().setText(getMemo(chosenDate));
        }

        else{

            System.out.println("No memo for this date.");

            td.getEditor().setText("");
        }

        Optional<String> result = td.showAndWait();

        /**
         * Inserting memo into map.
         */
        if(result.isPresent()){

            memoMap.put(chosenDate, result.get());

            System.out.println("Memo Map is: " + memoMap.toString());

            System.out.println("Memo was inserted successfully!");
        }
    }

    /**
     * Shows the buttons for the selected month by weekly order.
     */
    @FXML
    private void showChosenMonth(ActionEvent event) {

        /**
         * Calculating how many buttons to present, and how many to hide.
         */
        int chosenMonth = monthCB.getValue() - 1;
        int chosenYear = yearCB.getValue();

        int numberOfDaysToShow = calculateDaysInMonth(chosenMonth, chosenYear);

        int spareDays = 31 - numberOfDaysToShow;


        /**
         * Hiding the spare buttons by checking how many spare days there are in selected month.
         */
        btn31.setVisible(true);
        btn30.setVisible(true);
        btn29.setVisible(true);

        switch (spareDays) {

            case 1:

                btn31.setVisible(false);

                break;

            case 2:

                btn31.setVisible(false);
                btn30.setVisible(false);

                break;

            case 3:

                btn31.setVisible(false);
                btn30.setVisible(false);
                btn29.setVisible(false);

                break;

            default:

                break;
        }


        /**
         * Calculating in which day of week the selected month starts.
         */
        Calendar firstDayOfChosenMonth = Calendar.getInstance();

        firstDayOfChosenMonth.set(chosenYear,chosenMonth,0);

        int firstDayLocationInWeek = firstDayOfChosenMonth.get(Calendar.DAY_OF_WEEK);

        /**
         * Changing the calendar column names according to first day of selected month.
         */
        column1.setText(daysOfWeek[firstDayLocationInWeek % 7]);
        column2.setText(daysOfWeek[(firstDayLocationInWeek + 1) % 7]);
        column3.setText(daysOfWeek[(firstDayLocationInWeek + 2) % 7]);
        column4.setText(daysOfWeek[(firstDayLocationInWeek + 3) % 7]);
        column5.setText(daysOfWeek[(firstDayLocationInWeek + 4) % 7]);
        column6.setText(daysOfWeek[(firstDayLocationInWeek + 5) % 7]);
        column7.setText(daysOfWeek[(firstDayLocationInWeek + 6) % 7]);

    }

    /**
     * Sets the value of the month and year ComboBoxes.
     */
    private void handleComboBox(){

        for (int monthIndex = 0; monthIndex <= 11; monthIndex++) {

            monthCB.getItems().add(monthIndex + 1);
        }

        for (int yearIndex = CURRENT_YEAR; yearIndex >= CURRENT_YEAR - 4 ; yearIndex--) {

            yearCB.getItems().add(yearIndex);
        }
    }


    /**
     * Calculates how many days there are in selected month.
     */
    private int calculateDaysInMonth(int month, int year) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        return calendar.getActualMaximum(Calendar.DATE);
    }

    private String getMemo(Date date) {

        return memoMap.get(date);
    }
}

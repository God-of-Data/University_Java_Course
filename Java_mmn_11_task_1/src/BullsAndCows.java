import javax.swing.*;
import java.util.*;

public class BullsAndCows {

    private static final Integer NUMBER_LENGTH = 4;

    private String selectedNumber;

    private ArrayList<String> previousGuesses;

    private ArrayList<String> previousResults;


    public BullsAndCows() {

        this.selectNumber();

        this.previousGuesses = new ArrayList<String>();
        this.previousResults = new ArrayList<String>();
    }


    public void selectNumber(){

        List<Integer> digits = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        Random generator = new Random();

        Collections.shuffle(digits, generator);


        this.selectedNumber = "";

        for (int digit_index = 0; digit_index < BullsAndCows.NUMBER_LENGTH; digit_index++) {

            this.selectedNumber += digits.get(digit_index);
        }
    }


    public String receiveUserGuess() {

        String gameOutputMessage = "Insert your guess:";

        String userGuess
                = JOptionPane.showInputDialog(null, gameOutputMessage, "Bulls and Cows: Insert Guess", JOptionPane.PLAIN_MESSAGE);

        return userGuess;
    }


    public boolean checkIfUserGuessIsValid(String userGuess) {

        String gameOutput;

        boolean guessIsEmpty = userGuess == null;

        if (guessIsEmpty) {

            gameOutput = "Insert Guess!";

            JOptionPane.showConfirmDialog(null, gameOutput,"Bulls and Cows: Error", JOptionPane.PLAIN_MESSAGE);

            return false;
        }


        boolean guessLengthIsNotValid = userGuess.length() != BullsAndCows.NUMBER_LENGTH;

        if (guessLengthIsNotValid) {

            gameOutput = "Guess length is not valid.";

            JOptionPane.showConfirmDialog(null, gameOutput,"Bulls and Cows: Error", JOptionPane.PLAIN_MESSAGE);

            return false;
        }


        boolean guessDoesNotContainOnlyDigits = !(userGuess.matches("[0-9]+"));

        if (guessDoesNotContainOnlyDigits) {

            gameOutput = "Guess doesn't contain only digits.";

            JOptionPane.showConfirmDialog(null,gameOutput,"Bulls and Cows: Error", JOptionPane.PLAIN_MESSAGE);

            return false;
        }


        boolean digitRepetitionExistsInGuess = userGuess.length() != userGuess.chars().distinct().count();

        if (digitRepetitionExistsInGuess) {

            gameOutput = "There's a repetition in guess.";

            JOptionPane.showConfirmDialog(null, gameOutput,"Bulls and Cows: Error", JOptionPane.PLAIN_MESSAGE);

            return false;
        }

        return true;
    }


    public int countBullsInUserGuess(String userGuess) {

        int bullCounter = 0;

        for (int charIndex = 0; charIndex < BullsAndCows.NUMBER_LENGTH; charIndex++) {

            boolean thereIsBull = userGuess.charAt(charIndex) == this.selectedNumber.charAt(charIndex);

            bullCounter += thereIsBull ? 1 : 0;
        }

        return bullCounter;
    }


    public int countCowsInUserGuess(String userGuess) {

        int cowCounter = 0;

        for (Character digit: userGuess.toCharArray()) {

            boolean thereIsCow = this.selectedNumber.contains(digit.toString());

            cowCounter += thereIsCow ? 1 : 0;
        }

        int bullsInUserGuess = countBullsInUserGuess(userGuess);

        cowCounter -= bullsInUserGuess;

        return cowCounter;
    }


    public void calculateUserGuessResults(String userGuess) {

        int cows = this.countCowsInUserGuess(userGuess);
        int bulls = this.countBullsInUserGuess(userGuess);

        String guessResult = "There are " + bulls + " bulls and " + cows + " cows.";

        this.previousGuesses.add(userGuess);
        this.previousResults.add(guessResult);
    }


    public boolean checkIfUserHasWon(String userGuess) {

        int bulls = this.countBullsInUserGuess(userGuess);

        boolean userHasWon = bulls == BullsAndCows.NUMBER_LENGTH;

        return userHasWon;
    }


    public void announceResults(boolean userHasWon) {

        String previousGuessesOutput;

        int numberOfUserGuesses = this.previousGuesses.size();

        previousGuessesOutput
                = "You've guessed " + numberOfUserGuesses + " times." + "\n" + "Your guesses are:";

        for (int index = 0; index < numberOfUserGuesses; index++) {

            previousGuessesOutput += "\n";

            previousGuessesOutput += this.previousGuesses.get(index);

            previousGuessesOutput += " : ";

            previousGuessesOutput += this.previousResults.get(index);
        }

        String gameOutput = previousGuessesOutput;

        if (userHasWon) {

            gameOutput = "Congrats! You have won." + "\n" + gameOutput;
        }

        JOptionPane.showConfirmDialog(null, gameOutput, "Bulls and Cows: Score", JOptionPane.PLAIN_MESSAGE);
    }


    public void restartGame () {

        this.previousGuesses.clear();
        this.previousResults.clear();

        this.selectNumber();
    }
}

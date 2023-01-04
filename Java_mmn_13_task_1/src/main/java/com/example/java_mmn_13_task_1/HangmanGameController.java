package com.example.java_mmn_13_task_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class HangmanGameController {

    static private Hangman hangmanGame;

    static private StringBuilder secretWord = new StringBuilder();

    static private StringBuilder usedLetters = new StringBuilder();

    static private boolean gameHasEnded;


    @FXML
    private TextField playerGuessField;

    @FXML
    private Text hangmanDrawingArea;

    @FXML
    private Text playerGuessResults;

    @FXML
    private Text playerGuessedLetters;



    @FXML
    public void initialize() {

        hangmanGame = new Hangman();

        resetGame();
    }

    /**
     * Gets the input from player and passes it to playGame function.
     *
     * @param event The event of the clicked button.
     */
    @FXML
    void getUserInput(ActionEvent event) {

        boolean inputShouldNotBeRead
                = gameHasEnded || playerGuessField.getText().equals("");

        if (inputShouldNotBeRead) {

            playerGuessField.clear();

            return;
        }

        String playerGuess
                = String.valueOf(playerGuessField.getText().toLowerCase().charAt(0));

        playGame(playerGuess);

        playerGuessField.clear();
    }

    @FXML
    void resetGameClick(ActionEvent event) {

        resetGame();
    }

    /**
     * Resets game by resetting game variables, and redrawing
     * Hangman hidden word field and tree.
     */
    public void resetGame() {

        gameHasEnded = false;

        hangmanGame.resetGame();

        hangmanDrawingArea.setText(hangmanGame.getCurrentHangmanDrawing());

        secretWord.setLength(0);
        usedLetters.setLength(0);

        playerGuessedLetters.setText("");

        for (int i = 0; i < hangmanGame.getSelectedWord().length(); i++) {

            secretWord.append("_ ");
        }

        playerGuessResults.setText(String.valueOf(secretWord));

        System.out.println("Selected Word: " + hangmanGame.getSelectedWord());
    }

    /**
     * Writes player guess if it's in the selected word.
     * If it isn't, redraws Hangman tree and checks if player has lost.
     * Adds Guess to used guesses.
     * If player hasn't lost check if player had won.
     */
    public void playGame(String userGuess){

        ArrayList<Integer> letterLocations = new ArrayList<>();

        boolean userGuessInSelectedWord
                = hangmanGame.getSelectedWord().contains(userGuess);

        if (userGuessInSelectedWord) {

            /**
             * Finding the location of guess in selected word, and adding it to
             * the output string of the player guess results.
             */

             for (int i = 0; i < hangmanGame.getSelectedWord().length(); i++) {

                if(userGuess.charAt(0) == hangmanGame.getSelectedWord().charAt(i)) {

                    letterLocations.add(i);
                }
            }

            for (int i = 0; i < letterLocations.size(); i++) {

                secretWord.setCharAt(letterLocations.get(i) * 2, userGuess.charAt(0));
            }

            playerGuessResults.setText(String.valueOf(secretWord));
        }

        else {

            /**
             * Drawing the current Hangman drawing.
             */

            hangmanGame.increaseHangmanLifeCounter();

            hangmanDrawingArea.setText(hangmanGame.getCurrentHangmanDrawing());


            if(hangmanGame.playerHasLost()) {

                gameHasEnded = true;

                playerGuessResults.setText("You've lost. Try again.");
            }
        }


        boolean playerGuessHasBeenUsed
                = usedLetters.toString().contains(String.valueOf(userGuess.charAt(0)));

        if(playerGuessHasBeenUsed) {

            return;
        }

        /**
         * Adding guess to used guesses.
         */

        usedLetters.append(userGuess.charAt(0) + ", ");

        playerGuessedLetters.setText(usedLetters.toString());


        String playerWordGuess
                = secretWord.toString().replace(" ", "");

        if(hangmanGame.playerHasWon(playerWordGuess)){

            gameHasEnded = true;

            playerGuessResults.setText("Congrats! You've won.");
        }
    }
}

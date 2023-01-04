package com.example.java_mmn_13_task_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {


    final static private ArrayList<String> hangmanDrawings = new ArrayList<>(Arrays.asList(
            """
            +---+
            |   |
                |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
            |   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           /    |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           / \\  |
                |
          ========="""
    ));

    final static private String FILE_NAME = "hangman.txt";

    static private ArrayList<String> wordList;

    private String selectedWord;

    private int hangmanLifeCounter;



    public Hangman() {

        loadWordsFromFile(FILE_NAME);

        this.resetGame();
    }

    /**
     * Reads all words from file and loads the into ArrayList of String.
     *
     * @param filename Path of file to be read.
     */
    private void loadWordsFromFile(String filename) {

        wordList = new ArrayList<String>();

        Scanner fileReader = null;

        try {

            fileReader = new Scanner(new File(filename));


            while (fileReader.hasNextLine()) {

                wordList.add(fileReader.nextLine());
            }
        }

        catch (IOException e) {

            throw new RuntimeException(e);

        }

        finally {

            fileReader.close();
        }
    }

    /**
     * Selects random word from the list of all the words.
     */
    private void selectRandomWord() {

        Random generator = new Random();

        this.selectedWord = wordList.remove((generator.nextInt(wordList.size())));
    }

    public String getSelectedWord() {

        return this.selectedWord;
    }

    /**
     * Returns current drawing of game by checking wht is the life counter.
     *
     * @return Current drawing as String.
     */
    public String getCurrentHangmanDrawing() {

        return hangmanDrawings.get(this.getHangmanLifeCounter());
    }

    private void resetHangmanLifeCounter() {

        this.hangmanLifeCounter = 0;
    }

    public void increaseHangmanLifeCounter() {

        this.hangmanLifeCounter += 1;
    }

    private int getHangmanLifeCounter() {

        return hangmanLifeCounter;
    }

    /**
     * Returns if player has lost by checking if game life counter had reached
     * the amount of all possible Hangman drawings.
     *
     * @return True if player has lost.
     */
    public boolean playerHasLost() {

        return this.getHangmanLifeCounter() == hangmanDrawings.size() - 1;
    }

    /**
     * Returns if player has won by checking if guessed word is the selected one.
     *
     * @return True if player has won.
     */
    public boolean playerHasWon(String playerGuess) {

        return this.selectedWord.equals(playerGuess);
    }

    /**
     * Resets the game by selecting a new random word and setting the game life counter to 0.
     */
    public void resetGame() {

        this.selectRandomWord();
        this.resetHangmanLifeCounter();
    }
}

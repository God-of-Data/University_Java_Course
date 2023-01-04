package com.example.java_mmn_13_task_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

public class TriviaController {

    static private Game game;

    static private String playerCurrentAnswer;

    static private Text[] answerTextFields;
    static public ArrayList<String> playerAnswers;

    @FXML private Text answer1;

    @FXML private Text answer2;

    @FXML private Text answer3;

    @FXML private Text answer4;

    @FXML private Button btnOne;

    @FXML private Button btnTwo;

    @FXML private Button btnThree;

    @FXML private Button btnFour;

    @FXML private Text questionLabel;

    @FXML private Button next;

    @FXML private Button againBtn;

    @FXML private Text score;

    @FXML private Text previousQuestionFeedback;

    /**
     * Loads all questions and their answers from file and shuffles them.
     */
    @FXML
    public void initialize() {

        game = new Game();

        Collections.shuffle(game.questions);

        /**
         * Setting answer text fields in array.
         */

        answerTextFields = new Text[]{answer1, answer2, answer3, answer4};

        if (game.questionRemained()) {

            score.setText("Calculating");

            loadQuestionsToScreen();

            againBtn.setDisable(true);
        }
    }

    /**
     * Gets the chosen answer from user by finding what is the clicked button.
     *
     * @param event The event of the clicked button.
     */
    @FXML void chooseAnswerClick(ActionEvent event) {

        Button btn = (Button)event.getSource();

        String btnId = btn.getId();

        switch (btnId) {

            case ("btnOne"):

                playerCurrentAnswer = answer1.getText();

                break;

            case ("btnTwo"):

                playerCurrentAnswer = answer2.getText();

                break;

            case ("btnThree"):

                playerCurrentAnswer = answer3.getText();

                break;

            case ("btnFour"):

                playerCurrentAnswer = answer4.getText();

                break;

            default:

                break;
        }
    }

    /**
     * Checks if all questions have been asked. If so, announces game
     * is over and show the score. Otherwise, loads the next question.
     *
     * @param event The event of the clicked button.
     */
    @FXML void nextButtonClick(ActionEvent event){

        /**
         * Calculating score of previous question, and showing feedback to player.
         */

        game.handleUserAnswers(playerCurrentAnswer);

        if (game.checkIfAnswerIsCorrect(playerCurrentAnswer)) {

            previousQuestionFeedback.setText("Previous answer is correct.");
        }

        else {

            previousQuestionFeedback.setText("Previous answer is incorrect.");
        }

        game.moveToNextQuestion();

        /**
         * Checking if the game has ended.
         */

        Button btn = (Button)event.getSource();

        boolean thereIsNextQuestion = (next == btn) && !(game.isLastQuestion());

        if (thereIsNextQuestion) {

            loadQuestionsToScreen();
        }

        else {

            questionLabel.setText("Game is over. Play again.");

            next.setDisable(true);
            againBtn.setDisable(false);

            score.setText(String.valueOf(game.updateScoreCounter()));
        }

    }

    /**
     * Checks if all questions have been asked. If so, announces game
     * is over and show the score. Otherwise, loads the next question.
     *
     * @param event The event of the clicked button.
     */
    @FXML void againOnClick(ActionEvent event) {

        game.resetGame();

        next.setDisable(false);

        againBtn.setDisable(true);

        Collections.shuffle(game.questions);

        loadQuestionsToScreen();

        score.setText("Calculating");
        previousQuestionFeedback.setText("");
    }

    /**
     * Resets the game by resting game variables shuffling all questions agein.
     * And then, loads the first question.
     *
     * @param event The event of the clicked button.
     */
    @FXML void endGameOnClick(ActionEvent event) {

        game.resetGame();

        next.setDisable(false);

        againBtn.setDisable(true);

        Collections.shuffle(game.questions);

        loadQuestionsToScreen();

        score.setText("Calculating");
        previousQuestionFeedback.setText("");
    }

    /**
     * Loads question and its answers by showing their text on the screen.
     */
    private void loadQuestionsToScreen() {

        questionLabel.setText(game.getQuestion());

        /**
         * Shuffles answers before showing.
         */

        ArrayList<String> answers = game.getAnswer();

        Collections.shuffle(answers);

        for (int i = 0; i < answerTextFields.length; i++) {

            answerTextFields[i].setText(answers.get(i));
        }
    }
}
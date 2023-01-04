package com.example.java_mmn_13_task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    final static private int CORRECT_ANSWER_SCORE = 10;

    final static private int WRONG_ANSWER_SCORE = -5;

    final static private String FILE_NAME = "questions.txt";

    public ArrayList<Question> questions;

    public int numOfQuestions;

    private int currentQuestionNum;

    private int score;


    /**
     * Reads questions and answers from file, sets game score and the game's question index to 0,
     * and Calculates the number of questions in game.
     */
    public Game() {

        this.score = 0;
        this.currentQuestionNum = 0;

        this.questions = new ArrayList<>();


        ArrayList<String> answers = new ArrayList<>();

        TriviaController.playerAnswers = new ArrayList<>();


        Scanner fileReader = null;

        try {

            fileReader = new Scanner(new File(FILE_NAME));

            String currentQuestion = "";

            while (fileReader.hasNext()) {

                /**
                 * Putting first line as question and the next 4 lines as answers.
                 */

                currentQuestion = fileReader.nextLine();

                for (int i = 0; i < 4; i++) {

                    answers.add(fileReader.nextLine());
                }

                /**
                 * Using the read lines to create Question object.
                 */

                this.questions.add(new Question(currentQuestion, answers));

                answers = new ArrayList<>();
            }
        }

        catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }

        finally {

            fileReader.close();
        }


        /**
         * Calculating how many questions are in game.
         */

        this.numOfQuestions = this.questions.size();
    }

    /**
     * Checks if there are questions that have not been asked.
     */
    public boolean questionRemained() {

        return numOfQuestions > 0;
    }

    /**
     * Returns the question by using the Question object.
     *
     * @return question as String..
     */
    public String getQuestion() {

        return this.questions.get(this.currentQuestionNum).getQuestion();
    }

    /**
     * Returns the question's answers by using the Question object.
     *
     * @return answer as ArrayList of String.
     */
    public ArrayList<String> getAnswer() {

        return this.questions.get(currentQuestionNum).getQuestionAnswers();
    }

    /**
     * Increases game's question index by 1.
     */
    public void moveToNextQuestion() {

        this.currentQuestionNum++;
    }

    /**
     * Returns if it is last question of game by checking the value of the game's question index.
     *
     * @return True if it is last question.
     */
    public boolean isLastQuestion() {

        return this.currentQuestionNum == this.numOfQuestions;
    }

    /**
     * Checks if chosen answer is correct.
     *
     * @param answer String of answer that was chosen.
     *
     * @return True if it's correct answer and False otherwise.
     */
    public boolean checkIfAnswerIsCorrect (String answer) {

        return answer.equals(this.questions.get(this.currentQuestionNum).getCorrectAnswer());
    }

    /**
     * Checks if chosen answer is correct. If so, adds score points.
     * Otherwise, subtracts score points.
     *
     * @param answer String of answer that was chosen.
     */
    public void handleUserAnswers(String answer) {

        boolean answerIsCorrect = checkIfAnswerIsCorrect(answer);

        if (answerIsCorrect) {

            /**
             * handling possibility of duplicates and add user answer to answer list
             */

            if (!(TriviaController.playerAnswers.contains(answer))) {

                TriviaController.playerAnswers.add(answer);
            }

            this.score += CORRECT_ANSWER_SCORE;
        }

        else {

            this.score += WRONG_ANSWER_SCORE;
        }
    }

    /**
     * Returns score if it's last question of game. Otherwise, returns error value.
     *
     * @return True if it's last question.
     */
    public int updateScoreCounter() {

        if(this.isLastQuestion()) {

            return Math.max(this.score, 0);
        }

        return 404;
    }


    /**
     * Sets game score and the game's question index to 0,
     * and deleting previous chosen answers.
     */
    public void resetGame() {

        this.currentQuestionNum = 0;

        this.score = 0;

        TriviaController.playerAnswers = new ArrayList<>();
    }
}

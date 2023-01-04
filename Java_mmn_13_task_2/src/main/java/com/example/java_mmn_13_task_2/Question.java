package com.example.java_mmn_13_task_2;

import java.util.ArrayList;

public class Question {

    private String question;

    private ArrayList<String> answersList;

    private String correctAnswer;

    /**
     * Gets current question and all of its answers.
     *
     * @param question The String that is the question.
     * @param answersList All answer to question.
     */
    public Question(String question, ArrayList<String> answersList){

        /**
         * The first answer in answersList is the correct one.
         */
        this.correctAnswer = answersList.get(0);

        this.question = question;

        this.answersList = answersList;
    }

    /**
     * Returns the question.
     *
     * @return question as String.
     */
    public String getQuestion(){

        return question;
    }

    /**
     * Returns the correct answer to question.
     *
     * @return answer as String.
     */
    public String getCorrectAnswer(){

        return correctAnswer;
    }

    /**
     * Returns all answers to question.
     *
     * @return answers as Strings in ArrayList.
     */
    public ArrayList<String> getQuestionAnswers(){

        return answersList;
    }
}

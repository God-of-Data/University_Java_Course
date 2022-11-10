import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        BullsAndCows game = new BullsAndCows();


        String userGuess = null;

        boolean userGuessIsNotValid = true;

        while (userGuessIsNotValid) {

            userGuess = game.receiveUserGuess();

            userGuessIsNotValid = !(game.checkIfUserGuessIsValid(userGuess));
        }


        boolean gameIsOn = true;

        while (gameIsOn) {

            game.calculateUserGuessResults(userGuess);

            boolean userHasNotWon = !(game.checkIfUserHasWon(userGuess));

            if (userHasNotWon) {

                game.announceResults(false);

                userGuessIsNotValid = true;

                while (userGuessIsNotValid) {

                    userGuess = game.receiveUserGuess();

                    userGuessIsNotValid = !(game.checkIfUserGuessIsValid(userGuess));
                }
            }

            else {

                game.announceResults(true);


                String gameOutput = "Want to play again?";

                int userResponse
                        = JOptionPane.showConfirmDialog(null, gameOutput, "Bulls and Cows", JOptionPane.YES_NO_OPTION);

                if (userResponse == JOptionPane.YES_OPTION) {

                    game.restartGame();

                    userGuessIsNotValid = true;

                    while (userGuessIsNotValid) {

                        userGuess = game.receiveUserGuess();

                        userGuessIsNotValid = !(game.checkIfUserGuessIsValid(userGuess));
                    }
                }

                else {

                    gameIsOn = false;
                }
            }
        }
    }

}

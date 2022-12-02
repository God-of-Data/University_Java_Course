import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    /**
     * Creates a new AtomicExpression object by selecting random number.
     *
     * @return AtomicExpression object.
     */
    public static AtomicExpression createRandomAtomicExpression() {

        Random generator = new Random();

        String numericValue = generator.nextBoolean() ? String.valueOf(0.5) : String.valueOf(generator.nextInt(0,3));

        return new AtomicExpression(numericValue);
    }

    /**
     * Creates a new AdditionExpression object by calling to createRandomAtomicExpression function.
     *
     * @return AdditionExpression object.
     */
    public static AdditionExpression createRandomAdditionExpression() {

        return new AdditionExpression(createRandomAtomicExpression(), createRandomAtomicExpression());
    }

    /**
     * Creates a new SubtractionExpression object by calling to createRandomAtomicExpression function.
     *
     * @return SubtractionExpression object.
     */
    public static SubtractionExpression createRandomSubtractionExpression() {

        return new SubtractionExpression(createRandomAtomicExpression(), createRandomAtomicExpression());
    }


    public static void main(String[] args) {

        ArrayList<Expression> randomExpressions = new ArrayList<>();

        /**
         * Creating 9 random expressions and adding them to randomExpressions.
         */
        for (int i = 0; i < 3; i++) {

            randomExpressions.add(createRandomAtomicExpression());
            randomExpressions.add(new AdditionExpression(createRandomAdditionExpression(), createRandomSubtractionExpression()));
            randomExpressions.add(new SubtractionExpression(createRandomAdditionExpression(),createRandomAdditionExpression()));
        }


        Collections.shuffle(randomExpressions);

        int numberOfExpressions = randomExpressions.size();


        for (int i = 0; i < numberOfExpressions; i++) {

            Expression currExpression = randomExpressions.get(i);

            /**
             * Printing current expression and printing result by using calculate method.
             */
            String expressionOutput
                    = (i + 1) + ". Current expression is: " + currExpression.toString() + ". Result is: " + currExpression.calculate() + ".";

            System.out.println(expressionOutput);


            /**
             * Checking if there are other equal expressions to current expression in randomExpressions by using equals method.
             */
            randomExpressions.remove(i);

            if (randomExpressions.contains(currExpression)) {

                expressionOutput = "Expression is equal to:";

                for(Expression expression : randomExpressions) {

                    if(currExpression.equals(expression)) {

                        expressionOutput += " [" + expression + "]";
                    }
                }

                expressionOutput += ".";
            }

            else {

                expressionOutput = "Expression is not equal to another random expression.";
            }

            System.out.println(expressionOutput);

            randomExpressions.add(i,currExpression);
        }

    }
}

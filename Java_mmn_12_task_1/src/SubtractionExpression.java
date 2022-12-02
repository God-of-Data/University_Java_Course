public class SubtractionExpression extends CompoundExpression{


    public SubtractionExpression(Expression firstComponent, Expression secondComponent) {

        super(firstComponent, secondComponent);
    }

    /**
     * Calculates expression's results by subtracting results of calculate method of firstComponent, secondComponent attributes.
     *
     * @return expression's results as double type.
     */
    @Override
    public double calculate() {

        double subtractionExpressionResult
                = this.getFirstExpressionComponent().calculate() - this.getSecondExpressionComponent().calculate();

        return subtractionExpressionResult;
    }

    /**
     * Returns formatted expression by checking if results and types of firstComponent, secondComponent attributes.
     *
     * @return expression as a formatted string.
     */
    @Override
    protected String getExpression() {

        String formattedExpression;

        String firstSubtractionComponent = this.getFirstExpressionComponent().getExpression();
        String secondSubtractionComponent = this.getSecondExpressionComponent().getExpression();

        boolean secondExpressionComponentIsNegative = this.getSecondExpressionComponent().calculate() < 0;

        boolean secondExpressionComponentIsCompoundExpression
                = this.getSecondExpressionComponent() instanceof CompoundExpression;

        /**
         * Checking if second expression's component should be wrapped by brackets.
         */
        if (secondExpressionComponentIsCompoundExpression || secondExpressionComponentIsNegative) {

            formattedExpression = firstSubtractionComponent + " - (" + secondSubtractionComponent + ")";
        }

        else {

            formattedExpression = firstSubtractionComponent + " - " + secondSubtractionComponent;
        }


        return  formattedExpression;
    }


    @Override
    public String toString() {

        return this.getExpression();
    }
}


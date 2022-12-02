public class AdditionExpression extends CompoundExpression{


    public AdditionExpression(Expression firstComponent, Expression secondComponent) {

        super(firstComponent, secondComponent);
    }


    /**
     * Calculates expression's results by adding results of calculate method of firstComponent, secondComponent attributes.
     *
     * @return expression's results as double type.
     */
    @Override
    public double calculate() {

        double additionExpressionResult
                = this.getFirstExpressionComponent().calculate() + this.getSecondExpressionComponent().calculate();

        return additionExpressionResult;
    }


    /**
     * Returns formatted expression by checking if results and types of firstComponent, secondComponent attributes.
     *
     * @return expression as a formatted string.
     */
    @Override
    protected String getExpression() {

        String formattedExpression;

        String firstAdditionComponent = this.getFirstExpressionComponent().getExpression();
        String secondAdditionComponent = this.getSecondExpressionComponent().getExpression();

        boolean secondExpressionComponentIsNegative = this.getSecondExpressionComponent().calculate() < 0;

        boolean secondExpressionComponentIsCompoundExpression
                = this.getSecondExpressionComponent() instanceof CompoundExpression;


        /**
         * Checking if second expression's component should be wrapped by brackets.
         */
        if (secondExpressionComponentIsCompoundExpression || secondExpressionComponentIsNegative) {

            formattedExpression = firstAdditionComponent + " + (" + secondAdditionComponent + ")";
        }

        else {

            formattedExpression = firstAdditionComponent + " + " + secondAdditionComponent;
        }


        return  formattedExpression;
    }


    @Override
    public String toString() {

        return this.getExpression();
    }
}

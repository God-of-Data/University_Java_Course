public abstract class Expression {

    private String expression;

    public Expression() {}

    public Expression(String expression) {

        this.setExpression(expression);
    }

    protected String getExpression() {

        return expression;
    }

    private void setExpression(String expression) {

        this.expression = expression;
    }

    public abstract double calculate();


    /**
     * Checks if to Expression objects are equal by comparing their calculate method results.
     *
     * @param obj The second object in the comparison.
     *
     * @return True if objects are equal and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {

            return true;
        }

        if (!(obj instanceof Expression)) {

            return false;
        }

        Expression other = (Expression) obj;

        boolean expressionAreEquals = this.calculate() == other.calculate();

        return expressionAreEquals;
    }

}

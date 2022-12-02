public class AtomicExpression extends Expression{


    public AtomicExpression (String expression) {

        super(expression);
    }

    /**
     * Calculates expression's results by converting expression attribute to double.
     *
     * @return expression's results as double type.
     */
    @Override
    public double calculate() {

        double atomicExpressionResult = Double.parseDouble(this.getExpression());

        return atomicExpressionResult;
    }


    @Override
    public String toString() {

        return this.getExpression();
    }

}

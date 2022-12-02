public abstract class CompoundExpression extends Expression {

    private Expression firstExpressionComponent;
    private Expression secondExpressionComponent;


    public CompoundExpression (Expression firstComponent, Expression secondComponent) {

        super();

        this.setFirstExpressionComponent(firstComponent);
        this.setSecondExpressionComponent(secondComponent);
    }

    protected void setFirstExpressionComponent(Expression firstExpressionPortion) {

        this.firstExpressionComponent = firstExpressionPortion;
    }

    protected void setSecondExpressionComponent(Expression secondExpressionPortion) {

        this.secondExpressionComponent = secondExpressionPortion;
    }

    protected Expression getFirstExpressionComponent() {

        return this.firstExpressionComponent;
    }

    protected Expression getSecondExpressionComponent() {

        return this.secondExpressionComponent;
    }

}

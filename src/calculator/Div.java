package calculator;

public class Div extends BinaryExpression{
    public Div(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        if (right.calculate()== 0) {
            System.out.println("canot devied by zero!");
            return 0 ;
        }
        else
            return left.calculate() / right.calculate();
    }
}

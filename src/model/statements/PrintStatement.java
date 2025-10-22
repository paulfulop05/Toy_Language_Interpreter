package model.statements;

import model.adts.ProgramState;
import model.expressions.Expression;
import exceptions.MyException;

public record PrintStatement(Expression expression) implements StatementInterface {

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }

    public ProgramState execute(ProgramState state) throws MyException {
        var out = state.out();
        out.add(expression.evaluate(state.symTable()));

        return state;
    }

}

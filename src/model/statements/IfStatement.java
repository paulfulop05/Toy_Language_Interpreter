package model.statements;

import model.adts.ProgramState;
import model.expressions.Expression;
import exceptions.MyException;
import model.types.BoolType;
import model.values.BoolValue;

record IfStatement(Expression expression, StatementInterface thenS, StatementInterface elseS) implements StatementInterface {

    @Override
    public String toString() {
        return "(IF(" + expression.toString() + ") THEN(" + thenS.toString()
                + ")ELSE(" + elseS.toString() + "))";
    }

    public ProgramState execute(ProgramState state) throws MyException {
        var exeStack = state.exeStack();
        var cond = expression.evaluate(state.symTable());
        if (cond.getType() == BoolType.INSTANCE) {
            if (cond.equals(new BoolValue(true)))
                exeStack.push(thenS);
            else
                exeStack.push(elseS);
        } else throw new MyException("Condition is not boolean");

        return state;
    }
}

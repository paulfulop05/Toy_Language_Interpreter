package model.statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import model.states.MyMap;
import model.states.ProgramState;
import model.expressions.Expression;
import exceptions.MyException;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;

public record IfStatement(Expression expression, StatementInterface thenS, StatementInterface elseS) implements StatementInterface {

    public ProgramState execute(ProgramState state) throws StatementException {
        var exeStack = state.exeStack();
        var cond = expression.evaluate(state.symTable(), state.heapTable());
        if (cond.getType() == BoolType.INSTANCE) {
            if (cond.equals(new BoolValue(true)))
                exeStack.push(thenS);
            else
                exeStack.push(elseS);
        } else throw new StatementException("Condition is not boolean");

        return null;
    }

    @Override
    public MyMap<String, Type> typecheck(MyMap<String, Type> typeTable) throws TypecheckException {
        return null;
    }

    @Override
    public String toString() {
        return "IF (" + expression.toString() + ") THEN (" + thenS.toString() + ") ELSE (" + elseS.toString() + ")";
    }
}

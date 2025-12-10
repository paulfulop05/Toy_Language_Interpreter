package model.statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import model.expressions.Expression;
import model.states.MyMap;
import model.states.ProgramState;
import model.types.BoolType;
import model.types.Type;
import model.values.BoolValue;

public record WhileStatement(Expression expression, StatementInterface statement) implements StatementInterface {

    // here i basically need to push the statement back on the stack as long as the expression is true
    // + the while statement (this one) needs to be pushed as well so that it preserves the loop
    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        var evalExpression = expression.evaluate(state.symTable(), state.heapTable());

        if (!evalExpression.getType().equals(BoolType.INSTANCE))
            throw new StatementException("The expression is not a boolean");

        if (!((BoolValue) evalExpression).val())
            return null;

        state.exeStack().push(this);
        state.exeStack().push(statement);
        return null;
    }

    @Override
    public MyMap<String, Type> typecheck(MyMap<String, Type> typeTable) throws TypecheckException {
        return null;
    }

    @Override
    public String toString() {
        return "while (" + expression.toString() + ") do (" + statement.toString() + ')';
    }
}

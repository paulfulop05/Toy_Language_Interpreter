package model.statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import model.states.*;
import model.types.Type;
import model.values.Value;

public record ForkStatement(StatementInterface statement) implements StatementInterface {

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        var executionStack = new MyStack<StatementInterface>();
        executionStack.push(statement);

        return new ProgramState(
                executionStack,
                new MyMap<String, Value>(state.symTable().getMap()), // -> a copy of it, not reference
                state.out(),
                state.fileTable(),
                state.heapTable());
    }

    @Override
    public MyMap<String, Type> typecheck(MyMap<String, Type> typeTable) throws TypecheckException {
        return null;
    }

    @Override
    public String toString() {
        return "fork( " + statement.toString() + " )";
    }
}

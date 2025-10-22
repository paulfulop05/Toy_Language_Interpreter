package model.statements;

import exceptions.MyException;
import model.adts.ProgramState;

public record CompoundStatement(StatementInterface second, StatementInterface first) implements StatementInterface {

    @Override
    public String toString() {
        return "(" + first.toString() + ";" + second.toString() + ")";
    }

    public ProgramState execute(ProgramState state) throws MyException {
        var exeStack = state.exeStack();
        exeStack.push(second);
        exeStack.push(first);
        return state;
    }
}

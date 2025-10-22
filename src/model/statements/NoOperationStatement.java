package model.statements;

import model.adts.ProgramState;

public class NoOperationStatement implements StatementInterface {
    @Override
    public ProgramState execute(ProgramState state) {
        return state;
    }
}


package model.statements;

import exceptions.StatementException;
import model.expressions.Expression;
import model.states.ProgramState;

public record OpenFileStatement(Expression expression) implements StatementInterface {

    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        return null;
    }
}

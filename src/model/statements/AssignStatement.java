package model.statements;

import model.states.ProgramState;
import model.expressions.Expression;
import exceptions.MyException;
import model.values.Value;
import model.types.Type;

public record AssignStatement(String name, Expression expression) implements StatementInterface {

    @Override
    public String toString() {
        return name + " = " + expression.toString();
    }

    public ProgramState execute(ProgramState state) throws MyException {
        var symTable = state.symTable();

        if (symTable.isDefined(name)) {
            Value val = expression.evaluate(symTable);
            Type typeId = (symTable.lookup(name)).getType();
            if (val.getType().equals(typeId))
                symTable.update(name, val);
            else
                throw new MyException("declared type of variable " + name + " and type of the assigned expression do not match");
        } else throw new MyException("the used variable " + name + " was not declared before");
        return state;
    }
}

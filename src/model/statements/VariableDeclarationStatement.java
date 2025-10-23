package model.statements;

import exceptions.MyException;
import model.states.ProgramState;
import model.types.BoolType;
import model.types.IntType;
import model.types.Type;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;

public record VariableDeclarationStatement(String name, Type type) implements StatementInterface {

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        var symTable = state.symTable();

        Value defaultValue = null;
        if (!symTable.isDefined(name)) {
            if (type.equals(BoolType.INSTANCE))
                defaultValue = new BoolValue(false);
            else if (type.equals(IntType.INSTANCE))
                defaultValue = new IntValue(0);

            symTable.add(name, defaultValue);
        } else {
            throw new MyException("This is already declared!");
        }

        return state;
    }
}

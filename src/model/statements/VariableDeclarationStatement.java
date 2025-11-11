package model.statements;

import exceptions.DefinedIdException;
import exceptions.MyException;
import model.states.ProgramState;
import model.types.BoolType;
import model.types.IntType;
import model.types.StringType;
import model.types.Type;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;

public record VariableDeclarationStatement(String name, Type type) implements StatementInterface {

    @Override
    public ProgramState execute(ProgramState state) {
        var symTable = state.symTable();

        Value defaultValue = null;

        if (type.equals(BoolType.INSTANCE))
            defaultValue = BoolType.INSTANCE.getDefaultValue();
        else if (type.equals(IntType.INSTANCE))
            defaultValue = IntType.INSTANCE.getDefaultValue();
        else if (type.equals(StringType.INSTANCE))
            defaultValue = StringType.INSTANCE.getDefaultValue();

        // TODO maybe make this more elegant somehow

        symTable.add(name, defaultValue);

        return state;
    }

    @Override
    public String toString() {
        return type.toString() + ' ' + name;
    }
}

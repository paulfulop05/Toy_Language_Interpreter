package model.statements;

import exceptions.MyException;
import model.PrgState;
import model.types.BoolType;
import model.types.IntType;
import model.types.Type;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;

public class VarDeclStmt implements Istmt {
    private final String name;
    private final Type type;

    public VarDeclStmt(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        var symTable = state.getSymTable();

        Value defaultValue = null;
        if (!symTable.isDefined(name)) {
            if (type.equals(BoolType.INSTANCE))
                defaultValue = new BoolValue(false);
            else if (type.equals(IntType.INSTANCE))
                defaultValue = new IntValue(0);

            symTable.push(name, defaultValue);
        }
        else{
            throw new MyException("This is already declared!");
        }

        return state;
    }
}

package model.statements;

import exceptions.MyException;
import model.PrgState;
import model.types.Type;

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
        //symTable.
        return state;
    }

    //...
}

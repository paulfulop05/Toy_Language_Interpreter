package model.statements;

import exceptions.TypecheckException;
import model.states.map.MyMap;
import model.states.ProgramState;
import model.states.map.TypeTable;
import model.types.Type;

public class NoOperationStatement implements StatementInterface {
    @Override
    public ProgramState execute(ProgramState state) {
        return null;
    }

    @Override
    public TypeTable typecheck(TypeTable typeTable) throws TypecheckException {
        return typeTable;
    }

    @Override
    public String toString() {
        return "NOP";
    }
}


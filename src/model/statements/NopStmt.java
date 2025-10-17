package model.statements;

import exceptions.MyException;
import model.PrgState;

public class NopStmt implements Istmt{
    @Override
    public PrgState execute(PrgState state) {
        return state;
    }
}


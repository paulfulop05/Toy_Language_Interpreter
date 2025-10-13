package model.statements;

import exceptions.MyException;
import model.PrgState;

public class NopStmt implements Istmt{
    // fields if needed...

    @Override
    public PrgState execute(PrgState state) throws MyException {
        return null;
    }

    //..........................
}


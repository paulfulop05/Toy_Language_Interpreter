package model.statements;

import exceptions.MyException;
import model.PrgState;
import model.types.Type;

public class VarDeclStmt implements Istmt{
    String name;
    Type typ;

    @Override
    public PrgState execute(PrgState state) throws MyException {
        return null;
    }

    //...
}

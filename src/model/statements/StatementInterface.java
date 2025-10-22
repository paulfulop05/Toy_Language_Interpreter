package model.statements;

import exceptions.MyException;
import model.adts.ProgramState;

public interface StatementInterface {
    ProgramState execute(ProgramState state) throws MyException;
    //which is the execution method for a statement.
}

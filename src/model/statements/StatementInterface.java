package model.statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import model.states.ProgramState;

public interface StatementInterface {
    ProgramState execute(ProgramState state) throws StatementException;
    TypeTableInterface typecheck(TypeTableInterface typeTable) throws TypecheckException;
}

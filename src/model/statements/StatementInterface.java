package model.statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import model.states.map.MyMap;
import model.states.ProgramState;
import model.states.map.TypeTable;
import model.types.Type;

public interface StatementInterface {
    ProgramState execute(ProgramState state) throws StatementException;
    TypeTable typecheck(TypeTable typeTable) throws TypecheckException;
}

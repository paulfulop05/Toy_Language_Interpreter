package repo;

import exceptions.MyException;
import model.states.ProgramState;

public interface Repository {
    void addProgramState(ProgramState program);
    ProgramState getCurrentState();
    ProgramState getProgramState(int pos);
    void logProgramStateExecution() throws MyException;
}

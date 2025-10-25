package repo;

import model.states.ProgramState;

public interface Repository {
    void addProgramState(ProgramState program);
    ProgramState getCurrentState();
    ProgramState getProgramState(int pos);
}

package repo;

import model.adts.ProgramState;

public interface Repository {
    void addProgramState(ProgramState program);
    ProgramState getCurrentState();
}

package repo;

import model.adts.ProgramState;
import java.util.ArrayList;
import java.util.List;

public class ArrayListRepository implements Repository {
    private final List<ProgramState> programStates = new ArrayList<>();

    @Override
    public void addProgramState(ProgramState program) {
        programStates.add(program);
    }

    @Override
    public ProgramState getCurrentState() {
        return programStates.getFirst();
    }
}

package repo;

import model.PrgState;
import model.adts.MyIList;

public class MemoryRepository implements Repository {
    private final MyIList<PrgState> programs;

    public MemoryRepository(MyIList<PrgState> programs) {
        this.programs = programs;
    }

    // TODO constructor for this

    @Override
    public PrgState getCurrentPrg() {
        return null;
    }
}

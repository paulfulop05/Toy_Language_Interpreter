package repo;

import model.PrgState;
import model.adts.MyIList;
import model.adts.MyList;

public class MemoryRepository implements Repository {
    private final MyIList<PrgState> programs;

    public MemoryRepository(MyIList<PrgState> programs) {
        this.programs = programs;
    }

    public MemoryRepository() {
        this.programs = new MyList<PrgState>();
    }

    // TODO constructor for this

    @Override
    public PrgState getCurrentPrg() {
        return null;
    }
}

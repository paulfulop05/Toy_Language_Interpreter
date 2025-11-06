package repo;

import exceptions.MyException;
import model.states.ProgramState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArrayListRepository implements Repository {
    private final List<ProgramState> programStates = new ArrayList<>();
    private final String logFilePath;

    public ArrayListRepository(String logFilePath) {
        this.logFilePath = logFilePath; //initialized by a string read from the keyboard using Scanner class.
    }

    @Override
    public void addProgramState(ProgramState program) {
        programStates.add(program);
    }

    @Override
    public ProgramState getCurrentState() {
        return programStates.getFirst();
    }

    @Override
    public ProgramState getProgramState(int pos) {
        return programStates.get(pos);
    }

    @Override
    public void logProgramStateExecution() throws MyException {
        try {
            // TODO understand what this line means
            var logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.write(getCurrentState().toString());
        } catch (IOException e) {
            throw new MyException(e.getMessage());
        }
    }
}

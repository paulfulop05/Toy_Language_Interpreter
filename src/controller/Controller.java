package controller;

import exceptions.MyException;
import model.states.ProgramState;
import model.states.ExecutionStackInterface;
import model.states.LinkedListExecutionStack;
import model.states.ArrayListOut;
import model.states.MapSymbolTable;
import model.statements.StatementInterface;
import repo.ArrayListRepository;
import repo.Repository;

public record Controller(Repository repo) {
    public Controller() {
        this(new ArrayListRepository(""));
    }


    public void addNewProgram(StatementInterface program) {
        var executionStack = new LinkedListExecutionStack();
        executionStack.push(program);
        repo.addProgramState(new ProgramState(
                executionStack,
                new MapSymbolTable(),
                new ArrayListOut()));
    }

    public ProgramState executeOneStep(ProgramState state) {
        ExecutionStackInterface executionStack = state.exeStack();
        StatementInterface nextStatement = executionStack.pop();
        return nextStatement.execute(state);
    }

    // executes a certain program from the repository
    public void executeProgram(int pos) throws MyException {
        var programState = repo.getProgramState(pos);
        int count = 0;

        while (!programState.exeStack().isEmpty()) {
            ++count;
            repo.logProgramStateExecution();
            executeOneStep(programState);
            IO.print(count);
            displayProgramState(pos);
        }
    }

    public void executeCurrentProgram() {
        var programState = repo.getCurrentState();
        int count = 0;
        while (!programState.exeStack().isEmpty()) {
            ++count;
            executeOneStep(programState);
            IO.print(count);
            displayCurrentState();
        }
    }

    public void displayProgramState(int pos) {
        IO.print(repo.getProgramState(pos).toString());
    }

    public void displayCurrentState() {
        IO.print(repo.getCurrentState().toString());
    }
}

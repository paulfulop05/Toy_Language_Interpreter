package controller;

import exceptions.MyException;
import model.states.*;
import model.statements.StatementInterface;
import repo.ArrayListRepository;
import repo.Repository;

import java.io.PrintWriter;

public record Controller(Repository repo) {
    public void addNewProgram(StatementInterface program) {
        var executionStack = new LinkedListExecutionStack();
        executionStack.push(program);
        repo.addProgramState(new ProgramState(
                executionStack,
                new MapSymbolTable(),
                new ArrayListOut(),
                new MapFileTable()));
    }

    public ProgramState executeOneStep(ProgramState state) {
        ExecutionStackInterface executionStack = state.exeStack();
        StatementInterface nextStatement = executionStack.pop();
        return nextStatement.execute(state);
    }

    // executes a certain program from the repository
    public void executeProgram(int pos) throws MyException {
        var programState = repo.getProgramState(pos);
        repo.logProgramStateExecution(pos);
        while (!programState.exeStack().isEmpty()) {
            executeOneStep(programState);
            repo.logProgramStateExecution(pos);
        }
    }

    public void executeCurrentProgram() throws MyException {
        var programState = repo.getCurrentState();
        repo.logCurrentProgramStateExecution();
        while (!programState.exeStack().isEmpty()) {
            executeOneStep(programState);
            repo.logCurrentProgramStateExecution();
        }
    }

    public void displayProgramState(int pos) {
        IO.print(repo.getProgramState(pos).toString());
    }
    public void displayCurrentState() { IO.print(repo.getCurrentState().toString()); }
}

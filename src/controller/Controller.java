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
        this(new ArrayListRepository());
    }


    public void addNewProgram(StatementInterface program) {
        var executionStack = new LinkedListExecutionStack();
        executionStack.push(program);
        repo.addProgramState(new ProgramState(
                executionStack,
                new MapSymbolTable(),
                new ArrayListOut()));
    }

    public ProgramState executeOneStep(ProgramState state) throws MyException {
        ExecutionStackInterface executionStack = state.exeStack();
        if (executionStack.isEmpty()) throw new MyException("state stack is empty");

        StatementInterface nextStatement = executionStack.pop();
        return nextStatement.execute(state);
    }

    public void executeProgram(int pos) throws MyException {
        var programState = repo.getProgramState(pos);
        while (!programState.exeStack().isEmpty()) {
            executeOneStep(programState);
            displayCurrentState();
        }
    }

    public void executeCurrentProgram() throws MyException {
        var programState = repo.getCurrentState();
        while (!programState.exeStack().isEmpty()) {
            executeOneStep(programState);
            displayCurrentState();
        }
    }

    public void displayCurrentState() {
        IO.print(repo.getCurrentState().toString());
    }
}

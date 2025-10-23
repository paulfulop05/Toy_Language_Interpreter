package model.states;


public record ProgramState(
        ExecutionStackInterface exeStack, SymbolTableInterface symTable, OutInterface out) {
}


package model.adts;


public record ProgramState(
        ExecutionStackInterface exeStack, SymbolTableInterface symTable, OutInterface out) {
}


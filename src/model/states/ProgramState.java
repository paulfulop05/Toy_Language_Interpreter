package model.states;


public record ProgramState(
        ExecutionStackInterface exeStack, SymbolTableInterface symTable, OutInterface out) {

    @Override
    public String toString() {
        return "\nEXECUTION STACK:" + exeStack.toString() +
                "\nSYMBOL TABLE:" + symTable.toString() +
                "\nOUT:" + out.toString() + "\n\n";
    }
}


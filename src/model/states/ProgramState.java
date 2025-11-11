package model.states;


public record ProgramState(
        ExecutionStackInterface exeStack, SymbolTableInterface symTable, OutInterface out, FileTableInterface fileTable) {

    @Override
    public String toString() {
        return "\nEXECUTION STACK:\n" + exeStack.toString() +
                "\nSYMBOL TABLE:\n" + symTable.toString() +
                "\nOUT:\n" + out.toString() +
                "\nFILE TABLE\n" + fileTable.toString() + "\n\n";
    }
}


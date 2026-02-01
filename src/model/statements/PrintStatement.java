package model.statements;

import exceptions.TypecheckException;
import model.states.map.MyMap;
import model.states.ProgramState;
import model.expressions.Expression;
import model.states.map.TypeTable;
import model.types.Type;

public record PrintStatement(Expression expression) implements StatementInterface {

    public ProgramState execute(ProgramState state) {
        var out = state.out();
        out.add(expression.evaluate(state.symTable(), state.heapTable()));

        return null;
    }

    @Override
    public TypeTable typecheck(TypeTable typeTable) throws TypecheckException {
        expression.typecheck(typeTable);
        return typeTable;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }
}

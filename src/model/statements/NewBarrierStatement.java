package model.statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import javafx.util.Pair;
import model.expressions.Expression;
import model.states.ProgramState;
import model.states.map.tables.TypeTable;
import model.values.IntValue;
import java.util.ArrayList;

public record NewBarrierStatement(String variableName, Expression expression) implements StatementInterface {
    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        var num = expression.evaluate(state.symTable(), state.heapTable());
        if(num instanceof IntValue){
            int location = state.barrierTable().add(new Pair<>(((IntValue) num).val(), new ArrayList<>()));

            var variableValue = state.symTable().lookup(variableName);
            if (variableValue instanceof IntValue) {
                state.symTable().update(variableName, new IntValue(location));
            }
            else{
                throw new StatementException("BarrierTable: the variable is not of type int");
            }
        }
        else{
            throw new StatementException("BarrierTable: Invalid expression");
        }

        return null;
    }

    @Override
    public TypeTable typecheck(TypeTable typeTable) throws TypecheckException {
        return null;
    }
}

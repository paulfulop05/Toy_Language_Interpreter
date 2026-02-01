package model.statements.thread_statements;

import exceptions.StatementException;
import exceptions.TypecheckException;
import javafx.util.Pair;
import model.expressions.Expression;
import model.statements.StatementInterface;
import model.states.ProgramState;
import model.states.map.tables.TypeTable;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import java.util.ArrayList;

public record NewBarrierStatement(String variableName, Expression expression) implements StatementInterface {
    @Override
    public ProgramState execute(ProgramState state) throws StatementException {
        var num = expression.evaluate(state.symTable(), state.heapTable());
        if(num instanceof IntValue){
            int location = state.barrierTable().add(new Pair<>(((IntValue) num).val(), new ArrayList<>()));

            var variableValue = state.symTable().lookup(variableName);
            if (variableValue.getType() instanceof IntType) {
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
        Type variableType = typeTable.lookup(variableName);
        Type expressionType = expression.typecheck(typeTable);

        if(!(variableType instanceof IntType &&  expressionType instanceof IntType))
            throw new TypecheckException("Variable and expression type not of type IntType");
        return typeTable;
    }
}

package model.values;

import model.types.IntType;
import model.types.Type;

public class IntValue implements Value{
    private final int val;

    public IntValue(int val){ this.val = val; }
    public int getVal() { return val; }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    public Type getType() { return IntType.INSTANCE; }
}


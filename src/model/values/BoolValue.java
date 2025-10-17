package model.values;

import model.types.BoolType;
import model.types.Type;

public class BoolValue implements Value
{
    public boolean val;
    public BoolValue(boolean val) { this.val = val; }
    public boolean getVal() { return val; }

    @Override
    public Type getType() {
        return BoolType.INSTANCE;
    }
}

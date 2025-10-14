package model.values;

import model.types.BoolType;
import model.types.Type;


//TODO this might not be correct
public class BoolValue implements Value
{
    public boolean value;
    public BoolValue(boolean value)
    {
        this.value = value;
    }

    @Override
    public Type getType() {
        return BoolType.INSTANCE;
    }
}

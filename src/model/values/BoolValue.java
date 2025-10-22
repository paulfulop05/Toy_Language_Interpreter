package model.values;

import model.types.BoolType;
import model.types.Type;

public record BoolValue(boolean val) implements Value {

    @Override
    public Type getType() {
        return BoolType.INSTANCE;
    }
}

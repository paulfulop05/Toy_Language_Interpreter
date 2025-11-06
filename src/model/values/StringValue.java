package model.values;

import model.types.StringType;
import model.types.Type;

public record StringValue(String val) implements Value {

    public String getValue() {
        return val;
    }

    @Override
    public Type getType() {
        return StringType.INSTANCE;
    }

    // i guess like this? not sure
    @Override
    public boolean equals(Object another){
        return another instanceof StringValue;
    }
}

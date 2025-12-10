package model.states;


import exceptions.UndefinedIdException;
import exceptions.ValueNotFoundException;
import model.values.IntValue;
import model.values.Value;

// TODO see if this works right

public class MyHeap extends MyMap<IntValue, Value> {
    private int freeLocation;

    public MyHeap() {
        super();
        this.freeLocation = 1;
    }

    @Override
    public Value lookup(IntValue key) throws UndefinedIdException, ValueNotFoundException {
        if (!isDefined(key)) throw new UndefinedIdException(String.valueOf(key));
        var value = map.get(key);

        if (value == null) throw new ValueNotFoundException();
        return value;
    }

    public int add(Value value) { // returns the address in which the value was added
        super.add(new IntValue(freeLocation), value);
        int oldFreeLocation = freeLocation;
        updateFreeLocation();
        return oldFreeLocation;
    }

    private void updateFreeLocation() {
        int i;
        for (i = 1; i <= map.size(); i++) {
            if (!isDefined(new  IntValue(i))) {
                freeLocation = i;
                return;
            }
        }
        freeLocation = i;
    }

    @Override
    public String toString(){
        String text = "";
        for (var key  : map.keySet()) {
            text += key.val() + " --> " + map.get(key).toString() + '\n';
        }

        return text;
    }
}

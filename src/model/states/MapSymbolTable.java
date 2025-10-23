package model.states;

import exceptions.MyException;
import model.values.Value;

import java.util.HashMap;
import java.util.Map;

public class MapSymbolTable implements SymbolTableInterface {
    private final Map<String, Value> map;

    public MapSymbolTable() {
        this.map = new HashMap<String, Value>();
    }

    @Override
    public Value lookup(String key) throws MyException {
        if (!isDefined(key)) throw new MyException("Key not found!");

        var value = map.get(key);
        if (value == null) throw new MyException("Value not found!");
        return value;
    }

    @Override
    public boolean isDefined(String key) {
        return map.containsKey(key);
    }

    @Override
    public void add(String key, Value value) throws MyException {
        if (isDefined(key)) throw new MyException("Key is already defined!");
        map.put(key, value);
    }

    @Override
    public Value remove(String key) throws MyException {
        if (!isDefined(key)) throw new MyException("Key not found!");
        return map.remove(key);
    }
    
    @Override
    public void update(String name, Value val) {
        map.put(name, val);
    }
}

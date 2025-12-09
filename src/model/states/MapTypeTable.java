package model.states;

import exceptions.DefinedIdException;
import exceptions.UndefinedIdException;
import exceptions.ValueNotFoundException;
import model.types.Type;

import java.util.HashMap;
import java.util.Map;


// TODO change all of this if there's a better way to do it
public class MapTypeTable implements TypeTableInterface {
    private final Map<String, Type> map;

    public MapTypeTable() {
        this.map = new HashMap<>();
    }
    public MapTypeTable(Map<String, Type> map) {this.map = map;}

    @Override
    public Map<String, Type> getMap() {
        return map;
    }

    @Override
    public Type lookup(String key) throws UndefinedIdException, ValueNotFoundException {
        if (!isDefined(key)) throw new UndefinedIdException(key);

        var value = map.get(key);
        if (value == null) throw new ValueNotFoundException();
        return value;
    }

    @Override
    public boolean isDefined(String key) {
        return map.containsKey(key);
    }

    @Override
    public void add(String key, Type value) throws DefinedIdException {
        if (isDefined(key)) throw new DefinedIdException(key);
        map.put(key, value);
    }

    @Override
    public Type remove(String key) throws UndefinedIdException {
        if (!isDefined(key)) throw new UndefinedIdException(key);
        return map.remove(key);
    }

    @Override
    public void update(String key, Type val) throws UndefinedIdException {
        if (!isDefined(key)) throw new UndefinedIdException(key);
        map.put(key, val);
    }

    @Override
    public String toString() {
        String text = "";
        for (var key  : map.keySet()) {
            text += key + " --> " + map.get(key) + '\n';
        }

        return text;
    }
}

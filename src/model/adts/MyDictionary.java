package model.adts;

import exceptions.MyException;

import java.util.HashMap;
import java.util.Map;

class MyDictionary<K, V> implements MyIDictionary<K, V> {
    private final Map<K, V> map;

    public MyDictionary() {
        this.map = new HashMap<K, V>();
    }

    @Override
    public V lookup(K key) throws MyException {
        if (!isDefined(key)) throw new MyException("Key not found!");

        var value = map.get(key);
        if (value == null) throw new MyException("Value not found!");
        return value;
    }

    @Override
    public boolean isDefined(K key) {
        return map.containsKey(key);
    }

    @Override
    public void add(K key, V value) throws MyException {
        if (isDefined(key)) throw new MyException("Key is already defined!");
        map.put(key, value);
    }

    @Override
    public V remove(K key) throws MyException {
        if (!isDefined(key)) throw new MyException("Key not found!");
        return map.remove(key);
    }
}

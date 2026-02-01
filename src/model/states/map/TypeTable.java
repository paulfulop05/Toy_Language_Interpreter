package model.states.map;

import model.types.Type;

public class TypeTable extends MyMap<String, Type>{
    public TypeTable deepcopy() {
        TypeTable typeTableCopy = new TypeTable();
        for(var entry : map.entrySet()){
            typeTableCopy.add(entry.getKey(), entry.getValue().copy());
        }

        return typeTableCopy;
    }

}

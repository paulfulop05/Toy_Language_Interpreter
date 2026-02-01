package model.states.map;

public class MyHeap<V> extends MyMap<Integer, V> {
    private int freeLocation;

    public MyHeap() {
        super();
        this.freeLocation = 1;
    }

    public int add(V value) { // returns the address in which the value was added
        super.add(freeLocation, value);
        int oldFreeLocation = freeLocation;
        updateFreeLocation();
        return oldFreeLocation;
    }

    private void updateFreeLocation() {
        int i;
        for (i = 1; i <= map.size(); i++) {
            if (!isDefined(i)) {
                freeLocation = i;
                return;
            }
        }
        freeLocation = i;
    }
}

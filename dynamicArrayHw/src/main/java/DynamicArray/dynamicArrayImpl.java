package DynamicArray;

public class dynamicArrayImpl<E> implements dynamicArray<E>{

    private E[] values = (E[]) new Object[16];
    private int pointer = 0;

    @Override
    public void add(E item) {
        if(pointer == values.length-1)
            resize(values.length*2);
        values[pointer++] = item;
    }

    @Override
    public E get(int i) {
        return values[i];
    }

    @Override
    public void set(int i, E item) {
        values[i] = item;
    }

    @Override
    public void delete(int index) {
        for (int i = index; i<pointer; i++)
            values[i] = values[i+1];
        values[pointer] = null;
        pointer--;
    }

    @Override
    public E[] getAll() {
        return values;
    }

    @Override
    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(values, 0, newArray, 0, pointer);
        values = (E[]) newArray;
    }
}


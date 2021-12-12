package DynamicArray;

public interface dynamicArray<E> {
    void add(E item);
    E get(int i);
    void set(int i, E item);
    void delete(int i);
    E[] getAll();
    int size ();
}

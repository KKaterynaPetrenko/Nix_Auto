package DynamicArray;

public class dynamicArrayTest {
    public static void main(String[] args) {
        dynamicArray<Integer> x = new dynamicArrayImpl<Integer>();

        x.add(4);
        x.add(5);
        x.add(6);
        x.delete(1);

        System.out.println(x.get(1));
    }
}

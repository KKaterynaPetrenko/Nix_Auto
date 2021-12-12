package CustomMap;

public class CustomMapTest {
    public static void main(String[] args) {
        CustomMapImpl<Integer, String> x = new CustomMapImpl<Integer, String>();
        x.put(1, "value1");
        x.put(2, "value2");
        x.put(3, "value3");
        x.put(3,"something_new");
        System.out.println(x.allValues());
        System.out.println(x.setKeys());
        System.out.println(x.get(2));
    }
}

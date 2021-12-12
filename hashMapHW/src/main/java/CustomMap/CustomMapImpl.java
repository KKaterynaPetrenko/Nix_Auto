package CustomMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomMapImpl <K, V> implements CustomMap <K, V>{

    private  List <Node <K, V>> nodes = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        for (Node<K, V> node: nodes) {
            if (key.hashCode() == node.key.hashCode() && key.equals(node.key)) {
               node.setValue(value);
               return;
            }
        }
        nodes.add(new Node<K, V>(key, value));
    }

    @Override
    public Set<K> setKeys() {
        return nodes.stream().map(kvNode -> kvNode.getKey()).collect(Collectors.toSet());
    }

    @Override
    public List<V> allValues() {
        return nodes.stream().map(kvNode -> kvNode.getValue()).collect(Collectors.toList());
    }

    @Override
    public V get(K key) {
        for (Node<K, V> node: nodes)
          if (key.hashCode() == node.key.hashCode()) {
           return node.getValue();
        }
        return null;
    }

    private static class Node <K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }



    }
}

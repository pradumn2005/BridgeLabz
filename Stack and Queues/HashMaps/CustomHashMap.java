public class CustomHashMap {
    private class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node[] buckets;
    private int capacity = 1000;
    
    public CustomHashMap() {
        buckets = new Node[capacity];
    }
    
    private int getHash(int key) {
        return Math.abs(key) % capacity;
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        current.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = getHash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(2, 200);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
    }
}

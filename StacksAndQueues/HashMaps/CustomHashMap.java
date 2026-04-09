class HashNode {
    Integer key;
    Integer value;
    HashNode next;

    public HashNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap {
    private HashNode[] bucketArray;
    private int numBuckets;
    private int size;

    public CustomHashMap() {
        bucketArray = new HashNode[10];
        numBuckets = 10;
        size = 0;
    }

    private int getBucketIndex(Integer key) {
        return Math.abs(key.hashCode()) % numBuckets;
    }

    public void add(Integer key, Integer value) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray[bucketIndex];
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    public Integer get(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.add(1, 100);
        map.add(2, 200);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}

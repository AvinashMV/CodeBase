import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-04
 */
public class MyHashMap {
    private int[] Map;

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        Map = new int[10000001];
        Arrays.fill(Map,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return Map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

    }
}

/**
 * @author Avinash Vijayakumar
 * 2019-03-05
 */
public class Solution {
    public static void main(String[] args) {
        LRU obj = new LRU(5);
        obj.put(1,1);
        obj.put(2,3);
        obj.put(3,4);
        obj.put(4,7);
        obj.put(6,10);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(1,5);
        obj.put(12,7);
        obj.put(5,2);
        System.out.println(obj.get(4));

    }
}

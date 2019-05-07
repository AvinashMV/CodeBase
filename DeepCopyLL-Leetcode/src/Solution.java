import java.util.HashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-04-21
 */
public class Solution {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        // have to do it with maps.
        Map<Node,Node> map = new HashMap<>();
        // copy all nodes.
        Node p =  head;
        while(p!=null){
            map.put(p,new Node(p.val,null,null));
            p = p.next;
        }

        // assign next and random pointer vals
        p  = head;
        while(p!=null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;

        }

        return map.get(head);
    }
}

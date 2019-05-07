import java.util.HashMap;
import java.util.Map;

/**
 * @author Avinash Vijayakumar
 * 2019-04-20
 */
public class Solution {
    Node head,tail;
    int maxCapacity,numOfElements;
    Map<String,Node> map = new HashMap<>();

    public Solution(int p_maxCapacity){
        maxCapacity = p_maxCapacity;
        head = new Node("null");
        tail = new Node("null");
        head.next = tail;
        tail.prev= head;

    }

    public static void main(String[] args) {
        Solution solution = new Solution(5);
        String[] items = {"a","b","c","a","c","f","b","d","h","l","m","n","b"};
        for(String s:items){
            solution.addEntry(s);
            solution.display();
        }
    }

    public void display(){
        Node p = head.next;
        while(p!=tail){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }

    public void addEntry(String s){
        if(map.containsKey(s)){
            moveFront(map.get(s));
        }else{
            Node t = new Node(s);
            map.put(s,t);
            addNode(t);
            numOfElements++;

            if(numOfElements>maxCapacity){
                removeEntry();
            }
        }


    }

    // adds always at the front.
    public void addNode(Node root){
        root.next = head.next;
        root.prev = head;

        head.next.prev =root;
        head.next = root;
    }

    // removes the node at given location.
    public void removeNode(Node root){
        Node prevNode = root.prev;
        Node nextNode = root.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void moveFront(Node root){
        removeNode(root);
        addNode(root);
    }

    // remove the last node and from the map.
    public void removeEntry(){
        Node removedNode = tail.prev;
        removeNode(removedNode);
        map.remove(removedNode.val);
        numOfElements--;
    }




}

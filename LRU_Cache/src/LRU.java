import java.util.HashMap;

/**
 * @author Avinash Vijayakumar
 * 2019-03-05
 */
public class LRU {
    class Node{
        int key,val;
        Node prev,next;
        public Node(){
            prev = null;
            next = null;
        }
    }

    private Node head,tail;
    private int maxCapacity,elementsInCache;
    private HashMap<Integer,Node> registry = new HashMap<>();

    // initialization and basic set up.
    public LRU(int capacity){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        elementsInCache = 0;
        maxCapacity = capacity;
    }

    // always adds a node in front.
    public void addNode(Node root){
        root.next = head.next;
        head.next.prev = root;

        root.prev = head;
        head.next = root;
    }

    // just removes the given node from the node chain.
    public void removeNode(Node root){
        Node prevSaved = root.prev;
        Node nextSaved = root.next;

        prevSaved.next = nextSaved;
        nextSaved.prev = prevSaved;
    }

    // moves the given node to front.
    public void moveToFront(Node root){
        removeNode(root);
        addNode(root);
    }

    // removes the last node from the node chain and returns it.
    public Node popTail(){
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    // always removes the last node from node chain and from registry
    public void removeEntryLRU(){
        Node lastNode = popTail();
        registry.remove(lastNode.key);
        elementsInCache--;
    }

    // 2nd biggest method.
    public int get(int key){
        if(registry.containsKey(key)){
            Node root = registry.get(key);

            // move it to front.
            moveToFront(root);
            return root.val;
        }
        return -1;
    }

    public void put(int key,int val){
        // if it already exist
        if(registry.containsKey(key)){
            Node root = registry.get(key);
            root.val = val;
            moveToFront(root);
        }else{
            // Doesn't exit previously.
            // first add registry entry and front at node chain.
            Node root = new Node();
            root.key = key;
            root.val = val;
            registry.put(key,root);
            addNode(root);
            elementsInCache++;

            // check for capacity and delete if required.
            if(elementsInCache > maxCapacity)
                removeEntryLRU();
        }
    }



}

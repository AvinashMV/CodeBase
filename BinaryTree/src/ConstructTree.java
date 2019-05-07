import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Avinash Vijayakumar
 * 2019-01-21
 */
// construct a BST with a minimal height from a given array.
// Property: duplicate nodes will be on the left of the array.

public class ConstructTree {
    private static Node head;

    public ConstructTree(){
        head = null;
    }

    // Function to insert nodes in level order
    public Node insertLevelOrder(Integer[] arr, Node root, int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            // insert left child
            root.setLeft(insertLevelOrder(arr, root.getLeft(), 2 * i + 1));

            // insert right child
            root.setRight(insertLevelOrder(arr, root.getRight(), 2 * i + 2));
        }
        return root;
    }


    public Node constructBST(int arr[]){
        int middle = (0+arr.length) /2;
        if(head==null){
            Node t = new Node(arr[middle]); // don't insert middle again.
            head = t;
        }
        for(int i=0;i<middle;i++){
            insertNodeBST(arr[i],head);
        }

        for(int i= middle+1;i<arr.length;i++){
            insertNodeBST(arr[i],head);
        }

        return head;
    }

    public void insertNodeBST(int value,Node root){
        if(root!=null){
            if(value < root.getValue()){
                if(root.getLeft()!=null)
                    insertNodeBST(value, root.getLeft());
                else{
                    Node t = new Node(value);
                    root.setLeft(t);
                }
            }
            else{
                if(root.getRight()!=null)
                    insertNodeBST(value, root.getRight());
                else{
                    Node t = new Node(value);
                    root.setRight(t);
                }
            }
        }
    }


    public void displayInorder(Node root){
        if(root!=null){
            displayInorder(root.getLeft());
            System.out.print(root.getValue()+"\t");
            displayInorder(root.getRight());
        }
    }

    // construct LL of all the nodes at each level.
    public void constructLL(Node root, ArrayList<LinkedList<Integer>> lists , int level){
        if(root!=null){
            LinkedList<Integer> list = null;
            if(lists.size()==level){
                list = new LinkedList<>();
                lists.add(list);
            }else{
                list = lists.get(level);
            }

            list.add(root.getValue());
            constructLL(root.getLeft(),lists,level+1);
            constructLL(root.getRight(),lists,level+1);
        }
    }

    public int calHeight(Node root){
        if(root!=null){
            if(root.getLeft()==null && root.getRight()==null)
                return 1;

            return Math.max( calHeight(root.getLeft()), calHeight(root.getRight()) )+1;
        }
        return -1;
    }

    public boolean checkBalance(Node root){
        int balFactor = 0;
        if(root!=null){
            balFactor = Math.abs(calHeight(root.getLeft()) - calHeight(root.getRight()));
            checkBalance(root.getLeft());
            checkBalance(root.getRight());
        }
        return balFactor < 1;
    }

}

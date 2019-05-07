import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-21
 */
public class MainClass {
    public static void main(String[] args) {

        ConstructTree constructTreeobj = new ConstructTree();
        /*
        ********************************
        * To construct BST
        ********************************
         */
        /*int[] arr= {1,23,34,39,43,45,58,69};
        Node head = constructTreeobj.constructBST(arr);
        constructTreeobj.displayInorder(head);*/

        /*
         ********************************
         * To construct BT
         ********************************
         */
        Node head = new Node();
        int arr[] = {12,14,13,15,20};
        head = constructTreeobj.constructBST(arr);
        //constructTreeobj.displayInorder(head);

        /*
         ********************************
         * To construct Linkedlist of all nodes at each level.
         ********************************
         */
        /*ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        constructTreeobj.constructLL(head,lists,0);
        System.out.println(Arrays.toString(lists.toArray()));*/

        /*System.out.println(constructTreeobj.calHeight(head));
        System.out.println(constructTreeobj.checkBalance(head)); */

        /*
         ********************************
         * To get vertical level order.
         ********************************
         */

        VerticalLevelOrder obj = new VerticalLevelOrder();
        obj.getVerticalLevelOrder(head);


    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-01-11
 */
/*
This program removes the duplicate in array list while maintaining the input order.

 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,3,4,1};
        Node head = constructLL(arr);
       // display(head);
        /*removeDup(head);
        display(head);*/

        head  = reverse(head);
        display(head);
    }

    private static Node reverse(Node head){
        Node prev = null, cur = head, next = cur.getLink();
        while(cur!=null){
            cur.setLink(prev);
            prev = cur;
            cur = next;

            if(next!=null)
                next = next.getLink();
        }
        return prev;
    }

    private static void removeDup(Node head){
        List<Integer> mylist = new ArrayList<>();
        Node cur = head;
        Node prev = head;
        while(cur!=null){
            if(!mylist.contains(cur.getValue())){
                mylist.add(cur.getValue());
                prev = cur;
                cur = cur.getLink();
            }
            else{
                prev.setLink(cur.getLink());
                cur = cur.getLink();
            }
        }
    }

    private static void display(Node head){
        Node p = head;
        while(p!=null) {
            System.out.print(p.getValue() + "\t");
            p = p.getLink();
        }
        System.out.println();
    }

    private static Node constructLL (int[] arr){
        Node head = null;

        for(int i=0;i<arr.length;i++){
            Node temp = new Node(arr[i]);

            if(head==null){
                head = temp;
            }
            else{
                Node p = head;
                while(p.getLink()!=null)
                    p = p.getLink();
                p.setLink(temp);
            }
        }
        return head;
    }
}


/*
Test cases
 int[] arr = {4,5,6,4,6,5,7,7};
 int[] arr = {1,1,2,2,3,3,4,4,4,5}
 int[] arr = {1,2,3,4,2,3,4,1}


 */
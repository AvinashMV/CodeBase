/**
 * @author Avinash Vijayakumar
 * 2019-05-16
 */
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode k = head;

        ListNode i = l1;
        ListNode j = l2;
        int carry =0;

        while(i!=null || j!=null){
            int sum = carry;

            if(i!=null) {
                sum += i.val;
                i = i.next;
            }

            if(j!=null) {
                sum += j.val;
                j = j.next;
            }

            // append unit digit at last to k.
            ListNode t = new ListNode(sum%10);
            k.next = t;
            k = t;
            carry = sum/10;
        }

        // append carry to k.
        if(carry!=0){
            ListNode t = new ListNode(carry);
            k.next = t;
            k = t;
        }

        return head.next;
    }
}

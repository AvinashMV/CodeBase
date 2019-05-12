import java.awt.*;

/**
 * @author Avinash Vijayakumar
 * 2019-03-30
 */
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<2){
            if(lists.length==0) return null;
            if(lists.length==1) return lists[0];
        }

        int lo=0,hi = lists.length-1;
        ListNode result = Util(lists,lo,hi);
        return result;
    }

    private ListNode Util(ListNode[] lists, int lo,int hi){
        if(lo==hi)
            return lists[lo];

        int mid = (lo+hi)/2;
        ListNode left = Util(lists,lo,mid);
        ListNode right = Util(lists,mid+1,hi);
        return merge(left,right);

    }

    private ListNode merge(ListNode p,ListNode q){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(p!=null && q!=null){
            if(p.val<=q.val){
                ListNode t = new ListNode(p.val);
                t.next = null;
                cur.next =t;
                cur  = t;
                p = p.next;
            }else{
                ListNode t = new ListNode(q.val);
                t.next = null;
                cur.next =t;
                cur  = t;
                q = q.next;
            }
        }

        while(p!=null){
            ListNode t = new ListNode(p.val);
            t.next = null;
            cur.next =t;
            cur  = t;
            p = p.next;
        }

        while(q!=null){
            ListNode t = new ListNode(q.val);
            t.next = null;
            cur.next =t;
            cur  = t;
            q = q.next;
        }

        return head.next;
    }
}

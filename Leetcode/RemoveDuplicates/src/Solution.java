import java.util.Stack;

/**
 * @author Avinash Vijayakumar
 * 2019-01-16
 */
public class Solution {
    public static void removeDup(Node head){
        Node p = head;
        while(p!=null){
            Node cur = p.getLink(), prev = cur;
            while(cur!=null){
                if(cur.getValue()==p.getValue()){
                    prev.setLink(cur.getLink());
                    cur = cur.getLink();
                }else{
                    prev = cur;
                    cur = cur.getLink();
                }
            }
            p = p.getLink();
        }
    }

    public void display(Node head){
        Node p = head;
        while(p!=null) {
            System.out.print(p.getValue() + "\t");
            p = p.getLink();
        }
        System.out.println();
    }

    public  Node constructLL (int[] arr){
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


    public Node kthToLastNode(Node head, int k){
        int len = 0;
        Node cur = head;
        while(cur!=null){
            len++;
            cur = cur.getLink();
        }

        int targetNodeLen =len - k;
        cur = head;
        for(int i=0;i<targetNodeLen-1;i++){
            cur = cur.getLink();
        }
        return cur;
    }

    public boolean isPalindrome(Node head){
        Stack<Integer> stack = new Stack();
        Node cur = head;
        while(cur != null){
            stack.push(cur.getValue());
            cur = cur.getLink();
        }

        cur = head;
        while(cur!=null){
            if(stack.peek()!=cur.getValue())
                return false;
            stack.pop();
            cur = cur.getLink();
        }
        return true;
    }

    // lets assume that both have same length.
    public Node addLL(Node head1, Node head2){
        Node p1 = head1, p2 = head2;
        int sum = 0, carry = 0;
        Node head = null , cur = null;

        while( p1!=null && p2!=null){
            sum = carry;
            sum = sum+ p1.getValue() + p2.getValue();
            Node temp = new Node(sum%10);
            carry = sum / 10;
            if(head==null){
                head = temp;
                cur = head;
            }
            else{
                cur.setLink(temp);
                cur = cur.getLink();
            }
            p1 = p1.getLink();
            p2 = p2.getLink();
        }
        if(carry>0){
            Node temp = new Node(carry);
            cur.setLink(temp);
            cur = cur.getLink();
        }
        return head;
    }

    // add LL if digits are stored in forward order.
    // lets say length of both are same.
    public Node addLL2 (Node head1, Node head2){
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        Node cur = head1;
        while(cur!=null){
            stack1.push(cur.getValue());
            cur = cur.getLink();
        }

        cur = head2;
        while(cur!=null){
            stack2.push(cur.getValue());
            cur = cur.getLink();
        }

        int sum = 0, carry =0;
        Node head = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            sum = carry;
            sum += stack1.pop()+ stack2.pop();
            Node temp = new Node(sum%10);
            carry = sum/10;

            if(head == null){
                head = temp;
            }
            else{
                temp.setLink(head);
                head = temp;
            }
        }
        if(carry>0){
            Node t = new Node(carry);
            t.setLink(head);
            head =t;
        }
        return head;
    }

    public Node partition(Node phead,int val){
        Node lesser = null, greater = null;
        Node lesserEndPtr = null, greaterEndPtr = null;

        Node cur = phead;
        while(cur!=null){
            Node t = new Node(cur.getValue());

            if(cur.getValue()<val){
                // update lesser LL
                if(lesser==null) {
                    lesser = t;
                    lesserEndPtr = lesser;
                }
                else{
                    lesserEndPtr.setLink(t);
                    lesserEndPtr = lesserEndPtr.getLink();
                }
            }
            else{
                // update greater LL
                if(greater==null){
                    greater = t;
                    greaterEndPtr = greater;
                }else{
                    greaterEndPtr.setLink(t);
                    greaterEndPtr = greaterEndPtr.getLink();
                }
            }
            cur =cur.getLink();
        }

        if(lesser==null)
            return greater;
        else if(greater==null)
            return lesser;

        // combine it and return lesser.
        lesserEndPtr.setLink(greater);
        return lesser;

    }

}

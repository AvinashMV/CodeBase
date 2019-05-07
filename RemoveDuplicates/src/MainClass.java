/**
 * @author Avinash Vijayakumar
 * 2019-01-16
 */
public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] arr={1,2,2,2,1};
        Node head = solution.constructLL(arr);
        solution.display(head);*/

        // Return kth to last node
        /*
        Node kthnode = solution.kthToLastNode(head,3);
        System.out.println("Kth to last node value is "+ kthnode.getValue());*/

        // To remove duplicates without temporary buffer

        /*System.out.println("Before removing duplicates");
        solution.display(head);
        System.out.println("After removing duplicates");
        solution.removeDup(head);
        solution.display(head);*/

        // To check if linked list a palindrome or not.
        //System.out.println(solution.isPalindrome(head));

        // To add two LL stored in reverse order.
        // lets say both will be of same length.
        /*int[] arr1 = {6,5,2};
        int[] arr2 = {2,1,9};
        Node head1 = solution.constructLL(arr1);
        solution.display(head1);
        System.out.println();

        Node head2 = solution.constructLL(arr2);
        solution.display(head2);
        System.out.println();

        Node head3 = solution.addLL(head1,head2);
        solution.display(head3);
        System.out.println();*/


        /*
        *******************************
         To add two linked list if numbers are stored in forward order.
        ********************************
         */
        /*int[] arr1 = {2,9,8};
        int[] arr2 = {9,9,9};
        Node head1 = solution.constructLL(arr1);
        Node head2 = solution.constructLL(arr2);

        solution.display(head1);
        System.out.println();
        solution.display(head2);
        System.out.println();

        Node head3 = solution.addLL2(head1,head2);
        solution.display(head3);
        System.out.println(); */

        /*
        *******************************
         Partition the linked list around an element.
        ********************************
         */
        int[] arr1={3,5,8,5,10,2,1};
        Node head1 = solution.constructLL(arr1);
        System.out.println("Original LL before partitioning is ");
        solution.display(head1);
        System.out.println();

        Node head2 = solution.partition(head1,5);
        System.out.println("After partition ");
        solution.display(head2);
        System.out.println();


    }
}

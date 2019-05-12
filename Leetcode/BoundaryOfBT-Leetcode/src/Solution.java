import java.net.Inet4Address;
import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-04
 */
public class Solution {
    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {

    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
       if(root==null)
           return result;
       result.add(root.val);
       getLeftBoundary(root.left);
       getLeaf(root.left);
       getLeaf(root.right);
       getrightBoundary(root.right);
       return result;

    }

    // add all left boundary except leaf. Preorder traversal.
    public void getLeftBoundary(TreeNode root){
       if((root==null) || (root.left==null && root.right==null))
           return;
       result.add(root.val);
       getLeftBoundary(root.left==null?root.right:root.left);
    }


    // add all right boundary in post order traversal.
    public void getrightBoundary(TreeNode root){
        if((root==null)||(root.left==null && root.right==null))
            return;
        getrightBoundary(root.right==null?root.left:root.right);
        result.add(root.val);

    }

    // get all leaf nodes. Preorder traversal.
    public void getLeaf(TreeNode root){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            result.add(root.val);
            return;
        }
        getLeaf(root.left);
        getLeaf(root.right);

    }
}

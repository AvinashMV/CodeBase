/**
 * @author Avinash Vijayakumar
 * 2019-04-27
 */
public class Solution {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case 1
        if(root==null)
            return null;

        // base case 2
        if(root==p || root==q)
            return root;

        // make a return decision based on left and right.
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null)
            return root;

        if(left==null && right==null)
            return null;

        return left==null?right:left;
    }
}

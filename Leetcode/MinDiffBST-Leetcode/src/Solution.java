

/**
 * @author Avinash Vijayakumar
 * 2019-04-07
 */
public class Solution {
    private int minDiff;

    public Solution(){
        minDiff = Integer.MAX_VALUE;
    }

    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        Util(root,null,null);
        return minDiff;

    }

    private void Util(TreeNode root,Integer maxVal,Integer minVal){
        if(root==null){
            return;
        }

        if(maxVal!=null){
            minDiff = Math.min( Math.abs(root.val-maxVal), minDiff) ;
        }

        if(minVal!=null){
            minDiff = Math.min( Math.abs(root.val-minVal),minDiff);
        }

        //branching left, update max.
        Util(root.left,root.val,minVal);

        // branching right, update min
        Util(root.right,maxVal,root.val);
    }
}

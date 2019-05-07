import java.util.ArrayList;
import java.util.List;

/**
 * @author Avinash Vijayakumar
 * 2019-04-12
 */
public class Solution {
    private List<Integer> arr = new ArrayList<>();

    private void  getArray(TreeNode root){
        if(root==null)
            return;

        getArray(root.left);
        arr.add(root.val);
        getArray(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        getArray(root);
        for(int i=0;i<arr.size()-1;i++){
            for(int j=i+1;j<arr.size();j++){
                if(arr.get(i)+arr.get(j)==k){
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Test cases:
[2,3,4,5,6,7]
 */
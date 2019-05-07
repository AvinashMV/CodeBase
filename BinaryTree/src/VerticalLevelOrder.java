import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Avinash Vijayakumar
 * 2019-02-15
 */
public class VerticalLevelOrder {
    private TreeMap<Integer,List<Integer>> myMap = new TreeMap<>();
    public void getVerticalLevelOrder(Node head){
        helper(head,0);
        System.out.println(myMap);

    }

    public void helper(Node head,int verticalLevel){
        if(head==null)
            return;

        if(myMap.containsKey(verticalLevel)){
            List<Integer> t = myMap.get(verticalLevel);
            t.add(head.getValue());

        }else{
            List<Integer> t = new ArrayList<>();
            t.add(head.getValue());
            myMap.put(verticalLevel,t);
        }

        helper(head.getLeft(),verticalLevel-1);
        helper(head.getRight(),verticalLevel+1);
    }
}

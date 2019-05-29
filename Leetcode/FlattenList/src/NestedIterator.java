import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Avinash Vijayakumar
 * 2019-05-21
 */
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue  = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    public void helper(List<NestedInteger> list){
        for(NestedInteger in:list){
            if(in.isInteger()){
                queue.add(in.getInteger());
            }else{
                helper(in.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext())
            return queue.poll();
        return -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty()?true:false;

    }
}


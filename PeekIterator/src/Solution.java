import java.util.Iterator;

/**
 * @author Avinash Vijayakumar
 * 2019-05-05
 */
public class Solution implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iter;

    public Solution(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if(iter.hasNext()){
            next = iter.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer cur = next;
        next = iter.hasNext()?iter.next():null;
        return cur;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }
}

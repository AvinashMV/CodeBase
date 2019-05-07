import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Avinash Vijayakumar
 * 2019-05-01
 */
public class Solution {
    HashMap<Integer,Integer> impMap = new HashMap<>();
    HashMap<Integer,List<Integer>> subMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
       for(Employee emp:employees){
           impMap.put(emp.id,emp.importance);
           subMap.put(emp.id,emp.subordinates);
       }

       int result = 0;
       Queue<Integer> empQ = new LinkedList<>();
       empQ.add(id);
       while(! empQ.isEmpty()){
           int curID = empQ.poll();
           result += impMap.get(curID);

           // add subordinates to the queue.
           for(int i:subMap.get(curID)){
               empQ.add(i);
           }
       }
       return result;
    }
}

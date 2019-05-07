import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Avinash Vijayakumar
 * 2019-03-16
 *
 * Given a shorter, longer wooden planks, you must use exactly k wooden planks.
 * Generate different possible lengths of a diving board.
 * Diving board is made from joining wooden planks end to end.
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.divingBoard(2,3,6);
        // System.out.println(countDivingBoardsOfKPieces(2,3,3));
    }


    public static Set<Integer> countDivingBoardsOfKPieces(final int smaller, final int larger, final int k) {
        final Set<Integer> boards = new HashSet<>();
        if (k > 0) {
            boards.add(larger*k);
            for (int i = smaller*k; i < larger*k; i += (larger - smaller)) {
                boards.add(i);
            }
        }
        return boards;
    }


    public List<Integer> divingBoard(int s, int l, int k){
        List<Integer> divingBoardList = new ArrayList<>();
        int[] db = new int[k];

        IntStream.range(0,k)
                .forEach(i->db[i]=s);

        int count =1;
        int len = 0;
        while(count<=k){
            len = Arrays.stream(db).reduce(0,(a,b)->a+b);
            divingBoardList.add(len);
            int t = k - count;
            db[t]=l;
            count++;
        }
        // last one.
        len = Arrays.stream(db).reduce(0,(a,b)->a+b);
        divingBoardList.add(len);

        System.out.println(divingBoardList);
        return  divingBoardList;
    }
}

import java.util.Arrays;

/**
 * @author Avinash Vijayakumar
 * 2019-04-14
 */
public class Solution {
    private int boomrangs = 0;

    public static void main(String[] args) {
        int[][] arr = {{0,0},{1,0},{2,0}};
        Solution solution = new Solution();
        solution.numberOfBoomerangs(arr);
    }

    public int numberOfBoomerangs(int[][] points) {
        int[][]result = new int[3][];
        int[] count = new int[points.length];
        Arrays.fill(count,1);

        Util(points,0,result,count);
        System.out.println(boomrangs);
        return boomrangs;
    }

    public void Util(int[][]points,int level,int[][] result,int[] count){

        if(level==3){
            findDistance(result);
            return;
        }

        for(int i=0;i<count.length;i++){
            if(count[i]==0)
                continue;

            result[level]=points[i];
            count[i]--;
            //recursion
            Util(points,level+1,result,count);
            count[i]++;
        }
    }
    private void findDistance(int[][]arr){
        int[] bm1 = arr[0],bm2 = arr[1], bm3 = arr[2];
        double dist1 =  Math.sqrt( Math.pow((bm1[0]-bm2[0]),2) + Math.pow(bm1[1]-bm2[1],2) );
        double dist2 =  Math.sqrt( Math.pow((bm1[0]-bm3[0]),2) + Math.pow(bm1[1]-bm3[1],2) );

        if(dist1==dist2) {
            boomrangs++;
            System.out.println(Arrays.deepToString(arr));
        }
    }
}

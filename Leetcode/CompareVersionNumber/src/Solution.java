/**
 * @author Avinash Vijayakumar
 * 2019-05-16
 */
public class Solution {
    public static void main(String[] args) {
        String v1 = "7.5.2.4";
        String v2 = "7.5.3";
        Solution solution = new Solution();
        int res = solution.compareVersion(v1,v2);
        System.out.println(res);
    }

    public int compareVersion(String version1, String version2) {
        // split both numbers on "."
        String[] v1Split = version1.split("\\.");
        String[] v2Split = version2.split("\\.");

        int i=0,j=0;
        int curV1 = -1, curV2 = -1;
        while(i<v1Split.length || j<v2Split.length){
            curV1 = i<v1Split.length?Integer.parseInt(v1Split[i]):0;
            curV2 = j<v2Split.length?Integer.parseInt(v2Split[j]):0;

            if(curV1<curV2)
                return -1;
            else if(curV1>curV2)
                return 1;

            i++;j++;
        }

        return 0;
    }
}

/*
Test cases:
0.1, 1.1 ans -1
1.0.1  , 1 ans 1
7.5.2.4 , 7.5.3 ans -1
1.0,1 ans 0

 */
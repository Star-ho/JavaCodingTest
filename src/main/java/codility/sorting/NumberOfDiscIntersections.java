package codility.sorting;


// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int[][] checkArr=new int[A.length][A.length];
        Integer[][] discArray=new Integer[A.length][2];

        for(int i=0;i<A.length;i++){
            discArray[i]=new Integer[]{i,A[i]};
        }

        Arrays.sort(discArray,new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return 0;
            }

            public int compareTo(int[] a, int[] b){
                return b[1]-a[1];
            }
        });

        return 1;
    }
}


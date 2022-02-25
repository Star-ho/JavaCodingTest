package codility.sorting;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int aLen=A.length;
        if(A[aLen-1]>0){
            if(A[0]*A[1]*A[aLen-1]>A[aLen-1]*A[aLen-2]*A[aLen-3]){
                return A[aLen-1]*A[0]*A[1];
            }else{
                return A[aLen-1]*A[aLen-2]*A[aLen-3];
            }
        }else{
            return A[aLen-1]*A[aLen-2]*A[aLen-3];
        }
    }
}
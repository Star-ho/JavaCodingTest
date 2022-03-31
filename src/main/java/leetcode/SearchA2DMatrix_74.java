package leetcode;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo=0;
        int hi=matrix.length-1;
        while(lo<hi){
            int mid=(lo+hi)>>>1;
            if(matrix[mid][0]<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        int row=lo;
        if(matrix[row][0]>target){
            row--;
        }
        if(row==-1)return false;
        lo=0;
        hi=matrix[row].length-1;
        while(lo<hi){
            int mid=(lo+hi)>>>1;
            if(matrix[row][mid]<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        if(matrix[row][lo]==target){
            return true;
        }
        return false;
    }
}

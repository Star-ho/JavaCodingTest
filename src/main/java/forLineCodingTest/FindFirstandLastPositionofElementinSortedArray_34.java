package forLineCodingTest;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray_34 {
    public static void main(String[] arg){
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 7, 8, 8, 8, 9, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7,7,7,8, 8, 8, 8,9,9, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int mid=(lo+hi)>>>1;
            if(nums[mid]<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        int start=lo;
        lo=0;
        hi=nums.length-1;
        while(lo<hi){
            int mid=((lo+hi)>>>1)+1;
            if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        if(nums[start]!=target){
            start=-1;
        }
        if(nums[lo]!=target){
            lo=-1;
        }
        return new int[]{start,lo};
    }
}

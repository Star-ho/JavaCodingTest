package leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int m) {
        int lo= Arrays.stream(nums).max().getAsInt();
        int hi= Arrays.stream(nums).sum();
        while(lo<hi){
            int mid=(lo+hi)>>>1;
            int res=check(nums,m,mid);
            if(res==-1){
                lo=mid+1;
            }else{
                hi=mid;
            }

        }
        return lo;
    }
    private int check(int[] nums, int m, int max){
        int preSum=0;
        int maxSum=0;
        for(int i=0;i<nums.length;i++){
            if(preSum+nums[i]<=max){
                preSum+=nums[i];
            }else{
                maxSum=Math.max(maxSum,preSum);
                preSum=nums[i];
                m--;
            }
            if(m==0)return -1;
        }
        maxSum=Math.max(maxSum,preSum);
        return maxSum;
    }
}

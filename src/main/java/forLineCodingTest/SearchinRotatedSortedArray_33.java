package forLineCodingTest;

public class SearchinRotatedSortedArray_33 {
    public static void main(String[] arg){
        System.out.println(search(new int[]{3,4,5,6,1,2},2));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(search(new int[]{1}, 0));
    }
    public static int search(int[] nums, int target) {
        int lo=0;
        int hi=nums.length;
        while(lo<hi){
            int mid=(lo+hi)>>>1;
             System.out.println(nums[mid]+" "+aa(mid,nums,target));
            if(nums[mid]==target) {
                lo=mid;
                break;
            }
            if(aa(mid,nums,target)){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        if(lo>=nums.length||lo<0||nums[lo]!=target)return -1;
        return lo;
    }

    private static boolean aa(int idx, int[] nums, int target){
        if(target<nums[0]){
            if(nums[idx]>nums[0]-1){
                return true;
            }else{
                if(nums[idx]<target){
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            if(nums[idx]<nums[0]-1){
                return false;
            }else{
                if(nums[idx]>target){
                    return false;
                }else{
                    return true;
                }
            }
        }
    }
}

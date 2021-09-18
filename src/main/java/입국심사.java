import java.util.*;

public class 입국심사 {
    public static void main(String[] arg){
        System.out.println(solution(10,new int[]{1,2,3,4,8}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long left=0;
        long right=(long)Arrays.stream(times).max().getAsInt()*n;
        while (left<right){
            long mid=(right+left)/2;
            long count=0;
            for(long i:times){
                count+=mid/i;
            }
            if(count>=n){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        loop:while (right>0){
            for(long i:times){
                if(right%i==0) {
                    answer = right;
                    break loop;
                }
            }
            right--;
        }

        return answer;
    }
}

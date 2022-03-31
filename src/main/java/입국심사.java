public class 입국심사 {

    public static void main(String[] arg){
        System.out.println(solution(6,new int[]{7, 10}	)+" 28");
        System.out.println(solution(6,new int[]{1000000000, 10}	)+" 60");
        System.out.println(solution(1000000000,new int[]{1000000000}	)+" 6000000000");
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long low=0;
        long hi= (long) n *times[times.length-1];
        System.out.println(hi);
        while(low<hi){
            long mid=(long)((low+hi)>>>1);
            if(getNum(mid,times)<n){
                low=mid+1;
            }else{
                hi=mid;
            }
        }
        return low;
    }
    private static long getNum(long cur,int[] times){
        long res=0;
        for(int time:times){
            res+=cur/time;
        }
        return res;
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap2 {
    public static void main(String args[]){
        System.out.println(solution(new int[][]{{1, 9},{0, 3}, {2, 6}}));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        var priorityJobs=new PriorityQueue<Integer>();
        Arrays.sort(jobs, (a,b)->a[0]-b[0] );
        int time=0;
        int startTime=0;
        while(jobs.length>0){

        }

        return answer;
    }
}

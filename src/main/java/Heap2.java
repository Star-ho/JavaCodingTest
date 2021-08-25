import java.util.*;


public class Heap2 {
    public static void main(String args[]){

        System.out.println(solution(new int[][]{{1, 9},{0, 3}, {2, 6}}));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        List<int[]> jobsList=new ArrayList<int[]>(Arrays.asList(jobs));
            PriorityQueue<int[]> jobPriority=new PriorityQueue<>(jobs.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Collections.sort(jobsList,(a,b)->a[0]-b[0]);
        int len=jobs.length;
        int time=0;


        while(jobsList.size()>0||jobPriority.size()>0){
            for(int i=0;i<jobsList.size();i++){
                if(jobsList.get(i)[0]<=time){
                    jobPriority.add(jobsList.get(i));
                    jobsList.remove(i);
                    i--;
                }
            }
            if(jobPriority.size()>0){
                var temp=jobPriority.poll();
                time+=temp[1];
                answer+=time-temp[0];
            }else{
                time=jobsList.get(0)[0];
            }
        }
        return answer/len;
    }
}

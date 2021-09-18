import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 네트워크 {
    public static void main(String[] arg){
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        int[] nArr=new int[n];
        for(int i=0;i<nArr.length;i++) {
            if(nArr[i]==-1) continue;
            answer++;
            Queue<Integer> integerQueue=new LinkedList<>();
            integerQueue.offer(i);
            nArr[i]=-1;
            while (integerQueue.size() > 0) {
                int cur=integerQueue.poll();
                for(int j=0;j<computers[cur].length;j++){
                    if(computers[cur][j]==1){
                        if(nArr[j]!=-1){
                            integerQueue.offer(j);
                        }
                        nArr[j]=-1;
                    }
                }
            }
        }
        return answer;
    }
}

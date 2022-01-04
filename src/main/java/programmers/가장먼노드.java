package programmers;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] arg){
        System.out.println(solution(6,new int[][]{ {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 4} } ));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] cache=new boolean[n];
        int[] distence=new int[n];
        List<List<Integer>> intList=new ArrayList<>();
        for(int i=0;i<n;i++){
            intList.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            intList.get(edge[i][0]-1).add(edge[i][1]-1);
            intList.get(edge[i][1]-1).add(edge[i][0]-1);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        cache[0]=true;
        int len=0;
        while (queue.size()>0){
            var start=queue.poll();
            var curList=intList.get(start);
            for(int cur:curList){
                if(cache[cur]==false){
                    queue.add(cur);
                    distence[cur]=distence[start]+1;
                    cache[cur]=true;
                }
            }
        }

        int maxLen= Arrays.stream(distence).max().getAsInt();
        for(int i=0;i< distence.length;i++){
            if(maxLen==distence[i]){
                answer++;
            }
        }
        return answer;
    }
}

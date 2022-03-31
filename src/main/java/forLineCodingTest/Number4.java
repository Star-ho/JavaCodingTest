package forLineCodingTest;

import java.util.Arrays;

public class Number4 {
    public static void main(String[] arg){
        System.out.println(Arrays.toString(solution(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}})) +" "+16);

        System.out.println(Arrays.toString(solution(4, new int[][]{{2, 3}, {0, 1}, {1, 2}})) +" "+8);
    }

    public static int[] solution(int n, int[][] edges) {
        int[][] graph=new int[n][n];
        for(int[] edge:edges){
            graph[edge[0]][edge[1]]=1;
            graph[edge[1]][edge[0]]=1;
        }
        int answer=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][j]==graph[i][k]+graph[i][j]){
                        answer++;
                    }
                }
            }
        }
        return new int[]{1, 5, 2, 6, 3, 7, 4};

    }
}

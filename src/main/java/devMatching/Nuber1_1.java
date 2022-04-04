package devMatching;

import java.util.Arrays;

public class Nuber1_1 {
    public static void main(String[] arg){
        System.out.println(Arrays.deepToString(solution(new int[][]{{0,2,3,1},{2,0,1,1},{3,1,0,2},{1,1,2,0}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3}, {1, 6, 3, 3, 0}})));
    }
    public static int[][] solution(int[][] dist) {
        int[][] answer={};
        int[] loc=new int[dist.length];
        loc[1]=dist[0][1];

        aa: for(int k=2;k<dist.length;k++){
            for(int i=0;i< dist.length;i++){
                for(int j=0;j< dist.length;j++){
                    if(dist[i][j]==dist[i][k]+dist[k][j]){

                        break aa;
                    }
                }
            }
        }
        return answer;
    }
}

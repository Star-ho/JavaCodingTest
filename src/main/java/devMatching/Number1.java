package devMatching;

import java.util.Arrays;

public class Number1 {
    public static void main(String[] arg){
        System.out.println(Arrays.deepToString(solution(new int[][]{{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3}, {1, 6, 3, 3, 0}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{0,2,3,1},{2,0,1,1},{3,1,0,2},{1,1,2,0}})));
//        System.out.println(Arrays.deepToString(solution(new int[][]{{0,1,2,1,2},{1,0,1,2,3},{2,1,0,3,4},{1,2,3,0,1},{2,3,4,1,0}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{0,1,2,3,4}, {1,0,1,2,3}, {2,1,0,1,2}, {3,1,2,0,1}, {4,3,2,1,0}})));
    }
    public static int[][] solution(int[][] dist) {
        int[] loc=new int[dist.length];
        loc[1]=dist[0][1];
        for(int i=2;i<loc.length;i++){
            for(int j=1;j<i;j++){
                if(loc[j]>0&&Math.abs(dist[0][i]-dist[0][j])==dist[j][i]){
//                    System.out.println(loc[j]+" "+dist[j][i]);
                    loc[i] = dist[0][i];
                    break;
                }
            }
            if(loc[i]==0){
                loc[i] = -dist[0][i];
            }
        }
        int[][] locIndex=new int[loc.length][2];
        for(int i=0;i<loc.length;i++){
            locIndex[i]=new int[]{i,loc[i]};
        }
        System.out.println(Arrays.deepToString(locIndex));
        Arrays.sort(locIndex,(a,b)->a[1]-b[1]);
        int[][] answer = new int[2][loc.length];

        for(int i=0;i<loc.length;i++){
            answer[0][i]=locIndex[i][0];
            answer[1][answer[1].length-1-i]=locIndex[i][0];
        }
        Arrays.sort(answer,(a,b)->a[0]-b[0]);

        return answer;
    }
}

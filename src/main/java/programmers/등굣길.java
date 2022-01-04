package programmers;

import java.util.Arrays;

public class 등굣길 {
    public static void main(String[] arg){
        System.out.println(solution(6,5,new int[][]{{3, 2},{2,3},{2,4},{1,2}} ) );
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] roadArr=new int[n][m];
        for(int[] puddle:puddles){
            roadArr[puddle[1]-1][puddle[0]-1]=-1;
        }
        roadArr[0][0]=1;
        for(int i=0;i<roadArr.length;i++){
            if(roadArr[i][0]==-1)break;
            roadArr[i][0]=1;
        }
        for(int j=0;j<roadArr[0].length;j++){
            if(roadArr[0][j]==-1)break;
            roadArr[0][j]=1;
        }
        for(int i=1;i<roadArr.length;i++){
            for(int j=1;j<roadArr[i].length;j++){
                if(roadArr[i][j]==-1){

                }else if(roadArr[i][j-1]==-1&&roadArr[i-1][j]!=-1){
                    roadArr[i][j]=roadArr[i-1][j];
                }else if(roadArr[i-1][j]==-1&&roadArr[i][j-1]!=-1){
                    roadArr[i][j]=roadArr[i][j-1];
                }else if(roadArr[i][j-1]==-1&&roadArr[i-1][j]==-1){
                    roadArr[i][j]=0;
                }else {
                    roadArr[i][j]=(roadArr[i-1][j]+roadArr[i][j-1])%1000000007;
                }
            }
        }
        for(var i:roadArr){
            System.out.println(Arrays.toString(i));
        }
        answer=roadArr[roadArr.length-1][roadArr[0].length-1];
        return answer;
    }
}

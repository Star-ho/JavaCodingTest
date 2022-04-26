package programmers.previous;

import java.util.Arrays;

public class 피로도 {
    public static void main(String[] arg){
        System.out.println(solution(100,new int[][]{{80,20}, {50,40}, {30,10},{20,10},{10,10}}));
    }


    public static int solution(int k, int[][] dungeons) {
        Boolean[] check=new Boolean[dungeons.length];
        Arrays.fill(check,false);
        return DFS(dungeons,check,k,0);
    }

    public static int DFS( int[][] dungeons, Boolean[] check,int k,int curSuccessDungeons) {
        if(curSuccessDungeons==dungeons.length){
            return curSuccessDungeons;
        }

        int temp=curSuccessDungeons;
        for(int i=0;i<dungeons.length;i++){
            if (!check[i]){
                check[i]=true;
                if (k>=dungeons[i][0]){
                    int temp2=DFS(dungeons,check,k-dungeons[i][1],curSuccessDungeons+1);
                    if (temp<temp2)temp=temp2;
                    if (temp==dungeons.length)return temp;
                }
                check[i]=false;
            }
        }
        return temp;
    }


}

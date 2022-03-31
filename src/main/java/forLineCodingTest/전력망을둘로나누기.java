package forLineCodingTest;

import java.util.*;

public class 전력망을둘로나누기 {
    public static void main(String[] arg){

        System.out.println(solution(9,new int[][]{{1,3},{3,4},{4,6},{4,7},{7,8},{7,9},{2,3},{4,5}}));
//        System.out.println(solution(4,new int[][]{{1,2},{2,3},{3,4}}));
//        System.out.println(solution(7,new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
//        System.out.println(solution(7,new int[][]{{1,2},{7,2},{7,3},{3,4},{4,5},{6,7}}));
//        System.out.println(solution(7,new int[][]{{1,2},{7,2},{7,3},{3,4},{4,5},{6,7}}));
    }

    public static int solution(int n, int[][] wires) {
        int answer = 100;
        int[] parents=new int[n+1];
        for(int i=0;i<wires.length;i++){
            for(int j=1;j<parents.length;j++){
                parents[j]=j;
            }

            for(int j=0;j<wires.length;j++){
                if(j==i)continue;
                union(wires[j][0],wires[j][1],parents);
            }
//            Map<Integer,Integer> map=new HashMap<>();
            int tmp=0;
            for(int j=1;j<parents.length;j++){
                int p=find(parents[j],parents);
                if(p==1){
                    tmp++;
                }
            }
            System.out.println(Arrays.toString(parents));
            int res=Math.abs(n-2*tmp);
            answer=Math.min(answer,res);
        }
        return answer;
    }

    public static void union(int x, int y, int[] parents){
        int a=find(x,parents);
        int b=find(y, parents);
        if(a>b){
            parents[a]=b;
        }else{
            parents[b]=a;
        }
    }
    public static int find(int x,int[] parents){
        if(x==parents[x]){
            return x;
        }
        return find(parents[x],parents);
    }
}

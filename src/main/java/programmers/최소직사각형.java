package programmers;

public class 최소직사각형 {
    public static void main(String[] arg){
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30},{80, 40}}));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxMax=0;
        int minMax=0;
        for(int[] size:sizes){
            if(size[0]>size[1]){
                if(size[0]>maxMax){
                    maxMax=size[0];
                }
                if(size[1]>minMax){
                    minMax=size[1];
                }
            }else{
                if(size[1]>maxMax){
                    maxMax=size[1];
                }
                if(size[0]>minMax){
                    minMax=size[0];
                }
            }
        }
        return maxMax*minMax;
    }
}

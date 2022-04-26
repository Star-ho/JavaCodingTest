package programmers.previous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 정수삼각형 {
    public static void main(String[] arg){
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5} } ) );
    }

    public static int solution(int[][] triangle) {
        int answer=0;

        for(int i=1;i<triangle.length;i++){
            loop:for(int j=0;j<triangle[i].length;j++){
                if(j==0)triangle[i][j]=triangle[i][j]+triangle[i-1][0];
                else if(j>0&&j<triangle[i].length-1)triangle[i][j]=triangle[i][j]+Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                else triangle[i][j]=triangle[i][j]+triangle[i-1][j-1];
            }
        }
        for(int i:triangle[triangle.length-1]){
            answer=Math.max(answer,i);
        }
        return answer;
    }
}

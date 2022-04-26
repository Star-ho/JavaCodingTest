package programmers.previous;

import java.util.Arrays;

public class 방의갯수 {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}));
    }

    public static int solution(int[] arrows) {
        int answer = 0;
        int[][] matrix=new int[arrows.length+2][arrows.length+2];
        int x=(arrows.length+2)/2;
        int y=(arrows.length+2)/2;
        matrix[x][y]=1;
        boolean flag=true;
        for(int arrow:arrows){
            if(arrow==0){    y--;  }else if(arrow==1){  x++;y--;
            }else if(arrow==2){  x++;  }else if(arrow==3){  x++;y++;
            }else if(arrow==4){  y++; }else if(arrow==5){   x--;y++;
            }else if(arrow==6){  x--; }else if(arrow==7){   x--;y--;  }
            if(matrix[x][y]==1) {
                if (flag){
                    answer++;
                }
                flag=false;
            }else {
                flag=true;
            }
            matrix[x][y]=1;
        }
        return answer;
    }
}

package programmers.level2;

import java.util.*;

public class 카카오프렌즈_컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] newPic = new int[m][n];
        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length;j++){
                newPic[i][j]=picture[i][j];
            }
        }


        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length;j++){
                if(newPic[i][j]!=0){
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,findNum(i,j,newPic));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int findNum(int x, int y, int[][] picture){
        int res=0;
        final int color=picture[x][y];

        Deque<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});

        while(queue.size()>0){

            int[] cur = queue.removeFirst();

            if(picture[cur[0]][cur[1]]!=color)continue;

            picture[cur[0]][cur[1]] = 0;

            res++;

            if(cur[0]>0){
                queue.add(new int[]{cur[0]-1, cur[1]});
            }

            if(cur[0]<picture.length-1){
                queue.add(new int[]{cur[0]+1, cur[1]});
            }

            if(cur[1]>0){
                queue.add(new int[]{cur[0], cur[1]-1});
            }

            if(cur[1]<picture[0].length-1){
                queue.add(new int[]{cur[0], cur[1]+1});
            }

        }
        return res;
    }
}

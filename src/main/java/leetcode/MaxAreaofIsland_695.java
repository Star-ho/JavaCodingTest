package leetcode;

import java.util.*;

public class MaxAreaofIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,findIsland(grid,i,j));
                }
            }
        }
        return max;
    }

    public int findIsland(int[][] grid, int x, int y){
        Deque<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        int val=0;
        while(queue.size()>0){
            int[] cur=queue.removeFirst();

            if(grid[cur[0]][cur[1]]!=1){
                continue;
            }
            val++;
            grid[cur[0]][cur[1]]=0;
            if(cur[0]>0&&grid[cur[0]-1][cur[1]]==1){
                queue.add(new int[]{cur[0]-1,cur[1]});
            }
            if(cur[0]<grid.length-1&&grid[cur[0]+1][cur[1]]==1){
                queue.add(new int[]{cur[0]+1,cur[1]});
            }
            if(cur[1]>0&&grid[cur[0]][cur[1]-1] == 1){
                queue.add(new int[]{cur[0],cur[1]-1});
            }
            if(cur[1]<grid[0].length-1&&grid[cur[0]][cur[1]+1] == 1){
                queue.add(new int[]{cur[0],cur[1]+1});
            }
        }
        return val;
    }
}

package forLineCodingTest;

import java.util.*;

public class NumberOfIslands_200 {
    public static void main(String[] arg){
        System.out.println(
                numIslands(new char[][]{
                    {'1','1','1','1','0'},
                    {'1','1','0','1','0'},
                    {'1','1','0','0','0'},
                    {'0','0','0','0','0'}
            }));
        System.out.println(
                numIslands(new char[][]{
                        {'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'1','0','1','0','0'},
                          {'1','0','0','1','1'}
                }));
    }

    public static int numIslands(char[][] grid) {
        int answer=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    answer++;
                    checkIsland(grid,i,j);
                }
            }
        }
    return answer;
    }

    public static void checkIsland(char[][] grid,int x,int y){
        Deque<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});

        while(queue.size()>0){
            int[] cur=queue.removeFirst();
            if(cur[0]>0&&grid[cur[0]-1][cur[1]]=='1'){
                grid[cur[0]-1][cur[1]]='0';
                queue.addLast(new int[]{cur[0]-1,cur[1]});
            }
            if(cur[1]>0&&grid[cur[0]][cur[1]-1]=='1'){
                grid[cur[0]][cur[1]-1]='0';
                queue.addLast(new int[]{cur[0],cur[1]-1});
            }
            if(cur[0]<grid.length-1&&grid[cur[0]+1][cur[1]]=='1'){
                grid[cur[0]+1][cur[1]]='0';
                queue.addLast(new int[]{cur[0]+1,cur[1]});
            }

            if(cur[1]<grid[0].length-1&&grid[cur[0]][cur[1]+1]=='1'){
                grid[cur[0]][cur[1]+1]='0';
                queue.addLast(new int[]{cur[0],cur[1]+1});
            }
        }
    }

}

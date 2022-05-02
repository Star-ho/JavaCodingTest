package programmers.level2;

import java.util.*;

public class 프렌즈4블록_1차 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] blocks = new char[m][];
        for(int i=0;i<board.length;i++){
            blocks[i]=board[i].toCharArray();
        }

        Deque<int[]> deleteQueue = new LinkedList<>();

        do{
            while(deleteQueue.size()>0){
                int[] cur=deleteQueue.removeFirst();
                if(blocks[cur[0]][cur[1]]!='@'){
                    blocks[cur[0]][cur[1]]='@';
                    answer++;
                }

            }
            // for(var block : blocks)System.out.println(Arrays.toString(block));
            // System.out.println();
            reArrageBlock(blocks);
            // for(var block : blocks)System.out.println(Arrays.toString(block));
            // System.out.println();
            deleteQueue=getDeleteBlock(blocks);
        }while(deleteQueue.size()>0);

        return answer;
    }

    private void reArrageBlock(char[][] block){
        for(int i=block.length-1;i>0;i--){
            for(int j=0;j<block[0].length;j++){
                if(block[i][j]=='@'){
                    char temp = '@';
                    int cnt = 1;
                    while(temp=='@'&&i-cnt>=0){
                        temp = block[i-cnt][j];
                        block[i-cnt][j]='@';
                        cnt++;
                    }
                    block[i][j]=temp;
                }
            }
        }
    }


    private Deque<int[]> getDeleteBlock(char[][] block){
        Deque<int[]> deleteQueue = new LinkedList<>();
        for(int i=0;i<block.length-1;i++){
            for(int j=0;j<block[0].length-1;j++){
                if(block[i][j]!='@'
                        &&block[i][j]==block[i+1][j]
                        &&block[i][j]==block[i+1][j]
                        &&block[i][j]==block[i][j+1]
                        &&block[i][j]==block[i+1][j+1]){
                    deleteQueue.add(new int[]{i,j});
                    deleteQueue.add(new int[]{i+1,j});
                    deleteQueue.add(new int[]{i,j+1});
                    deleteQueue.add(new int[]{i+1,j+1});
                }
            }
        }
        return deleteQueue;
    }
}

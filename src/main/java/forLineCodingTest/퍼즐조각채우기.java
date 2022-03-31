package forLineCodingTest;

import java.util.*;

public class 퍼즐조각채우기 {
    public static void main(String[] arg){
        System.out.println(solution(new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}})+" 14");
//        System.out.println(solution(new int[][]{{0,0,0},{1,1,0},{1,1,1}},new int[][]{{1,1,1},{1,0,0},{0,0,0}})+" 0");
    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int i=0;
        List<List<int[]>> blockList=getBlocks(table);
        System.out.println(blockList.size());
        for(List<int[]> block:blockList){
            if(checkBlock(block,game_board)){
                System.out.println(i++);
                answer++;
            }
        }
        System.out.println();
        for(int[] b:game_board) {
            System.out.println(Arrays.toString(b));
        }
        return answer;
    }
    private static boolean checkBlock(List<int[]> block,int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==0){
                    if(isMatch(block,board,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMatch(List<int[]> block, int[][] board, int x, int y){
        outter:for(int i=0;i<4;i++){
            List<int[]> tempBlock=new ArrayList<>();
            int maxRow=0;
            int maxCol=0;
            for(int[] b:block) {
                maxRow = Math.max(b[0], maxRow);
                maxCol= Math.max(b[1],maxCol);
            }
            for(int[] b:block)tempBlock.add(new int[]{maxCol-b[1],maxRow-b[0]});
            for(int[] b:block) System.out.println(Arrays.toString(b));
            System.out.println();
            for(int[] b:tempBlock) System.out.println(Arrays.toString(b));
            System.out.println();
            System.out.println();
            block=tempBlock;

            int[][] tempBoard=new int[board.length][board.length];
            for(int j=0;j<board.length;j++)tempBoard[j]=Arrays.copyOf(board[j],board[j].length);

            for(int[] pos:block){
                if(pos[0]+x>tempBoard.length-1||pos[1]+y> tempBoard.length-1)continue outter;
                if(tempBoard[pos[0]+x][pos[1]+y]!=0)continue outter;
                tempBoard[pos[0]+x][pos[1]+y]=1;
            }

            if(ifFill( block, tempBoard, x, y)) {
                for(int j=0;j<board.length;j++){
                    board[j]=tempBoard[j];
                }
                for(int[] b:tempBoard) {
                    System.out.println(Arrays.toString(b));
                }
                System.out.println();
                return true;
            };

        }
        return false;
    }

    private static boolean ifFill(List<int[]> block, int[][] board, int x, int y){
        for(int[] pos:block){
            if(pos[0]+x>board.length-1||pos[1]+y> board.length-1)continue;
            if(pos[0]+x > 0&&board[pos[0]+x-1][pos[1]+y]==0)return false;
            if(pos[0]+x < board.length-1&&board[pos[0]+x+1][pos[1]+y]==0)return false;
            if(pos[1]+y > 0&&board[pos[0]+x][pos[1]+y-1]==0)return false;
            if(pos[1]+y < board[0].length-1&&board[pos[0]+x][pos[1]+y+1]==0)return false;
        }
        return true;
    }

    private static List<List<int[]>> getBlocks(int[][] table){
        List<List<int[]>> blockList=new ArrayList<>();

        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                if(table[i][j]==1){
                    List<int[]> block=parseBlock(i,j,table);
                    blockList.add(block);

                }
                if(blockList.size()>5){
                    return blockList;
                }
            }
        }
        return blockList;
    }

    private static List<int[]> parseBlock(int x, int y, int[][] table){
        List<int[]> locList=new ArrayList<>();
        Deque<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        while (queue.size()>0){
            int[] cur=queue.removeFirst();
            table[cur[0]][cur[1]]=0;
            locList.add(cur);
            if(cur[0]>0&&table[cur[0]-1][cur[1]]==1){
                queue.addLast(new int[]{cur[0]-1,cur[1]});
            }
            if(cur[0]<table.length-1&&table[cur[0]+1][cur[1]]==1){
                queue.addLast(new int[]{cur[0]+1,cur[1]});
            }
            if(cur[1]>0&&table[cur[0]][cur[1]-1]==1){
                queue.addLast(new int[]{cur[0],cur[1]-1});
            }
            if(cur[1]<table[0].length-1 && table[cur[0]][cur[1]+1]==1){
                queue.addLast(new int[]{cur[0],cur[1]+1});
            }
        }
        List<int[]> resList=new ArrayList<>();
        int[] min=new int[]{50,50};
        for(int[] loc:locList){
            min[0]=Math.min(loc[0],min[1]);
            min[1]=Math.min(loc[1],min[1]);
        }
        for(int[] loc:locList){
            resList.add(new int[]{loc[0]-min[0],loc[1]-min[1]});
        }
        return resList;
    }

}

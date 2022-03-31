package forLineCodingTest;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 아이템줍기 {
    public static void main(String[] arg){
        System.out.println(solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8)+" 17");
        System.out.println(solution(new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},9,7,6,1)+" 11");
        System.out.println(solution(new int[][]{{1,1,5,7}},1,1,4,7)+" 9");
        System.out.println(solution(new int[][]{{2,1,7,5},{6,4,10,10}},3,1,7,10)+" 15");
        System.out.println(solution(new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}},1,4,6,3)+" 10");
    }
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        int[][] graph=new int[102][102];
        for(int[] rect:rectangle){
            for(int i=rect[1]*2;i<=rect[3]*2;i++){
                for(int j=rect[0]*2;j<=rect[2]*2;j++){
                    graph[i][j]=1;
                }
            }
        }
//        for(int[] g : graph) System.out.println(Arrays.toString(g));
//        System.out.println( );
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(graph[i][j]==1){
                    if((graph[i+1][j]==1||graph[i+1][j]==3)
                            &&(graph[i-1][j]==1||graph[i-1][j]==3)
                            &&(graph[i][j+1]==1||graph[i][j+1]==3)
                            &&(graph[i][j-1]==1||graph[i][j-1]==3)
                            &&(graph[i-1][j+1]==1||graph[i-1][j+1]==3)
                            &&(graph[i+1][j-1]==1||graph[i+1][j-1]==3)
                            &&(graph[i+1][j+1]==1||graph[i+1][j+1]==3)
                            &&(graph[i-1][j-1]==1||graph[i-1][j-1]==3)){
                        graph[i][j]=3;
                    }
                }
            }
        }
//        for(int[] g : graph) System.out.println(Arrays.toString(g));
        CharaterPos cp=new CharaterPos(characterY*2,characterX*2,0,false);
        if(cantGo(cp.y,cp.x,graph)){
            cp.b=true;
        }
//        System.out.println();
        Deque<CharaterPos> queue=new LinkedList<>();
        queue.addFirst(cp);
        while(queue.size()>0){
            CharaterPos cur=queue.removeLast();
//            System.out.println(cur.y+" "+cur.x+" "+cur.n);

            if (cur.y ==itemY*2&&cur.x ==itemX*2) {
//                System.out.println(cur.n);
                answer = Math.min(answer, cur.n);
                continue;
            }
            graph[cur.y][cur.x]=2;
            if(graph[cur.y +1][cur.x]==1) {
                if(cantGo(cur.y +1,cur.x,graph)){
                    if(!cur.b){
                        queue.addLast(new CharaterPos(cur.y + 1, cur.x, cur.n + 1,true));
                    }
                }else {
                    queue.addLast(new CharaterPos(cur.y + 1, cur.x, cur.n + 1,false));
                }
            }
            if(graph[cur.y -1][cur.x]==1){
                if(cantGo(cur.y -1,cur.x,graph)){
                    if(!cur.b){
                        queue.addLast(new CharaterPos(cur.y - 1, cur.x, cur.n + 1,true));
                    }
                }else {
                    queue.addLast(new CharaterPos(cur.y -1, cur.x,cur.n+1,false));
                }
            }
            if(graph[cur.y][cur.x -1]==1){
                if(cantGo(cur.y,cur.x -1,graph)){
                    if(!cur.b){
                        queue.addLast(new CharaterPos(cur.y, cur.x - 1, cur.n + 1,true));
                    }
                }else {
                    queue.addLast(new CharaterPos(cur.y,cur.x - 1,cur.n+1,false));
                }
            }
            if(graph[cur.y][cur.x +1]==1){
                if(cantGo(cur.y,cur.x +1,graph)){
                    if(!cur.b){
                        queue.addLast(new CharaterPos(cur.y, cur.x + 1, cur.n + 1,true));
                    }
                }else {
                    queue.addLast(new CharaterPos(cur.y,cur.x + 1,cur.n+1,false));
                }
            }
        }

//        for(int[] g : graph) System.out.println(Arrays.toString(g));

        return answer/2;
    }
    private static boolean cantGo(int x, int y, int[][] graph){
        int check=0;
        if(graph[x + 1][y] != 0)check++;
        if(graph[x - 1][y] != 0)check++;
        if(graph[x][y - 1] != 0)check++;
        if(graph[x][y + 1] != 0)check++;

        if (check==4){
            return true;
        }
        return false;
    }
    static class CharaterPos{
        int y;
        int x;
        int n;
        boolean b;
        public CharaterPos(int y, int x, int n, boolean b){
            this.n=n;
            this.y = y;
            this.x = x;
            this.b=b;
        }
    }
}

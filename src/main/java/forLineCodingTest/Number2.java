package forLineCodingTest;

import java.util.Arrays;

//42분
public class Number2 {
    public static void main(String[] arg){
//        System.out.println(solution(9,true));
        System.out.println(solution(5,false));
    }

    public static int[][] solution(int n, boolean clockwise) {
        int[][] graph=new int[n][n];
        int i=0;

        if(clockwise){
            drawGraphClockWise(new int[]{0,0},graph,1,clockwise);
            drawGraphClockWise(new int[]{0,graph.length-1},graph,2,clockwise);
            drawGraphClockWise(new int[]{graph.length-1,0},graph,4,clockwise);
            drawGraphClockWise(new int[]{graph.length-1,graph.length-1},graph,3,clockwise);
        }else{
            drawGraphClockWise(new int[]{0,0},graph,1,clockwise);
            drawGraphClockWise(new int[]{0,graph.length-1},graph,4,clockwise);
            drawGraphClockWise(new int[]{graph.length-1,0},graph,2,clockwise);
            drawGraphClockWise(new int[]{graph.length-1,graph.length-1},graph,3,clockwise);
        }
        return graph;
    }
    private static void drawGraphClockWise(int[] start, int[][] graph, int flag,boolean clockWise){
        int curLen=graph.length-1;
        int endNum=(int)Math.ceil(graph.length*graph.length/4.0);
        int curNum=1;
        int[] curPos= {start[0], start[1]};
        int addNum=graph.length-3;
        while(curNum<=endNum){
            for(int[] g:graph){
                System.out.println(Arrays.toString(g));
            }
            System.out.println(curNum+" "+curLen+" "+flag);
            System.out.println();
            graph[curPos[0]][curPos[1]]=curNum++;
            if(clockWise){
                switch (flag){
                    case 1:curPos[1]++;break;
                    case 2:curPos[0]++;break;
                    case 3:curPos[1]--;break;
                    case 4:curPos[0]--;break;
                }
            }else {
                switch (flag){
                    case 1:curPos[0]++;break;
                    case 2:curPos[1]++;break;
                    case 3:curPos[0]--;break;
                    case 4:curPos[1]--;break;
                }
            }
            if(curNum==curLen){
                curLen+=addNum;
                addNum-=2;
                if(flag==1)flag=2;
                else if(flag==2)flag=3;
                else if(flag==3)flag=4;
                else if(flag==4)flag=1;
            }
        }
    }

}

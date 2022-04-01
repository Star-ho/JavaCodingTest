package leetcode;

import java.util.*;

public class MinimumSidewayJumps_1824_DFS_Fail {
    public int minSideJumps(int[] obstacles) {
        int[][] checkArr=new int[obstacles.length][];
        Arrays.fill(checkArr,new int[]{obstacles.length,0,0,0});
        int res=obstacles.length;

        Deque<LocJump> queue=new LinkedList<>();
        queue.add(new LocJump(0,2,0));
        while(queue.size()>0){
            LocJump locj=queue.removeFirst();
            if(locj.cur==obstacles.length-1){
                res=Math.min(res,locj.jump);
                continue;
            }
            if(checkArr[locj.cur][0]>locj.jump){
                checkArr[locj.cur]=new int[]{locj.jump,0,0,0};
            }else if(checkArr[locj.cur][0]==locj.jump){
                if(checkArr[locj.cur][locj.lane]!=0){
                    continue;
                }
            }else{ continue; }
            checkArr[locj.cur][locj.lane]=1;

            if(obstacles[locj.cur+1]==locj.lane){
                if(locj.lane!=1&&obstacles[locj.cur]!=1){
                    queue.add(new LocJump(locj.cur+1,1,locj.jump+1));
                }
                if(locj.lane!=2&&obstacles[locj.cur]!=2){
                    queue.add(new LocJump(locj.cur+1,2,locj.jump+1));
                }
                if(locj.lane!=3&&obstacles[locj.cur]!=3){
                    queue.add(new LocJump(locj.cur+1,3,locj.jump+1));
                }
            }else{
                queue.add(new LocJump(locj.cur+1,locj.lane,locj.jump));
            }
        }
        return res;
    }
    class LocJump{
        int cur;
        int lane;
        int jump;
        public LocJump(int cur,int lane, int jump){
            this.cur=cur;
            this.lane=lane;
            this.jump=jump;
        }
    }
}

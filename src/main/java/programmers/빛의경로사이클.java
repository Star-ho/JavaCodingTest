package programmers;

import java.util.*;

//2시간 4분;;
// 중간에 에러 잡는데,
// 방향 잡는데
// ** 모든 노드에서 4방향으로 쏘는걸 생각 못함 ㅠㅠ
public class 빛의경로사이클 {
    public int[] solution(String[] grid) {
        List<Integer> answer=new ArrayList<>();
        char[][] grids=new char[grid.length][];
        for(int i=0;i<grid.length;i++){
            grids[i]=grid[i].toCharArray();
        }

        List<String> routeList=new ArrayList<>();
        //1:오른쪽 2:왼쪽 3:아래 4:위
        for(int i=0;i<grids.length;i++){
            for(int j=0;j<grids[0].length;j++){
                routeList.add(i+" "+j+" 1");
                routeList.add(i+" "+j+" 2");
                routeList.add(i+" "+j+" 3");
                routeList.add(i+" "+j+" 4");
            }
        }

        Map<String,Boolean> visited=new HashMap<>();

        for(String route:routeList){
            //1:오른쪽 2:왼쪽 3:아래 4:위
            String[] routeChar=route.split(" ");

            int[] cur={Integer.parseInt(routeChar[0]),Integer.parseInt(routeChar[1]),
                    Integer.parseInt(routeChar[2])};

            int len=0;
            if(visited.containsKey(makeId(cur)))continue;
            while(!visited.containsKey(makeId(cur))){

                visited.put(makeId(cur),true);

                if(grids[cur[0]][cur[1]]=='S'){ sRouting(cur,grids);   }
                else if(grids[cur[0]][cur[1]]=='L'){ lRouting(cur,grids);  }
                else if(grids[cur[0]][cur[1]]=='R'){ rRouting(cur,grids); }
                len++;
                // System.out.println(Arrays.toString(cur));
            }
            // System.out.println();
            answer.add(len);
        }

        int[] temp=answer.stream().mapToInt(i->i).toArray();
        Arrays.sort(temp);

        return temp;
    }

    public String makeId(int[] cur){
        return ""+cur[0]+" "+cur[1]+" "+cur[2];
    }
    public void sRouting(int[] cur,char[][] grids){
        //1:오른쪽 2:왼쪽 3:아래 4:위
        if(cur[2]==1){  goRight(cur,grids);  }
        else if(cur[2]==2){  goLeft(cur,grids);   }
        else if(cur[2]==3){  goDown(cur,grids);  }
        else if(cur[2]==4){  goUp(cur,grids);    }
    }

    public void rRouting(int[] cur,char[][] grids){
        //1:오른쪽 2:왼쪽 3:아래 4:위
        if(cur[2]==1){ cur[2]=3;  goDown(cur,grids);   }
        else if(cur[2]==2){ cur[2]=4;  goUp(cur,grids);    }
        else if(cur[2]==3){ cur[2]=2;  goLeft(cur,grids);  }
        else if(cur[2]==4){ cur[2]=1;  goRight(cur,grids);    }
    }

    public void lRouting(int[] cur,char[][] grids){
        //1:오른쪽 2:왼쪽 3:아래 4:위
        if(cur[2]==1){  cur[2]=4;  goUp(cur,grids);   }
        else if(cur[2]==2){  cur[2]=3;  goDown(cur,grids);    }
        else if(cur[2]==3){  cur[2]=1;  goRight(cur,grids);  }
        else if(cur[2]==4){  cur[2]=2;  goLeft(cur,grids);    }
    }

    private void goRight(int[] cur,char[][] grids){
        if(cur[1]<grids[0].length-1){ cur[1]++; }
        else{  cur[1]=0; }
    }
    private void goLeft(int[] cur,char[][] grids){
        if(cur[1]>0){ cur[1]--; }
        else{  cur[1]=grids[0].length-1; }
    }
    private void goDown(int[] cur,char[][] grids){
        if(cur[0]<grids.length-1){ cur[0]++; }
        else{  cur[0]=0; }
    }
    private void goUp(int[] cur,char[][] grids){
        if(cur[0]>0){ cur[0]--; }
        else{ cur[0]=grids.length-1; }
    }
}

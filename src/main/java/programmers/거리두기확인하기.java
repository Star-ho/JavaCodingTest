package programmers;

import java.util.Arrays;

//23분
public class 거리두기확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer,1);
        loop: for(int k=0;k<places.length;k++){
            char[][] place=new char[5][5];
            for(int j=0;j<places[k].length;j++){
                place[j]=places[k][j].toCharArray();
            }
            for(int i=0;i<place.length;i++){
                for(int j=0;j<place.length;j++){
                    if(place[i][j]=='P'){
                        if(existPeople(i,j,place)){
                            // System.out.println(i+" "+j);
                            answer[k]=0;
                            continue loop;
                        }
                    }
                }
            }

        }
        return answer;
    }

    private boolean existPeople(int i,int j, char[][] place){
        if(i<4&&place[i+1][j]=='P')return true;
        if(i<3&&place[i+1][j]!='X'&&place[i+2][j]=='P')return true;
        if(i<4&&j<4&&place[i+1][j+1]=='P'){
            if(place[i+1][j]!='X'||place[i][j+1]!='X'){
                // System.out.println("ff");
                return true;
            }
        }
        if(j<4&&place[i][j+1]=='P')return true;
        if(j<3&&place[i][j+1]!='X'&&place[i][j+2]=='P')return true;
        if(i>0&&j<4&&place[i-1][j+1]=='P'){
            return place[i - 1][j] != 'X' || place[i][j + 1] != 'X';
        }
        return false;
    }
}

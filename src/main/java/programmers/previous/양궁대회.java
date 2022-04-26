package programmers.previous;

import java.util.Arrays;

public class 양궁대회 {

    int max=0;
    int[] answer = {-1};
    public int[] solution(int n, int[] info) {

        DFS(info,new int[11],0,n);

        if(max==0)return new int[]{-1};
        return answer;
    }

    private void DFS( int[] apeach, int[] lion, int curIndex,int curArrow){
        int score=getScoreSub(apeach,lion);

        if(curArrow==0){
            if(score>max){
                max=score;
                answer=lion;
            }else if(score==max&&max>0){
                for(int i=lion.length-1;i>=0;i--){
                    if(lion[i]==answer[i])continue;
                    if (lion[i] > answer[i]) {
                        max = score;
                        answer = lion;
                        break;
                    }
                    break;
                }
            }
            return ;
        }

        for(int i=curIndex;i<lion.length;i++){
            if(score<max){
                if(apeach[i]>curArrow+1){
                    continue;
                }
                int j=0;
                while(j<curArrow-apeach[i]){
                    int[] temp= Arrays.copyOf(lion,lion.length);
                    temp[i]=apeach[i]+1+j;
                    DFS(apeach,temp,i+1,curArrow-apeach[i]-1-j);
                    j++;
                }
            }else{
                int j=1;
                while(j<=curArrow){
                    int[] temp=Arrays.copyOf(lion,lion.length);
                    temp[i]=j;
                    DFS(apeach,temp,i+1,curArrow-j);
                    j++;
                }
            }
        }

    }

    private int getScoreSub(int[] apeach,int[] lion){
        int lionScore=0;
        int apeachScore=0;
        for(int i=0;i<apeach.length;i++){
            if(apeach[i]==0&&lion[i]==0)continue;
            if(apeach[i]<lion[i]){
                lionScore+=(10-i);
            }else{
                apeachScore+=(10-i);
            }
        }
        return lionScore-apeachScore;
    }
}

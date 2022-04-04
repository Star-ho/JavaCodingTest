package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        Deque<Integer> numDeque=new LinkedList<>();
        int max=num;
        while(num>0){
            numDeque.addFirst(num%10);
            num=num/10;
        }
        List<Integer> numList=new ArrayList<>(numDeque);

        int len=numList.size();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int temp=0;
                for(int k=0;k<len;k++){
                    if(k==i){
                        temp=temp*10+numList.get(j);
                    }else if(k==j){
                        temp=temp*10+numList.get(i);
                    }else{
                        temp=temp*10+numList.get(k);
                    }
                }
                // System.out.println(i+" "+j+" "+temp+" "+max);
                max=Math.max(max,temp);
            }
        }
        return max;
    }
}

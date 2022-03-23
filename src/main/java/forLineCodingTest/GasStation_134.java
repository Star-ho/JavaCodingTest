package forLineCodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GasStation_134 {
    public static void main(String[] arg){
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
        System.out.println(canCompleteCircuit(new int[]{3,3,4},new int[]{3,4,4}));
        System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4},new int[]{4,4,1,5,1}));
   }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int maxGarrent=0;
        List<Integer> indexList=new ArrayList<>();
        for(int i=0;i<gas.length;i++){
            if(gas[i]-cost[i]>=maxGarrent){
                indexList.add(i);
                maxGarrent=cost[i]-gas[i];
            }
        }

        for(int index:indexList){
            int cur=index;
            int curGas=gas[index];

            do{
                if(cur==gas.length-1){
                    cur=0;
                }else{
                    cur++;
                }
                curGas=curGas-cost[cur]+gas[cur];
                if(curGas<0)break;
            }while(cur!=index);
            if(cur==gas.length-1){
                cur=0;
            }else{
                cur++;
            }
            curGas=curGas-cost[cur];
            if(curGas<0)break;

            if(cur==index+1)return index;
        }

        return -1;
    }
}

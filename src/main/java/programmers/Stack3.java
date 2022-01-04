package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stack3 {
    public static void main(String[] arg){
        System.out.println(solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> listTruck= (ArrayList<Integer>)Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
        ArrayList<int[]> listBrige=new ArrayList<>();
        int time=0;
        for(;listTruck.size()>0||listBrige.size()>0;time++){

            if(listBrige.size()>0&&time-listBrige.get(0)[1]>=bridge_length){
                listBrige.remove(0);
            }

            if(listTruck.size()>0&&sum(listBrige,listTruck.get(0))<=weight&&listBrige.size()<=bridge_length){
                listBrige.add(new int[]{listTruck.get(0),time});
                listTruck.remove(0);
            }

        }

        return time;
    }
    public static int sum(ArrayList<int[]> trucks,int a){
        if(trucks.size()==0){
            return 0;
        }
        int sum=0;
        for(var i : trucks){
            sum+=i[0];
        }
        sum+=a;
        return sum;
    }
}

package programmers;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer,List<Integer>> recordMap=new HashMap<>();
        for(String record:records){
            String[] info=record.split(" ");
            String[] timeString=info[0].split(":");
            int time=Integer.parseInt(timeString[0])*60+Integer.parseInt(timeString[1]);
            int carNum=Integer.parseInt(info[1]);
            if(!recordMap.containsKey(carNum)){
                recordMap.put(carNum,new ArrayList<>());
            }
            recordMap.get(carNum).add(time);
        }

        List<int[]> carFeeList=new ArrayList<>();

        for(int key : recordMap.keySet()){
            List<Integer> times=recordMap.get(key);
            int timesLen=times.size();
            if(timesLen%2!=0){
                times.add(1439);
                timesLen++;
            }
            int time=0;
            for(int i=0;i<timesLen;i+=2){
                time+=times.get(i+1)-times.get(i);
            }
            int fee=0;

            if(time<=fees[0])fee+=fees[1];
            else{fee+=fees[1]+(int)Math.ceil((time-fees[0])/(fees[2]*1.0))*fees[3];}
            carFeeList.add(new int[]{key,fee});

        }

        carFeeList.sort(Comparator.comparingInt(a -> a[0]));

        for (int[] ints : carFeeList) {
            answer.add(ints[1]);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}

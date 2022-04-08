package programmers;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String,String> nickName=new HashMap<>();
        List<String[]> resList=new ArrayList<>();
        for(int i=0;i<record.length;i++){
            String[] splited=record[i].split(" ");
            if(!splited[0].equals("Change")){
                resList.add(new String[]{splited[0],splited[1]});
            }
            if(!splited[0].equals("Leave")){
                nickName.put(splited[1],splited[2]);
            }
        }

        for(String[] res:resList){
            if(res[0].equals("Enter")){
                answer.add(nickName.get(res[1])+"님이 들어왔습니다.");
            }else{
                answer.add(nickName.get(res[1])+"님이 나갔습니다.");
            }
        }

        return answer.toArray(String[]::new);
    }
}

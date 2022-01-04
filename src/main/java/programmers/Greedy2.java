package programmers;

import java.util.*;

public class Greedy2 {
    public static void main(String[] arg){
        System.out.println(solution("JAZ"));
    }

    public static int solution(String name) {
        int answer = 0;
        List<String> charList= Arrays.asList(name.split(""));
        for(String s : charList) {
            int resAZ=AtoZ(s);
            int resZA=ZtoA(s);
            if(resAZ>resZA){
                answer+=resZA;
            }else {
                answer+=resAZ;
            }
        }
        boolean flag=true;
        for(int i=0;i<charList.size();i++){
            int countA=0;
            int j=i+1;
            if(j<charList.size()&&charList.get(j).equals("A")){
                loop : for(;j<charList.size();j++){
                    if(charList.get(j).equals("A")){
                        countA++;
                    }else{
                        break loop;
                    }

                }
            }
            if(i<countA){
                flag=false;
                answer+=i*2+1+charList.size()-j-1;
//                System.out.println(i*2+1+charList.size()-j-1);
                break;
            }
        }
        if(flag){
            answer+=charList.size()-1;
        }
        return answer;
    }

    private static int AtoZ(String str){
        int res=0;
        List<String> alphabetList=Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        for(String alphabet:alphabetList){
            if(alphabet.equals(str)) {
                break;
            }
            res++;
        }
        return res;
    }
    private static int ZtoA(String str){
        int res=1;
        List<String> alphabetList=Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        Collections.reverse(alphabetList);
        for(String alphabet:alphabetList){
            if(alphabet.equals(str)){
                break;
            }
            res++;
        }
        return res;
    }

}

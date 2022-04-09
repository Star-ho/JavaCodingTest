package programmers;

import java.util.*;

public class 괄호변환 {
    public String solution(String p) {
        List<Character> charList=new ArrayList<>();

        for(char c : p.toCharArray()){
            charList.add(c);
        }

        List<Character> answerList = recursive(charList);

        StringBuilder answer= new StringBuilder();
        for(char a:answerList){
            answer.append(a);
        }
        return answer.toString();
    }

    private List<Character> recursive(List<Character> curList){
        if(curList.size()==0)return new ArrayList<>();

        boolean isGood=true;

        int cnt=0;
        int i=0;
        int curLen=curList.size();
        List<Character> resList=new ArrayList<>();

        while(i<curLen){
            if(curList.get(i)=='('){ cnt++; }
            else{ cnt--; }
            if(cnt<0)isGood=false;
            if(cnt==0)break;
            i++;
        }


        List<Character> front=curList.subList(0,i+1);
        List<Character> end=new ArrayList<>();
        if(i!=curLen){
            end.addAll(curList.subList(i+1,curLen));
        }

        if(isGood){
            resList.addAll(front);
            resList.addAll(recursive(end));
        }else{
            resList.add('(');
            resList.addAll(recursive(end));
            resList.add(')');
            resList.addAll(reverse(front));
        }
        return resList;
    }

    private List<Character> reverse(List<Character> curlist){
        List<Character> reverseList=new ArrayList();
        int curLen=curlist.size();

        for(int i=1;i<curLen-1;i++){
            if(curlist.get(i)=='(') reverseList.add(')');
            else reverseList.add('(');
        }

        return reverseList;
    }
}

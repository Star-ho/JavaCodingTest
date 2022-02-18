package codility.stackAndQueue;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Nesting {
    public int solution(String S) {
        Stack<Character> charStack=new Stack<>();
        char[] cArr=S.toCharArray();

        for(char in:cArr){
            if(charStack.size()>0){
                char last=charStack.peek();
                if(last=='('&&in==')'){
                    charStack.pop();
                }else{
                    charStack.push(in);
                }
            }else{
                charStack.push(in);
            }
        }
        if(charStack.size()==0){
            return 1;
        }
        return 0;
    }
}
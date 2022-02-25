package codility.stackAndQueues;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Brackets {
    public int solution(String S) {
        char[] charArr=S.toCharArray();
        Stack<Character> bracketStack=new Stack<>();
        for(char c:charArr){
            // System.out.println(bracketStack);
            char in=c;
            if(bracketStack.size()>=1){
                char peek=bracketStack.peek();
                if(peek=='('&&in==')'){
                    bracketStack.pop();
                }else if(peek=='{'&&in=='}'){
                    bracketStack.pop();
                }else if(peek=='['&&in==']'){
                    bracketStack.pop();
                }else{
                    bracketStack.push(in);
                }
            }else{
                bracketStack.push(in);
            }
        }

        if(bracketStack.size()==0){
            return 1;
        }
        return 0;
    }
}
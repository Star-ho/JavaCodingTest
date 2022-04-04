package devMatching;

import java.util.regex.Pattern;

public class regexTest {
    public static void main(String[] arg){
        String[] str = {"aa : sdf bb : fgdf cc : agdsf",
                "aa12 : sdf bb : fgdf cc : agdsf",
                "aa : sdf bb44 : fgdf cc : agdsf",
                "aa : sdf bb : fgdf cc55 : agdsf",
                "aa : s123df bb : fgdf cc : agdsf",
                "aa : sdf bb : fg55df cc : agds44f",
                "aa :sdf bb :fgdf cc : agdsf",
                "aa : sdf bb : fgdfcc : agdsf",
                "aa : sdAf bb : fgdf cc : agdsf",
                "aa : sdf bb : fgdf c : agdsf"};
        Pattern pattern=Pattern.compile("(aa) : [A-z]* (bb) : [A-z]* cc : [A-z]*");
        int res=0;
        for(String s:str){
            if(pattern.matcher(s).matches()){
                System.out.println(s);
            }
        }

    }
}

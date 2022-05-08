package programmers.level2;

import java.util.Arrays;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skillArr = skill.toCharArray();
        for(String skill_tree:skill_trees){
            if(isAvailable(skillArr,skill_tree)){
                // System.out.println(skill_tree);
                answer++;
            }
        }
        return answer;
    }
    private boolean isAvailable(char[] skillArr,String skill_tree){
        char[] stArr = skill_tree.toCharArray();
        int[] skillSeq = new int[skillArr.length];
        Arrays.fill(skillSeq,-1);

        for(int i=0;i<skillArr.length;i++){
            for(int j=0;j<stArr.length;j++){
                if(skillArr[i]==stArr[j]){
                    skillSeq[i]=j;
                    if(i>0&&(skillSeq[i-1]>skillSeq[i]||skillSeq[i-1]==-1)){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}

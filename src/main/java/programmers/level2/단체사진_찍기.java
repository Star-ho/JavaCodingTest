package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 단체사진_찍기 {
    public int solution(int n, String[] data) {
        int answer = 0;
        List<String> pictures = new ArrayList<>();
        getList(pictures);

        for(int i=0;i<pictures.size();i++){
            if(check(data,pictures.get(i)))answer++;
        }

        return answer;
    }

    public boolean check(String[] d,String picture){
        int a,b,res;
        char op;
        for(String s : d){

            a = picture.indexOf(s.charAt(0));
            b = picture.indexOf(s.charAt(2));
            op = s.charAt(3);
            res = s.charAt(4)-'0' + 1;

            if(op == '='){ if(Math.abs(a-b)!=res) return false;}
            else if(op == '>'){ if(Math.abs(a-b) <= res) return false;}
            else {if(Math.abs(a-b) >= res) return false;}
        }
        return true;
    }

    private void getList(List<String> pictures){
        char[] initArr={'A','C','F','J','M','N','R','T'};
        boolean[] visited = new boolean[initArr.length];
        getList(initArr,visited,"",pictures);

    }

    private void getList(char[] arr, boolean[] visited, String cur, List<String> pictures){

        if(cur.length()==arr.length){
            pictures.add(cur);
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(visited[i]==false){
                visited[i]=true;
                getList(arr,visited,cur+arr[i],pictures);
                visited[i]=false;
            }
        }
    }
}

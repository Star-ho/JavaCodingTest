package programmers.level2;

import java.util.*;

public class 수식최대화 {
    public long solution(String expression) {
        long answer = 0;
        List<String> expressionList=getExpressionList(expression);
        String[] operater = new String[]{"+","-","*"};
        boolean[] visited = new boolean[operater.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=true;
            for(int j=0;j<visited.length;j++){
                if(visited[j])continue;
                visited[j]=true;
                for(int k=0;k<visited.length;k++){
                    if(visited[k])continue;
                    long res =calculate(new ArrayList<>(expressionList),new String[]{operater[i],operater[j],operater[k]});
                    answer=Math.max(answer,Math.abs(res));
                }
                visited[j]=false;
            }
            visited[i]=false;
        }
        return answer;
    }

    public long calculate(List<String> expression,String[] orders){
        for(String order:orders){
            for(int i=0;i<expression.size();i++){
                if(expression.get(i).equals(order)){
                    long res=0;
                    switch(order){
                        case "*":res=Long.parseLong(expression.get(i-1))*Long.parseLong(expression.get(i+1));
                            break;
                        case "+":res=Long.parseLong(expression.get(i-1))+Long.parseLong(expression.get(i+1));
                            break;
                        case "-":res=Long.parseLong(expression.get(i-1))-Long.parseLong(expression.get(i+1));
                            break;
                    }
                    expression.set(i-1,""+res);
                    expression.remove(i);
                    expression.remove(i);
                    i-=2;
                }
            }
        }
        return Long.parseLong(expression.get(0));
    }

    private List<String> getExpressionList(String expression){
        String[] number = expression.split("[-*+]");

        String[] expressArr = Arrays.stream(expression.split("[0-999]"))
                .filter( e -> !e.equals("")).toArray(String[]::new);
        List<String> expressionList = new ArrayList<>();
        for(int i=0;i<expressArr.length;i++){
            expressionList.add(number[i]);
            expressionList.add(expressArr[i]);
        }
        expressionList.add(number[number.length-1]);
        return expressionList;
    }
}

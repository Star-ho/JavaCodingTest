package programmers.previous;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0;i<arr1.length;i++){
            int[] binaryChar1= new int[n];
            int[] binaryChar2= new int[n];
            char[] temp = Integer.toString(arr1[i],2).toCharArray();
            for(int j=n-temp.length;j<n;j++){
                binaryChar1[j]=temp[j-(n-temp.length)]-'0';
            }

            temp = Integer.toString(arr2[i],2).toCharArray();
            for(int j=n-temp.length;j<n;j++){
                binaryChar2[j]=temp[j-(n-temp.length)]-'0';
            }

            String str = "";

            for(int j=0;j<n;j++){
                if(binaryChar1[j]+binaryChar2[j]>0)str+="#";
                else str+=" ";
            }

            answer[i]=str;

        }
        return answer;
    }
}

public class Java {
    public static void main(String[] arg){

        loop:for (int i=0;i<10;i++){
            for(int j=0;j<5;j++){
                if(j>i){
                    break loop;
                }
            }
            System.out.println(i);
        }
    }
}

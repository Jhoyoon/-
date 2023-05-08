package bronze;
import java.io.*;
import java.util.*;
public class B_5596_시험점수 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int min = 0;
        for(int i=0;i<4;i++){
            min = min + Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        int man = 0;
        for(int i=0;i<4;i++){
            man = man + Integer.parseInt(st.nextToken());
        }
        if(man > min){
            System.out.println(man);
        }else if(man < min){
            System.out.println(min);
        }else{
            System.out.println(min);
        }
    }
}

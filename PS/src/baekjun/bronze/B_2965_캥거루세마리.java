package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_2965_캥거루세마리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int count= 0;
        while(true){
            int first = b-a;
            int second = c-b;
            if(first > second){
                if(first == 1 && second  ==1 )break;
                c=  b;
                b = b-1;
                count++;
            }else{
                if(first == 1 && second == 1) break;
                a=b;
                b = b+1;
                count++;
            }
        }
        System.out.println(count);
    }
}

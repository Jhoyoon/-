package bronze;
import java.io.*;
import java.util.*;
public class B_14489_치킨두마리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int chicken = Integer.parseInt(br.readLine());
        if(a+b >= chicken*2){
            System.out.println((a+b)-(chicken*2));
        }else{
            System.out.println(a+b);
        }
    }
}

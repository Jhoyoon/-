package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_10768_특별한날 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mon = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        StringBuffer sb  = new StringBuffer();
        if(mon == 1){
            sb.append("Before");
        }else if(mon == 2){
            if(day < 18) sb.append("Before");
            else if(day > 18) sb.append("After");
            else sb.append("Special");
        }else{
            sb.append("After");
        }
        System.out.println(sb.toString());
    }
}

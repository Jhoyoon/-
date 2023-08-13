package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_11365_암호해독 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            char[] c = br.readLine().toCharArray();
            if(c[0] == 'E' && c[1] == 'N' && c[2] == 'D' && c.length == 3){
                break;
            }
            for(int i=c.length-1;i>=0;i--){
                sb.append(c[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

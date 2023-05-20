import java.util.*;
import java.io.*;

public class ddd {
    //일단 반으로 나누고 정렬 후 병합
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(br.readLine());
       StringBuffer sb = new StringBuffer();
       for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = (int)Math.pow(b,a)%10;
            if(r == 0) sb.append(10+"\n");
            else sb.append(r+"\n");
       }
       System.out.print(sb.toString());
    }
}
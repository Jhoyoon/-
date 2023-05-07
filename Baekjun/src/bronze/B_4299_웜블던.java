package bronze;
import java.io.*;
import java.util.*;
public class B_4299_웜블던 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // a + b = s
        // a - b = m
        int a = (s+m)/2;
        int b = s - a;
        // 두 수의 합이 차보다 반드시 커야한다.
        if((s+m)%2 != 0 || s < m ){
            System.out.println(-1);
        }else{
            System.out.println(a+" "+b);
        }
    }
}

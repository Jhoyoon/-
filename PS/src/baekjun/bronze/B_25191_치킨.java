package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_25191_치킨 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int a2 = a/2;
        System.out.println(Math.min(a2+b,N));
    }
}

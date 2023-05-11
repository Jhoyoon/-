package bronze;
import java.io.*;
import java.util.*;
public class B_25628_햄버거만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a = N/2;
        System.out.println(Math.min(a,M));

    }
}

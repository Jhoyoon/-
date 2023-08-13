package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_3046_R2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int r1 = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        System.out.println(s*2-r1);
    }
}

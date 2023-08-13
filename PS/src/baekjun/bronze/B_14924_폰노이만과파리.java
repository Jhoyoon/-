package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_14924_폰노이만과파리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 기차의 속도
        int s = Integer.parseInt(st.nextToken());
        // 파리의 속도
        int t = Integer.parseInt(st.nextToken());
        // 두 기차 사이의 거리
        int d = Integer.parseInt(st.nextToken());
        System.out.println((d/(s*2))*t);

    }
}

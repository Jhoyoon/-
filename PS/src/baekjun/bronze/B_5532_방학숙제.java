package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_5532_방학숙제{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 방학 일수
        int L = Integer.parseInt(br.readLine());
        // 수학 페이지
        int A = Integer.parseInt(br.readLine());
        // 국어 페이지
        int B = Integer.parseInt(br.readLine());
        // 하루에 풀수 있는 국어 페이지
        int C = Integer.parseInt(br.readLine());
        // 하루에 풀수 있는 수학 페이지
        int D = Integer.parseInt(br.readLine());
        while(true){
            L = L-1;
            B = B - D;
            A = A - C;
            if(B<=0 && A <= 0) break;
        }
        System.out.println(L);
    }
}
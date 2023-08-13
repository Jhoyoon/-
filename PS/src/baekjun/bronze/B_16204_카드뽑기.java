package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_16204_카드뽑기 {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken());
    // 앞면 동그라미
    int M = Integer.parseInt(st.nextToken());
    // 앞면 엑스
    int m = N-M;
    // 뒷면 동그라미
    int K = Integer.parseInt(st.nextToken());
    // 뒷면 엑스
    int k = N-K;
    int front = Math.min(M,K);
    int back = Math.min(m,k);
    System.out.println(front + back);
    

    }
}

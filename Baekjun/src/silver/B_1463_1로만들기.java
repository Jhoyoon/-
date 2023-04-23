package silver;
import java.io.*;
import java.util.*;
public class B_1463_1로만들기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 인덱스 숫자가 1이 되는데 필요한 연산 횟수
        int[] D = new int[N+2];
        D[1] = 0;
        D[2] = 1;
        for(int i=3;i<=N;i++){
            D[i] = D[i-1]+1;
            if(i%3==0) D[i] = Math.min(D[i/3]+1,D[i]);
            if(i%2==0) D[i] = Math.min(D[i/2]+1,D[i]);
        }
        System.out.print(D[N]);
    }
}
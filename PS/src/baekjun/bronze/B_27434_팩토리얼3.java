package baekjun.bronze;
import java.io.*;
import java.math.*;
import java.util.*;
public class B_27434_팩토리얼3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger ans = BigInteger.ONE;
        for(int i=2;i<=N;i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        System.out.println(ans);
    }
}

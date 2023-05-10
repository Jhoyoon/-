package bronze;
import java.io.*;
import java.util.*;
public class B_17362_수학은체육과목 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N = N%8;
        System.out.println(N > 5 || N == 0 ? (10 - N) % 8 : N);
    }
}

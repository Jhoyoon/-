package bronze;
import java.io.*;
import java.util.*;
public class B_2442_별찍기_5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            for(int j = i; j < N; j++) {
              System.out.print(" ");
            }
            for(int j = 0; j < i*2-1; j++) {
              System.out.print("*");
            }
            System.out.println();
          }
    }
}

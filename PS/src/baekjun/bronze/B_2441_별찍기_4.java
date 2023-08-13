package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_2441_별찍기_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j>=i) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}

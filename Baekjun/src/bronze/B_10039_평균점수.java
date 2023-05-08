package bronze;
import java.io.*;
import java.util.*;
public class B_10039_평균점수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[5];
        int sum =0;
        for(int i=0;i<5;i++){
            int s = Integer.parseInt(br.readLine());
            if(s <= 40) s = 40;
            sum = sum + s;
        }
        System.out.println(sum/5);
    }
}

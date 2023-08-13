package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_1546_평균 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N+1];
        double max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            score[i] = Integer.parseInt(st.nextToken());
            if(score[i]>max) max = score[i];
        }
        double sum = 0;
        for(int i=1;i<=N;i++){
            score[i] = (score[i] /max) *100;
            sum = sum +score[i];
        }
        System.out.println(sum/N);

    }
}

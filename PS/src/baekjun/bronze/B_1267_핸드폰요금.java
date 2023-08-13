package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_1267_핸드폰요금 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int y = 0;
        int m = 0;
        for(int i=0;i<N;i++){
            int time = Integer.parseInt(st.nextToken());
            y = y + (time/30+1)*10;
            m = m + (time/60+1) * 15;
        }
        if(y==m) System.out.println("Y M "+y);
        else if(y<m) System.out.println("Y "+y);
        else System.out.println("M "+m);
    }
}

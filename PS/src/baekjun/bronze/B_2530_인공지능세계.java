package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_2530_인공지능세계 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());
        s = s + time;
        while(s >= 60){
            m++;
            s = s-60;
        }
        while(m >= 60){
            h++;
            m = m -60;
            if(h == 24) h = 0;
        }
        System.out.println(h+" "+m+" "+s+" ");
    }
}

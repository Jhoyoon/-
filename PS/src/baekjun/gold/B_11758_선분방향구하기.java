package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_11758_선분방향구하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1,y1,x2,y2,x3,y3;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        int CCW = (x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3);
        if(CCW>0) System.out.println(1);
        else if(CCW<0) System.out.println(-1);
        else System.out.println(0);
    }
}
package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_5575_타임카드 {
        static int h;
        static int m;
        static int s;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a_출근시간 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        int a_퇴근시간 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        int a_근무시간 = a_퇴근시간 - a_출근시간;

        st = new StringTokenizer(br.readLine()," ");
        int b_출근시간 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        int b_퇴근시간 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        int b_근무시간 = b_퇴근시간 - b_출근시간;

        st = new StringTokenizer(br.readLine()," ");
        int c_출근시간 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        int c_퇴근시간 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        int c_근무시간 = c_퇴근시간 - c_출근시간;
        StringBuffer sb = new StringBuffer();
        h = 0;
        m=0;
        s=0;
        timeFormat(a_근무시간);
        sb.append(h+" "+m+" "+s+"\n");
        h = 0;
        m=0;
        s=0;
        timeFormat(b_근무시간);
        sb.append(h+" "+m+" "+s+"\n");
        h=0;
        m=0;
        s=0;
        timeFormat(c_근무시간);
        sb.append(h+" "+m+" "+s+"\n");
        System.out.print(sb.toString());
    }
    private static void timeFormat(int second){
        while(second >=60){
            second = second - 60;
            m++;
        }
        s = second;
        while(m>=60){
            m = m - 60;
            h++;
        }
    }
}

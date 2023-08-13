package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_1703_생장점 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb  =new StringBuffer();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int year = Integer.parseInt(st.nextToken());
            if(year == 0) break;
            int sum = 1;
            for(int i=0;i<year;i++){
                int factor = Integer.parseInt(st.nextToken());
                int cut = Integer.parseInt(st.nextToken());
                sum = sum * factor;
                sum = sum - cut;
            }
            sb.append(sum+"\n");
        }
        System.out.print(sb.toString());
    }
}

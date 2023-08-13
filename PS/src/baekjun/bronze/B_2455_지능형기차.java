package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_2455_지능형기차 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int sum = 0;
        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            sum = sum - Integer.parseInt(st.nextToken());
            sum = sum + Integer.parseInt(st.nextToken());
            result = Math.max(result,sum);
        }
        System.out.println(result);

    }
}

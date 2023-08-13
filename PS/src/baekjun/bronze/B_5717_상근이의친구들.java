package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_5717_상근이의친구들 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            if(M == 0 && F == 0) break;
            sb.append(M+F+"\n");
        }
        System.out.print(sb.toString());
    }
}

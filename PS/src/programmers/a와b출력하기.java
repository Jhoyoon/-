package programmers;
import java.io.*;
import java.util.*;

public class a와b출력하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        sb.append("a = "+a+"\n");
        sb.append("b = "+b+"\n");
        System.out.print(sb.toString());
    }
}

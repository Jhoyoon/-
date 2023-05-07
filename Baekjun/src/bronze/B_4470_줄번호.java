package bronze;
import java.io.*;
import java.util.*;
public class B_4470_줄번호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            sb.append(i+". "+br.readLine()+"\n");
        }
        System.out.print(sb.toString());
    }
}

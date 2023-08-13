package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_15726_이칙연산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double max = Math.max(a*b/c,a/b*c);
        System.out.println((int)max);

    }
}

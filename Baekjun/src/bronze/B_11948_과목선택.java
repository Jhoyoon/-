package bronze;
import java.io.*;
import java.util.*;
public class B_11948_과목선택 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 물리
        int A = Integer.parseInt(br.readLine());
        // 화학
        int B = Integer.parseInt(br.readLine());
        // 생물
        int C = Integer.parseInt(br.readLine());
        // 지구과학
        int D = Integer.parseInt(br.readLine());
        // 역사
        int E = Integer.parseInt(br.readLine());
        // 지리
        int F = Integer.parseInt(br.readLine());
        int first = Math.min(A,Math.min(B,Math.min(C,D)));
        int second = Math.min(F,E);
        System.out.println(A+B+C+D+E+F-first-second);
    }
}

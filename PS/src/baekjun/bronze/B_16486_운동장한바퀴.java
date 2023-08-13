package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_16486_운동장한바퀴 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        double pi = 3.141592;
        System.out.println(2*d1+pi*d2*2);
    }
}

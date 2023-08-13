package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_11282_한글 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        // 가는 아스키 코드가 44032이다.
        System.out.println((char)(a+44031));
    }
}

package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_11283_한글2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        System.out.println(c-44031);
    }
}
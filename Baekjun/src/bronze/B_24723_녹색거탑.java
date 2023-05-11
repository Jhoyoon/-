package bronze;
import java.io.*;
import java.util.*;
public class B_24723_녹색거탑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2,N));
    }
}

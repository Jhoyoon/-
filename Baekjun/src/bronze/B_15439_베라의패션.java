package bronze;
import java.io.*;
import java.util.*;

public class B_15439_베라의패션 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N*(N-1));
    }
}

package bronze;
import java.io.*;
import java.util.*;
public class B_27959_초코바{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken())*100;
        int M = Integer.parseInt(st.nextToken());
        if(N>=M) System.out.print("Yes");
        else System.out.print("No");
    }
}
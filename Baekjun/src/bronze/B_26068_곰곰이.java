package bronze;
import java.io.*;
import java.util.*;
public class B_26068_곰곰이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),"-");
            st.nextToken();
            if(Integer.parseInt(st.nextToken())<=90)count++;
        }
        System.out.println(count);
    }
}

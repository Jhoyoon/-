package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_13118_뉴턴과사과 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] x = new int[5];
        for(int i=1;i<=4;i++){
            x[i] = Integer.parseInt(st.nextToken()); 
        }
        st = new StringTokenizer(br.readLine()," ");
        int[] r = new int[3];
        for(int i=0;i<3;i++){
            r[i] = Integer.parseInt(st.nextToken());
        }
        boolean b = false;
        int result = 0;
        for(int i=1;i<=4;i++){
            if(x[i] == r[0]){
                b = true;
                result = i;
                break;
            }
        }
        if(b)System.out.println(result);
        else System.out.println(0);
    }
}

package bronze;
import java.io.*;
import java.util.*;

import org.xml.sax.InputSource;
public class B_2845_파티가끝나고난뒤 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int num = N*M;
        int[] arr = new int[5];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<5;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println((arr[0]-num)+" "+(arr[1]-num)+" "+(arr[2]-num)+" "+(arr[3]-num)+" "+(arr[4]-num));
        
    }
}



import java.util.*;
import java.io.*;

public class B_1934_최소공배수{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb  =new StringBuffer();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int multi = min*max;
            int result = gcd(min,max);
            if(i==N-1){
                sb.append(multi/result);
            }else{
                sb.append(multi/result+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    private static int gcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
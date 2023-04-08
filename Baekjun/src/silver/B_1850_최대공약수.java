package silver;
import java.util.*;
import java.io.*;
public class B_1850_최대공약수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long result= gcd(min,max);
        StringBuffer sb  =new StringBuffer();
        for(int i=0;i<result;i++){
            sb.append("1");
        }
        System.out.println(sb.toString());

    }

    private static long gcd(long a,long b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}

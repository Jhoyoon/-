import java.util.*;
import java.io.*;
public class B_21568_확장유클리드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long 최대공약수 = gcd(a,b);
        if(c%최대공약수!=0){
            System.out.println(-1);
        }else{
            long mok = c/최대공약수;
            long[] ret = Excute(a,b);
            System.out.println(ret[0]*mok + " "+ret[1]*mok);
        }
    }
    private static long[] Excute(long a,long b){
        long[] ret = new long[2];
        if(b==0){
            ret[0]=1;ret[1]=0;
            return ret;
        }
        long q=  a/b;
        long[] v = Excute(b,a%b);
        ret[0] = v[1];
        ret[1] = v[0]-v[1]*q;
        return ret;
    }
    private static long gcd(long a,long b){
       if(b==0){
        return a;
       }else{
        return gcd(b,a%b);
       }
    }
}

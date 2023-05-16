package bronze;
import java.io.*;
import java.util.*;
import java.math.*;
public class B_1837_암호제작{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BigInteger N = new BigInteger(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[M+1];
        primes[1] = true;
        boolean find = true;
        for(int i=2;i<M;i++){
            if(primes[i]) continue;
            if(N.mod(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) == 0){
                System.out.println("BAD "+i);
                find = false;
                break;
            }else{
                for(int j=i+i;j<M;j = j+i){
                    primes[j] = true;
                }
            }
        } 
        if(find) System.out.println("GOOD");
    }
}
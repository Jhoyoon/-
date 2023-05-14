package bronze;
import java.io.*;
import java.util.*;
import java.math.*;
public class B_1247_부호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<3;i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(BigIntegerCompare(N,br)+"\n");
        }
        System.out.print(sb.toString());
        
    }
    private static char BigIntegerCompare(int num,BufferedReader br) throws IOException{
        BigInteger[] arr = new BigInteger[num];
        BigInteger zero = new BigInteger("0");
        BigInteger sum = new BigInteger("0");
        for(int i=0;i<num;i++){
            arr[i] = new BigInteger(br.readLine());
            sum = sum.add(arr[i]);
        }
        if(sum.compareTo(zero) >0) return '+';
        else if(sum.compareTo(zero) <0) return '-';
        else return '0';
    }
}

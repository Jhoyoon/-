package gold;
import java.io.*;
import java.util.*;
public class B_2023_신기한소수{
    static int N;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
        System.out.print(sb.toString());
    }
    private static void DFS(int num,int jarisu){
        if(!isPrime(num)) return;
        if(jarisu == N){
            if(isPrime(num)){
                sb.append(num+"\n");
            }
            return;
        }
        for(int i=1;i<=9;i++){
            if(num*10+i % 2==0) continue;
            DFS(num*10+i,jarisu+1);
        }
    }
    private static boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}
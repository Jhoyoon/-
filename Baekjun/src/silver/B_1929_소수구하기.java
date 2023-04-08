package silver;
// import java.util.*;
// import java.io.*;

// 브루트포스 방식 소수 구하기
// public class B_1929 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st  = new StringTokenizer(br.readLine()," ");
//         int N  = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());

//         for(int i=N;i<=M;i++){
//             if(isPrime(i)) System.out.println(i);
//         }
//     }
//     private static boolean isPrime(int i){
//         if(i<2) return false;
//         if(i==2) return true;

//         for(int j=2;j<i;j++){
//             if(i%j==0) return false;
//         }
//         return true;

//     }
// }

import java.util.*;
import java.io.*;
public class B_1929_소수구하기{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[M+1];
        for(int i=1;i<=M;i++){
            arr[i] = i;
        }

        for(int i=2;i<=Math.sqrt(M);i++){
            if(arr[i]==0) continue;
            for(int j=i+i;j<=M;j=j+i){
                arr[j] = 0;
            }
        }
        arr[1]=0;
        StringBuffer sb = new StringBuffer();
        for(int i=N;i<=M;i++){
            if(arr[i]!=0) sb.append(arr[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}
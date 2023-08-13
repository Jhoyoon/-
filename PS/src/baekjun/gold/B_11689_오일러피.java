package baekjun.gold;
// import java.io.*;
// import java.util.*;
// public class B_11689_오일러피{
//     public static void main(String[] args)throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         long num = Long.parseLong(br.readLine());
//         long result = num;
//         for(long i = 2;i<=Math.sqrt(num);i++){
//             if(num%i==0){
//                 result = result -result/i;
//                 while(num%i==0) num = num/i;
//             }
//         }
//         if(num>1) result = result-result/num;
//         System.out.println(result);
//     }
// }

import java.io.*;
import java.util.*;
public class B_11689_오일러피{
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       long N = Long.parseLong(br.readLine());
       long result = N;
       for(long i=2;i<=Math.sqrt(N);i++){
        if(N%i==0) {result = result - result/i;
            while(N%i==0) N = N/i;
        }
       }
       if(N>1) result = result - result/N;
       System.out.println(result);
    }
}
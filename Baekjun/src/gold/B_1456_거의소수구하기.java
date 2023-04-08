package gold;
// import java.io.*;
// import java.util.*;

// public class B_1456_거의소수구하기{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         long min = sc.nextLong();
//         long max = sc.nextLong();
//         long[] arr = new long[10000001];
//         for(int i=2;i<arr.length;i++){
//             arr[i] = i;
//         }
//         for(int i=2;i<Math.sqrt(arr.length);i++){
//             if(arr[i]==0) continue;
//             for(int j=i+i;j<arr.length;j=j+i){
//                 arr[j]=0;
//             }
//         }
//         int count = 0;
//         // 제곱수가 max min 범위 안에 있는지 찾기
//         for(int i=2;i<arr.length;i++){
//             if(arr[i]!=0){
//                 long tmp = arr[i];
//                 while((double)arr[i]<=max/(double)tmp){
//                     if(arr[i]>=min/(double)tmp){
//                         count++;
//                     }
//                     tmp = tmp*arr[i];
//                 }
//             }
//         }
//         System.out.println(count);
//     }
// }

import java.io.*;
import java.util.StringTokenizer;

public class B_1456_거의소수구하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long[] arr = new long[10000001];
        for(int i=2;i<arr.length;i++){
            arr[i] = i;
        }
        // 소수 판별하기
        for(int i=2;i<Math.sqrt(arr.length);i++){
            if(arr[i]==0) continue;
            for(int j=i+i;j<arr.length;j+=i){
                arr[j]=0;
            }
        }
        // 제곱수가 범위안에 있는지 확인하기
        int count = 0;
        for(int i=2;i<arr.length;i++){
            if(arr[i]!=0){
                long tmp = arr[i];
                while((double)arr[i]<=max/(double)tmp){
                    if((double)arr[i]>=min/(double)tmp){
                       count++; 
                    }
                    tmp = arr[i]*tmp;
                }
            }
        }
        System.out.println(count);
    }
}
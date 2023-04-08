package gold;
// import java.util.*;
// import java.io.*;

// class Main{
//     public static void B_1300_k번째수(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int K = sc.nextInt();

//         int lo = 1;
//         int hi = K;
//         int mid=0;
//         int sol=0;
//         while(lo <=hi){
//             mid = (lo+hi)/2;
//             int count=0;
//             // 2차원 행렬의 각 행을 나누는거임 미드에
//             for(int i=1;i<=N;i++){
//                 count = count+Math.min(N,mid/i);
//             }
            
//             if(count<K) lo=mid+1;
//             else{
//                 sol = mid;
//                 hi=mid-1;
//             }
//         }
//         System.out.println(sol);
//     }
// }

import java.util.*;

public class B_1300_k번째수{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int s = 1;
        int e = K;
        int sol = 0;
        while(s<=e){
            int mid = (e+s)/2;
            int count = 0;
            for(int i=1;i<=N;i++){
                count = count+Math.min(N,mid/i);
            }
            // lowerbound를 써야한다!
            if(count<K){
                s = mid+1;
            }else{
                sol = mid;
                e = mid-1;
            }
        }
        System.out.println(sol);
    }
}
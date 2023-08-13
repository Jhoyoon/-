package baekjun.silver;
// import java.io.*;
// import java.util.*;
// public class B_14501_퇴사준비하기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         // 1일부터 인덱스일 까지 얻을수 있는 최대의 수입
//         int[] D = new int[20];
//         int[] T = new int[20];
//         int[] P = new int[20];
//         for(int i=1;i<=N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             T[i] = Integer.parseInt(st.nextToken());
//             P[i] = Integer.parseInt(st.nextToken());
//         }
//         for(int i=1;i<=N;i++){
//             if(T[i]+i >N){
//                 D[i] = D[i+1];
//             }else{
//                 D[i] = Math.max(D[i+1],D[i+T[i]]+P[i]);
//             }
//         }
//         System.out.print(D[1]);

//     }
// }
import java.io.*;
import java.util.*;
public class B_14501_퇴사준비하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[20];
        int[] P = new int[20];
        int[] D = new int[20];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N;i>=1;i--){
            if(T[i]+i>N+1){
                D[i] = D[i+1];
            }else{
                D[i] = Math.max(D[i+1],D[i+T[i]]+P[i]);
            }
        }
        System.out.print(D[1]);
    }
}
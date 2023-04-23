package silver;
// import java.io.*;
// public class B_2193_이친수{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N= Integer.parseInt(br.readLine());
//         // 1로 끝나는거랑 0으로 끝나는거
//         long[][] arr = new long[N+1][2];
//         arr[1][0] = 0;
//         arr[1][1]=1;
//         for(int i=2;i<=N;i++){
//             arr[i][0] = arr[i-1][1]+arr[i-1][0];
//             arr[i][1] = arr[i-1][0];
//         }
//         System.out.print(arr[N][0]+arr[N][1]);
//     }
// }
import java.io.*;
import java.util.*;
public class B_2193_이친수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N+1][2];
        D[1][0]=0;
        D[1][1]=1;
        for(int i=2;i<=N;i++){
            D[i][0] = D[i-1][0]+D[i-1][1];
            D[i][1] = D[i-1][0];
        }
        System.out.print(D[N][0]+D[N][1]);
    }
}
package gold;

// import java.io.*;
// import java.util.*;

// public class B_11404_플로이드{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int M = Integer.parseInt(br.readLine());
//         long[][] price = new long[N+1][N+1];
//         for(int i=1;i<=N;i++){
//             for(int j=1;j<=N;j++){
//                 if(i==j) price[i][j] =0;
//                 else price[i][j] = Integer.MAX_VALUE;
//             }
//         }
//         for(int i=0;i<M;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             int p = Integer.parseInt(st.nextToken());
//             if(price[s][e]>p) price[s][e] = p;
//         }
//         for(int k=1;k<=N;k++){
//             for(int i=1;i<=N;i++){
//                 for(int j=1;j<=N;j++){
//                     price[i][j] = Math.min(price[i][j],price[i][k]+price[k][j]);
//                 }
//             }
//         }
//         StringBuffer sb  =new StringBuffer();
//         for(int i=1;i<=N;i++){
//             for(int j=1;j<=N;j++){
//                 if(price[i][j] == Integer.MAX_VALUE) sb.append(0+" ");
//                 else sb.append(price[i][j]+" ");
//             }
//             sb.append("\n");
//         }
//         System.out.print(sb.toString());
//     }
// }
import java.io.*;
import java.util.*;

public class B_11404_플로이드{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long[][] price = new long[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) price[i][j] = 0;
                else price[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(price[s][e]>p) price[s][e] = p;
        }
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    price[i][j] = Math.min(price[i][j],price[i][k]+price[k][j]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(price[i][j] == Integer.MAX_VALUE) sb.append("0 ");
                else sb.append(price[i][j]+" "); 
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
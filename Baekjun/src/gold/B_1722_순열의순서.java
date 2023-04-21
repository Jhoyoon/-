package gold;
// import java.io.*;
// import java.util.*;
// public class B_1722_순열의순서{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         long[] F = new long[21];
//         int[] S = new int[21];
//         boolean[] visited = new boolean[21];
//         F[0] = 1;
//         for(int i=1;i<=20;i++){
//             F[i] = F[i-1]*i;
//         }
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int Q = Integer.parseInt(st.nextToken());
//         if(Q==1){
//             long K = Long.parseLong(st.nextToken());
//             for(int i=1;i<=N;i++){
//                 for(int j=1,cnt=1;j<=N;j++){
//                     if(visited[j]) continue;
//                     if(K<=cnt*F[N-i]){
//                         visited[j] = true;
//                         K = K-((cnt-1)*F[N-i]);
//                         S[i]=j;
//                         break;
//                     }
//                     cnt++;
//                 }
//             }
//             StringBuffer sb = new StringBuffer();
//             for(int i=1;i<=N;i++){
//                 sb.append(S[i]+" ");
//             }
//             System.out.print(sb.toString());
//         }else if(Q==2){
//             long K = 1;
//             for(int i=1;i<=N;i++){
//                 long cnt = 0;
//                 S[i] = Integer.parseInt(st.nextToken());
//                 for(int j=1;j<S[i];j++){
//                     if(!visited[j]) cnt++;
//                 }
//                 K = K+cnt*F[N-i];
//                 visited[S[i]] = true;
//             }
//             System.out.println(K);
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class B_1722_순열의순서{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] F = new long[21];
        int[] S = new int[21];
        boolean[] visited = new boolean[21];
        F[0] = 1;
        for(int i=1;i<=N;i++){
            F[i] = F[i-1]*i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Q = Integer.parseInt(st.nextToken());
        if(Q == 1){
            long K = Long.parseLong(st.nextToken());
            for(int i=1;i<=N;i++){
                for(int j=1,cnt=1;j<=N;j++){
                    if(visited[j]) continue;
                    if(K<=cnt * F[N-i]){
                        visited[j] = true;
                        K = K-(cnt-1) * F[N-i];
                        S[i] = j;
                        break;
                    }
                    cnt++;
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int i=1;i<=N;i++){
                sb.append(S[i]+" ");
            }
            System.out.print(sb.toString());
        }else if(Q==2){
            long K = 1;
            for(int i=1;i<=N;i++){
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j=1;j<S[i];j++){
                    if(!visited[j]) cnt++;
                }
                visited[S[i]]=true;
                K = K + cnt*F[N-i];
            }
            System.out.print(K);
        }
    }
}
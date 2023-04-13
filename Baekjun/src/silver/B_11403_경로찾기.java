package silver;
// import java.io.*;
// import java.util.*;
// public class B_11403_경로찾기 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int[][] arr = new int[N+1][N+1];
//         for(int i=1;i<=N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             for(int j=1;j<=N;j++){
//                 arr[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         for(int k=1;k<=N;k++){
//             for(int i=1;i<=N;i++){
//                 for(int j=1;j<=N;j++){
//                     if(arr[i][k]==1 && arr[k][j] ==1) arr[i][j] = 1;
//                 }
//             }
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i=1;i<=N;i++){
//             for(int j=1;j<=N;j++){
//                 sb.append(arr[i][j]+" ");
//             }   
//             sb.append("\n");
//         }
//         System.out.print(sb.toString());
//     }
// }

import java.util.*;
import java.io.*;

public class B_11403_경로찾기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(arr[i][k] != 0 && arr[k][j]!=0) arr[i][j] = 1;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
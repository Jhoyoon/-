package baekjun.silver;
// import java.io.*;
// import java.util.StringTokenizer;
// public class B_1010_다리놓기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int[][] arr = new int[31][31];
//         for(int i=0;i<=30;i++){
//             arr[i][i] = 1;
//             arr[i][0]=1;
//             arr[i][1]=i;
//         }
//         for(int i=2;i<=30;i++){
//             for(int j=2;j<=30;j++){
//                 arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
//             }
//         }
//         int T = Integer.parseInt(br.readLine());
//         StringBuffer sb = new StringBuffer();
//         for(int i=0;i<T;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int N = Integer.parseInt(st.nextToken());
//             int M = Integer.parseInt(st.nextToken());
//             sb.append(arr[M][N]+"\n");
//         }
//         System.out.print(sb.toString());
//     }
// }
import java.io.*;
import java.util.*;
public class B_1010_다리놓기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] arr = new long[31][31];
        for(int i=0;i<=30;i++){
            arr[i][i]=1;
            arr[i][0]=1;
            arr[i][1]=i;
        }
        for(int i=2;i<=30;i++){
            for(int j=2;j<i;j++){
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(arr[M][N]+"\n");
        }
        System.out.print(sb.toString());
    }
}
package baekjun.silver;
// import java.util.*;
// import java.io.*;
// public class B_13251_조약돌꺼내기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
//         // 조약돌 색깔 종류
//         int M = Integer.parseInt(br.readLine());
//         int[] num = new int[51];
//         int sum = 0;
//         double[] probability = new double[51];
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         for(int i=0;i<M;i++){
//             num[i] = Integer.parseInt(st.nextToken());
//             sum = sum+num[i];
//         }
//         double ans = 0.0;
//         int choice = Integer.parseInt(br.readLine());
//         for(int i=0;i<M;i++){
//             if(num[i]>=choice){
//                 probability[i] = 1.0;
//                 for(int j=0;j<choice;j++){
//                     probability[i] = probability[i]*(num[i]-j)/(sum-j);
//                 }
//             }
//             ans = ans+probability[i];
//         }
//         System.out.print(ans);
//     }
// }
import java.util.*;
import java.io.*;
public class B_13251_조약돌꺼내기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stone = new int[N+1];
        double[] probability = new double[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for(int i=1;i<=N;i++){
            stone[i] = Integer.parseInt(st.nextToken());
            sum +=stone[i];
        }
        double ans = 0.0;
        int M = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            if(stone[i]>=M){
                probability[i] = 1.0;
                for(int j=0;j<M;j++){
                    probability[i] = probability[i]*(stone[i]-j)/(sum-j);
                }
            }
            ans+=probability[i];
        }
        System.out.print(ans);
    }
}
package baekjun.gold;
// import java.io.*;
// import java.util.*;
// public class B_2166_다각형의넓이 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         long[] x = new long[N+1];
//         long[] y = new long[N+1];
//         for(int i=0;i<N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             x[i] = Long.parseLong(st.nextToken());
//             y[i] = Long.parseLong(st.nextToken());
//         }
//         x[N] = x[0];
//         y[N] = y[0];
//         double result = 0;
//         for(int i=0;i<N;i++){
//             result = result + (x[i]*y[i+1]) - (x[i+1]*y[i]);
//         }
//         String answer = String.format("%.1f",Math.abs(result)/2.0);
//         System.out.println(answer);
//     }
// }
import java.io.*;
import java.util.*;
public class B_2166_다각형의넓이{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N+1];
        long[] y = new long[N+1];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];
        double result = 0.0;
        for(int i=0;i<N;i++){
            result  = result + (x[i]*y[i+1]-x[i+1]*y[i]);
        }
        // 이 코드가 반올림까지 자동으로 해줌 개꿀
        String answer = String.format("%.1f",Math.abs(result)/2.0);
        System.out.println(answer);
    }
}
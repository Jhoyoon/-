package baekjun.gold;
// import java.io.*;
// import java.util.*;
// public class B_11049_행렬곱셈순서{
//     static int[][] D;
//     static Matrix[] M;
//     static int N;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         N = Integer.parseInt(br.readLine());
//         D = new int[1000][1000];
//         M = new Matrix[1000];
//         for(int i=1;i<1000;i++){
//             for(int j=1;j<1000;j++){
//                 D[i][j] = -1;
//             }
//         }
//         for(int i=1;i<=N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int y = Integer.parseInt(st.nextToken());
//             int x = Integer.parseInt(st.nextToken());
//             M[i] = new Matrix(y, x);
//         }
//         System.out.println(excute(1,N));
//     }
//     private static int excute(int s,int e){
//         int result = Integer.MAX_VALUE;
//         if(D[s][e] != -1) return D[s][e];
//         if(s == e) return  0;
//         if(s+1 == e) return M[s].y*M[s].x*M[e].x;
//         for(int i=s;i<e;i++){
//             int a = M[s].y*M[i].x*M[e].x;
//             result  = Math.min(result,a+excute(s,i)+excute(i+1,e));
//         }
//         return D[s][e] = result;
//     }
// }
// class Matrix{
//     int y;
//     int x;
//     Matrix(int y,int x){
//         this.y = y;
//         this.x = x;
//     }
// }
import java.io.*;
import java.util.*;
public class B_11049_행렬곱셈순서{
    static int[][] D;
    static Matrix[] M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        D = new int[1000][1000];
        M = new Matrix[1000];
        for(int i=1;i<1000;i++){
            for(int j=1;j<1000;j++){
                D[i][j] = -1;
            }
        }
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int y  =Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            M[i] = new Matrix(y, x);
        }
        System.out.println(excute(1,N));
    }
    private static int excute(int s,int e){
        int result = Integer.MAX_VALUE;
        if(D[s][e] != -1) return D[s][e];
        if(s == e) return 0;
        if(s+1 == e) return M[s].y*M[s].x*M[e].x;
        for(int i=s;i<e;i++){
            int a = M[s].y*M[i].x*M[e].x;
            result = Math.min(result,a+excute(s,i)+excute(i+1,e));
            
        }
        return D[s][e] = result;
    }
}
class Matrix{
    int y;
    int x;
    Matrix(int y,int x){
        this.y = y;
        this.x = x;
    }
}
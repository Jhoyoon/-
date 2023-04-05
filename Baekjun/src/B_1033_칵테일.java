// import java.io.*;
// import java.util.*;
// public class B_1033_칵테일 {
//     static ArrayList<cNode>[] A;
//     static long lcm;
//     static boolean[] visited;
//     static long D[];
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         A = new ArrayList[N];
//         visited =  new boolean[N];
//         D = new long[N];
//         lcm = 1;
//         for(int i=0;i<N;i++){
//             A[i]=new ArrayList<cNode>();
//         }
//         for(int i=0;i<N-1;i++){
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             int p = sc.nextInt();
//             int q = sc.nextInt();
//             A[a].add(new cNode(b,p,q));
//             A[b].add(new cNode(a,q,p));
//         }

//     }
// }
// 이거는 시발 모르겠다 나중에 풀자
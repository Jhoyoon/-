package gold;
// import java.io.*;
// import java.util.*;
// public class B_1707_이분그래프 {
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static boolean check;
//     static int[] zero;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine());
//         for(int i=0;i<T;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int N = Integer.parseInt(st.nextToken());
//             int M = Integer.parseInt(st.nextToken());
//             arr = new ArrayList[N+1];
           
//             for(int j=1;j<=N;j++){
//                 arr[j] = new ArrayList<>();
//             }
//             for(int j=0;j<M;j++){
//                 st = new StringTokenizer(br.readLine()," ");
//                 int s = Integer.parseInt(st.nextToken());
//                 int e = Integer.parseInt(st.nextToken());
//                 arr[s].add(e);
//                 arr[e].add(s);
//             }
//             visited = new boolean[N+1];
//             check = true;
//             zero = new int[N+1];
//             for(int j=1;j<=N;j++){

//                 if(check) DFS(j);
//                 else break;
//             }
//             if(check) System.out.println("YES");
//             else System.out.println("NO");
//         }
//     }
//     private static void DFS(int n){
//         visited[n] = true;
//         for(int i: arr[n]){
//             if(!visited[i]){
//                 visited[i]=true;
//                 zero[i] = (zero[n]+1)%2;
//                 DFS(i);
//             }else{
//                 if(zero[i] == zero[n]) check = false;
//             }
//         }
//     }
// }

// import java.io.*;
// import java.util.*;

// public class B_1707_이분그래프{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static int[] check;
//     static boolean go;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int T = Integer.parseInt(br.readLine());
//         for(int j = 0;j<T;j++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int N = Integer.parseInt(st.nextToken());
//             int M = Integer.parseInt(st.nextToken());
//             arr = new ArrayList[N+1];
//             for(int i=1;i<=N;i++){
//                 arr[i] = new ArrayList<>();
//             }
//             for(int i=0;i<M;i++){
//                 st = new StringTokenizer(br.readLine(), " ");
//                 int s = Integer.parseInt(st.nextToken());
//                 int e = Integer.parseInt(st.nextToken());
//                 arr[s].add(e);
//                 arr[e].add(s);
//             }
//             // 아 그러네 안에서 초기화 하지 않으면 그냥 바로 바로 이분 그래프인지 유무를 확인할수 있구나!
//             // 지금 이 문제의 목적은 check 배열을 채우는거니까!
//             visited = new boolean[N+1];
//             check = new int[N+1];
//             go = true;
//             for(int i=1;i<=N;i++){
//                 if(go){
//                     DFS(i);
//                 }else{
//                     break;
//                 }
//             }
//             if(go){
//                 System.out.println("YES");
//             }else{
//                 System.out.println("NO");
//             }
//         }
//     }
//     private static void DFS(int n){
//         visited[n]=true;
//         for(int i : arr[n]){
//             if(!visited[i]){
//                 visited[i] = true;
//                 check[i] = (check[n]+1)%2;
//                 DFS(i);
//             }else{
//                 if(check[i]==check[n]) go=false;
//             }
//         }
//     }
// }

import java.io.*;
import java.util.*;

public class B_1707_이분그래프{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] check;
    static boolean com;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int j=0;j<T;j++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N+1];
            check = new int[N+1];
            visited = new boolean[N+1];
            com = true;
            for(int i=1;i<=N;i++){
                arr[i] = new ArrayList<>();
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[s].add(e);
                arr[e].add(s);
            }
            for(int i=1;i<=N;i++){
                if(com){
                    DFS(i);
                }else{
                    break;
                }
            }
            
            if(com){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
    private static void DFS(int n){
        visited[n] = true;
        for(int i : arr[n]){
            if(!visited[i]){
               visited[i] = true;
               check[i]  = (check[n]+1)%2;
               DFS(i);
            }else{
                if(check[i]==check[n]) com = false;
            }
        }
    }
}
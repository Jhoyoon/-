package gold;
// import java.util.*;
// import java.io.*;
// public class B_13023{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static boolean arrive;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//         arr = new ArrayList[N];
//         visited = new boolean[N];
//         arrive=false;
//         for(int i=0;i<N;i++){
//             arr[i] = new ArrayList<>();
//         }
//         for(int i=0;i<M;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             arr[s].add(e);
//             arr[e].add(s);
//         }

//         for(int i=0;i<N;i++){
//             if(!visited[i]){
//                 DFS(i,1);
//             }
//             if(arrive) break;
//         }

//         if(arrive) System.out.println(1);
//         else System.out.println(0);
//     }

//     private static void DFS(int num ,int depth ){
//         if(depth == 5 || arrive){
//             arrive = true;
//             return;
//         }
//         visited[num] = true;
        
//         for(int i : arr[num]){
//             if(!visited[i]){
//                 DFS(i,depth+1);
//             }
//         }
//         visited[num] = false;
//     }
// }

import java.util.*;
import java.io.*;

public class B_13023{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr= new ArrayList[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                DFS(i,1);
            }
            if(arrive) break;
        }
        if(arrive) System.out.println(1);
        else System.out.println(0); 
    }

    private static void DFS(int node,int depth){
        if(depth==5 || arrive){
            arrive = true;
            return;
        }
        visited[node] = true;
        for(int i : arr[node]){
            if(!visited[i]){
                DFS(i,depth+1);
            }
        }
        visited[node]=false;
    }
}
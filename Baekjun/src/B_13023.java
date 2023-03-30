// import java.util.*;
// import java.io.*;

// public class B_13023{
//     static ArrayList<Integer>[] arr;
//     static boolean[] visited;
//     static boolean arrive;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();
//         arr = new ArrayList[N];
//         visited = new boolean[N];
//         arrive = false;
//         for(int i=0;i<N;i++){
//             arr[i] = new ArrayList<>();
//         }
//         for(int i=0;i<M;i++){
//             int s = sc.nextInt();
//             int e = sc.nextInt();
//             arr[s].add(e);
//             arr[e].add(s);
//         }

//         for(int i=0;i<N;i++){
//             DFS(i,1);
//             if(arrive) break;
//         }
//         if(arrive) System.out.println(1);
//         else System.out.println(0);
//     }

//     private static void DFS(int now,int depth){
//         if(depth==5 || arrive){
//             arrive = true;
//             return;
//         }
//         visited[now]=true;
//         for(int i : arr[now]){
//             if(!visited[i]){
//                 DFS(i,depth+1);
//             }
//         }
//         visited[now]=false;
        

//     }
// }

import java.util.*;

public class B_13023{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;

        for(int i=0;i<N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int s= sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=0;i<N;i++){
            DFS(i,1);
            if(arrive) break;
        }
        if(arrive) 
            System.out.println(1);
        else 
            System.out.println(0);
    }

    

    private static void DFS(int num,int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[num]=true;
        for(int i: arr[num]){
            if(!visited[i]){
                DFS(i,depth+1);
            }
        }
        visited[num]=false;
    }
}
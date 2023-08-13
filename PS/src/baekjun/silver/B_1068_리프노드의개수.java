package baekjun.silver;
// import java.io.*;
// import java.util.*;

// public class B_1068_리프노드의개수{
//     static boolean[] visited;
//     static int answer = 0;
//     static int deleteNode = 0;
//     static ArrayList<Integer>[] tree;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         visited = new boolean[N];
//         tree = new ArrayList[N];
//         for(int i=0;i<N;i++){
//             tree[i] = new ArrayList<>(); 
//         }
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int root = 0;
//         for(int i=0;i<N;i++){
//             int parent = Integer.parseInt(st.nextToken());
//             if(parent == -1){
//                 root = i;
//             }else{
//                 tree[parent].add(i);
//                 tree[i].add(parent);
//             }
//         }   
//         deleteNode = Integer.parseInt(br.readLine());
//         if(deleteNode == root) System.out.print(0);
//         else{
//             DFS(root);
//             System.out.print(answer);
//         }

//     }
//     private static void DFS(int n){
//         visited[n] = true;
//         int cNode = 0;
//         for(int i: tree[n]){
//             if(visited[i] == false && i != deleteNode){
//                 cNode++;
//                 DFS(i);
//             }
//         }
//         if(cNode==0){
//             answer++;
//         }
//     }
// }

import java.io.*;
import java.util.*;

public class B_1068_리프노드의개수{
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int answer=0;
    static int deleteNode = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else{
                tree[parent].add(i);
                tree[i].add(parent);
            }
        }
        st = new StringTokenizer(br.readLine());
        deleteNode = Integer.parseInt(st.nextToken());
        if(deleteNode == root){
            System.out.print(0);
        }else{
            DFS(root);
            System.out.print(answer);
        }
    }

    private static void DFS(int n){
        visited[n] = true;
        int cNode = 0;
        for(int i : tree[n]){
            if(!visited[i] && deleteNode!=i){
                visited[i] = true;
                cNode++;
                DFS(i);
            }
        }
        if(cNode==0){
            answer++;
        }
    }
}
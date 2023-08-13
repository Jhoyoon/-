package baekjun.gold;
// import java.util.*;
// import java.io.*;

// public class B_10868_최소값세그먼트트리{
//     static long[] tree;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int treeH = 0;
//         int length = N;
//         while(length>0){
//             length = length/2;
//             treeH++;
//         }
//         int treeSize = (int)Math.pow(2,treeH+1);
//         int leafNodeStart = treeSize/2;
//         tree = new long[treeSize+1];
//         for(int i=0;i<treeSize;i++){
//             tree[i] = Integer.MAX_VALUE;
//         }
//         for(int i=leafNodeStart;i<N+leafNodeStart;i++){
//             tree[i] = Long.parseLong(br.readLine());
//         }
//         setTree(treeSize-1);
//         StringBuffer sb = new StringBuffer();
//         for(int i=0;i<M;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             sb.append(getMin(s+leafNodeStart-1,e+leafNodeStart-1)+"\n");
//         }
//         System.out.print(sb.toString());
//     }
//     private static void setTree(int i){
//         while(i>1){
//             tree[i/2] = Math.min(tree[i/2],tree[i]);
//             i--;
//         }
//     }
//     private static long getMin(int s,int e){
//         long min = Long.MAX_VALUE;
//         while(s<=e){
//             if(s%2 == 1) min=Math.min(min,tree[s]);
//             if(e%2==0) min=Math.min(min,tree[e]);
//             s = (s+1)/2;
//             e = (e-1)/2;
//         }
//         return min;
//     }
// }

import java.util.*;
import java.io.*;
public class B_10868_최소값세그먼트트리{
    static long[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int treeH = 0;
        int length = N;
        while(length>0){
            length = length/2;
            treeH++;
        }
        int treeSize = (int)Math.pow(2,treeH+1);
        int leafNodeStart = treeSize/2;
        tree = new long[treeSize+1];
        for(int i=0;i<treeSize;i++){
            tree[i] = Integer.MAX_VALUE;
        }
        for(int i=leafNodeStart;i<N+leafNodeStart;i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(getMin(s+leafNodeStart-1,e+leafNodeStart-1)+"\n");
        }
        System.out.print(sb.toString());
    }
    private static long getMin(int s,int e){
        long min = Long.MAX_VALUE;
        while(e>=s){
            if(s%2 == 1) min = Math.min(min,tree[s]);
            if(e%2 == 0) min = Math.min(min,tree[e]);
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return min;
    }
    private static void setTree(int node){
        while(node>1){
            tree[node/2] = Math.min(tree[node/2],tree[node]);
            node--;
        }
    }
}
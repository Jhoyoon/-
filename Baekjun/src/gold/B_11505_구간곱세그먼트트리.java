package gold;
// import java.util.*;
// import java.io.*;
// public class B_11505_구간곱세그먼트트리{
//     static long[] tree;
//     static int MOD;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int K = Integer.parseInt(st.nextToken());
//         int treeH = 0;
//         int length = N;
//         MOD = 1000000007;
//         while(length >  0){
//             length = length/2;
//             treeH++;
//         }
//         int treeSize = (int)Math.pow(2,treeH+1);
//         int leafNodeStart = treeSize/2;
//         tree = new long[treeSize+1];
//         for(int i=0;i<treeSize;i++){
//             tree[i] = 1;
//         }
//         for(int i=leafNodeStart;i<leafNodeStart+N;i++){
//             tree[i] = Long.parseLong(br.readLine());
//         }
//         setTree(treeSize-1);
//         StringBuffer sb = new StringBuffer();
//         for(int i=0;i<M+K;i++){
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int s = Integer.parseInt(st.nextToken());
//             long e = Long.parseLong(st.nextToken());
//             if(a==1) changeVal(s+leafNodeStart-1,e);
//             else if(a==2) sb.append(getMul(s+leafNodeStart-1,e+leafNodeStart-1)+"\n");
//         }
//         System.out.print(sb.toString()); 
//         br.close();
//     }
//     private static long getMul(int s,long e){
//         long partMul = 1;
//         while(s<=e){
//             if(s%2 == 1) partMul = partMul*tree[s]%MOD;
//             if(e%2 == 0) partMul = partMul*tree[(int)e]%MOD;
//             s = (s+1)/2;
//             e = (e-1)/2;
//         }
//         return partMul;
//     }
//     private static void changeVal(int index,long value){
//         tree[index] = value;
//         while(index>0){
//             index = index/2;
//             tree[index] = tree[index*2]*tree[index*2+1]%MOD;
//         }
//     }
//     private static void setTree(int i){
//         while(i>1){
//             tree[i/2] = tree[i/2]*tree[i]%MOD;
//             i--;
//         }
//     }
// }

import java.io.*;
import java.util.*;
public class B_11505_구간곱세그먼트트리{
    static long[] tree;
    static int MOD;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int treeH = 0;
        int length = N;
        MOD = 1000000007;
        while(length>0){
            length = length/2;
            treeH++;
        }
        int treeSize = (int)Math.pow(2,treeH+1);
        int leafNodeStart = treeSize/2;
        tree = new long[treeSize+1];
        for(int i=0;i<treeSize;i++){
            tree[i] = 1;
        }
        for(int i=leafNodeStart;i<N+leafNodeStart;i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);
        StringBuffer sb  = new StringBuffer();
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a == 1){
                changeVal(s+leafNodeStart-1,e);
            }else if(a == 2){
                sb.append(getMul(s+leafNodeStart-1,e+leafNodeStart-1)+"\n");
            }
        }
        System.out.print(sb.toString());
    }
    private static long getMul(int s,long e){
        long partMul = 1;
        while(s<=e){
            if(s%2==1) partMul = partMul*tree[s]%MOD;
            if(e%2==0) partMul = partMul*tree[(int)e]%MOD;
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return partMul;
    }
    private static void changeVal(int index,long value){
        tree[index] = value;
        while(index>0){
            index = index/2;
            tree[index] = tree[index*2]*tree[index*2+1]%MOD;
        }
    }
  
    private static void setTree(int i){
        while(i>1){
            tree[i/2] = tree[i/2]*tree[i]%MOD;
            i--;
        }
    }
    
}
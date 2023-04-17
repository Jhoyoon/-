package gold;

// import java.util.*;
// import java.io.*;

// public class B_2042_구간합세그먼트트리{
//     static long[] tree;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         long K = Long.parseLong(st.nextToken());
//         // 일단 트리 배열을 만들고
//         // 그 다음 배열을 업데이트하고 합을 구한다 입력에 따라
//         int treeH = 0;
//         int length = N;
//         while(length>0){
//             length = length/2;
//             treeH++;
//         }
//         int treeSize = (int)Math.pow(2,treeH+1);
//         tree = new long[treeSize+1];
//         int leftNodeStart = treeSize/2;
//         for(int i=leftNodeStart;i<leftNodeStart+N;i++){
//             tree[i] = Long.parseLong(br.readLine());
//         }
//         treeSet(treeSize-1);
//         for(int i=0;i<M+K;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int a = Integer.parseInt(st.nextToken());
//             int s = Integer.parseInt(st.nextToken());
//             long e = Long.parseLong(st.nextToken());
//             if(a==1){
//                 changeVal(s+leftNodeStart-1,e);
//             }else if(a==2){
//                 s = s+leftNodeStart-1;
//                 e = e+leftNodeStart-1;
//                 System.out.println(getSum(s,e));
//             }

//         }
//     }
    
//     private static void treeSet(int i){
//         while(i>0){
//             tree[i/2] = tree[i/2]+tree[i];
//             i--;
//         }
//     }
//     private static void changeVal(int index,long value){
//         long diff = value - tree[index];
//         while(index>0){
//             tree[index] = tree[index] +diff;
//             index = index/2;
//         }
//     }
//     private static long getSum(int s,long e){
//         long partSum = 0;
//         while(s<=e){
//             if(s%2 == 1) partSum = partSum + tree[s];
//             if(e%2 == 0) partSum = partSum + tree[(int)e];
//             s = (s+1)/2;
//             e = (e-1)/2;
//         }
//         return partSum;

//     }
// }

import java.io.*;
import java.util.*;

public class B_2042_구간합세그먼트트리{
    static long[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        int treeH = 0;
        int length = N;
        while(length>0){
            length = length/2;
            treeH++;
        }
        int treeSize = (int)Math.pow(2,treeH+1);
        int leafNodestart = treeSize/2;
        tree = new long[treeSize+1];
        for(int i=leafNodestart;i<N+leafNodestart;i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        treeSet(treeSize-1);
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a==1){
                changeVal(s+leafNodestart-1,e);
            }else if(a==2){
                System.out.println(getSum(s+leafNodestart-1,e+leafNodestart-1));
            }
        }

    }
    private static void changeVal(int index,long value){
        long diff = value - tree[index];
        while(index>0){
            tree[index] = tree[index]+diff;
            index = index/2;
        }
    }
    private static long getSum(int s,long e){
        long partSum = 0;
        while(s<=e){
            if(s%2 == 1) partSum = partSum + tree[s];
            if(e%2 == 0) partSum = partSum + tree[(int)e];
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return partSum;
    }
    private static void treeSet(int i){
        while(i>1){
            tree[i/2] = tree[i/2]+tree[i];
            i--;
        }
    }
}
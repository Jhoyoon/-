package baekjun.gold;
import java.io.*;
import java.util.*;

public class B_2042_구간합세그먼트트리{
    static long[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        tree = new long[N+1];
        int length = N;
        int treeH = 0;
        while(length>0){
            length = length/2;
            treeH++;
        }
        int treeSize = (int)Math.pow(2,treeH+1);
        int leafStartNode = treeSize/2;
        tree = new long[treeSize+1];
        for(int i=leafStartNode;i<N+leafStartNode;i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a  == 1){
                changeVal(s+leafStartNode-1,e);
            }else if(a == 2){
                sb.append(getSum(s+leafStartNode-1,e+leafStartNode-1)+"\n");
            }
        }
        System.out.print(sb.toString());
    }
    private static long getSum(int s,long e){
        long partSum = 0;
        while(e>=s){
            if(s%2 == 1) partSum = partSum+tree[s];
            if(e%2 == 0) partSum = partSum + tree[(int)e];
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return partSum;
    }
    private static void changeVal(int index,long value){
        long diff = value - tree[index];
        while(index>0){
            tree[index] = tree[index]+diff;
            index = index/2;
        }

    }
    private static void setTree(int i){
        while(i>1){
            tree[i/2] = tree[i]+tree[i/2];
            i--;
        }
    }
}
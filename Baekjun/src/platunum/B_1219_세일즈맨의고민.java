package platunum;

import java.util.*;
import java.io.*;
public class B_1219_세일즈맨의고민 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node1219[] edges = new Node1219[M];
        long[] citymoney = new long[N];
        long[] sol = new long[N];
        Arrays.fill(sol,Long.MIN_VALUE);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[i] = new Node1219(s, e, t);
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            citymoney[i] = Long.parseLong(st.nextToken());
        }
        sol[start] = citymoney[start];
        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                Node1219 now = edges[j];
                if(sol[now.start] != Integer.MAX_VALUE && sol[now.end]<sol[now.start]+citymoney[now.end]-now.money) sol[now.end] = sol[now.start]+citymoney[now.end]-now.money;
            }
        }
        boolean sw = false;
        for(int i=0;i<M;i++){
            Node1219 now = edges[i];
                if(sol[now.start] != Integer.MAX_VALUE && sol[now.end]<sol[now.start]+citymoney[now.end]-now.money) sw = true;
        }
        if(!sw){
            if(sol[end] != Integer.MAX_VALUE) System.out.println(sol[end]);
            else System.out.println("gg");
            
        }else{
            System.out.println("Gee");
        }

    }
}

class Node1219{
    int start;
    int end;
    int money;
    Node1219(int start,int end,int money){
        this.start = start;
        this.end = end;
        this.money = money;
    }
}
package platunum;


import java.util.*;
import java.io.*;
public class B_1219_세일즈맨의고민{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge1219[] edges = new Edge1219[M];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            edges[i] = new Edge1219(s, e, m);
        }
        long[] money = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            money[i] = Long.parseLong(st.nextToken());
        }
        long[] sol = new long[N];
        Arrays.fill(sol,Long.MIN_VALUE);
        sol[start] = money[start];
        for(int i=0;i<=N+100;i++){
            for(int j=0;j<M;j++){
                // 엣지 리스트를 싸그리 돌면서 조건에 해당하면 엣지 리스트를 업데이트 해준다.
                Edge1219 now = edges[j];
                if(sol[now.start] == Long.MIN_VALUE) continue;
                else if(sol[now.start] == Long.MAX_VALUE) sol[now.end] = Long.MAX_VALUE;
                else if(sol[now.end] < sol[now.start]+money[now.end]-now.price){
                    sol[now.end] = sol[now.start]+money[now.end]-now.price;
                    if(i>= N-1) sol[now.end] = Long.MAX_VALUE;
                }
            }
        }
        if(sol[end]==Long.MIN_VALUE) System.out.println("gg");
        else if(sol[end] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(sol[end]);
    }
}

class Edge1219{
    int start;
    int end;
    int price;
    Edge1219(int start,int end,int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
}
package platinum;

import java.util.*;
import java.io.*;

public class B_1854_K번째최단경로{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Node1854>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        PriorityQueue<Integer>[] p = new PriorityQueue[N+1];
        for(int i=1;i<=N;i++){
            p[i] = new PriorityQueue<>(K,(o1,o2)->{
                return o2-o1;
            });
        }
        // 데이터 입력 다 받음
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node1854(e, v));
        }
        PriorityQueue<Node1854> pq = new PriorityQueue<>();
        pq.add(new Node1854(1, 0));
        p[1].add(0);

        while(!pq.isEmpty()){
            Node1854 now = pq.poll();
            for(Node1854 i : arr[now.node]){
                if(p[i.node].size()<K){
                    p[i.node].add(now.cost+i.cost);
                    pq.add(new Node1854(i.node,i.cost+now.cost));
                }else if(p[i.node].peek()>now.cost+i.cost){
                    p[i.node].poll();
                    p[i.node].add(now.cost+i.cost);
                    pq.add(new Node1854(i.node, i.cost+now.cost));
                }
            }
        }
        StringBuffer sb  =new StringBuffer();
        for(int i=1;i<=N;i++){
            if(p[i].size()<K) sb.append(-1+"\n");
            else  sb.append(p[i].poll()+"\n");
        }
        System.out.print(sb.toString());
    }
}

class Node1854 implements Comparable<Node1854>{
    int node;
    int cost;
    Node1854(int node,int cost){
        this.node  = node;
        this.cost = cost;
    }
    public int compareTo(Node1854 e){
        return this.cost - e.cost;
    }
}
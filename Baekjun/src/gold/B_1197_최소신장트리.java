package gold;
import java.util.*;
import java.io.*;
public class B_1197_최소신장트리{
    static int[] parent;
    static PriorityQueue<Edge1197> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        q = new PriorityQueue<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            q.add(new Edge1197(s, e, p));
        }
        int count=0;
        int result = 0;
        while(count<N-1){
            Edge1197 now = q.poll();
            if(find(now.start) != find(now.end)){
                union(now.start,now.end);
                result = result + now.price;
                count++;
            }
        }
        System.out.print(result);
    }
    private static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a>b) parent[a] = b;
            else parent[b] =a;
        }
    }
}




class Edge1197 implements Comparable<Edge1197>{
    int start;
    int end;
    int price;
    Edge1197(int start,int end,int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public int compareTo(Edge1197 n){
        return this.price - n.price;
    }
}
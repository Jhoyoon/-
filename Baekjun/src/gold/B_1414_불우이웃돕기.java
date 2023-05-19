package gold;
import java.io.*;
import java.util.*;
public class B_1414_불우이웃돕기{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }
        PriorityQueue<Edge> q = new PriorityQueue<>((o1,o2)->{
            return o1.value - o2.value;
        });
        int sum = 0;
        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                int tmp = 0;
                if(c[j] >='a' && c[j]<='z'){
                    tmp = c[j]-'a'+1;
                }else if(c[j] >='A' && c[j] <='Z'){
                    tmp = c[j]-'A'+27;
                }
                sum = sum + tmp;
                if(i != j && tmp != 0) q.add(new Edge(i,j,tmp));
            }
        }
        // 아 최소신장 트리에서 최솟값을 찾아내는건 결국 우선순위큐구나
        // 가장 작은걸 먼저 더하면서 사이클을 검사하니까!
        int count = 0;
        int result = 0;
        while(!q.isEmpty()){
            Edge now = q.poll();
            if(find(now.s) != find(now.e)){
                union(now.s,now.e);
                count++;
                result = result + now.value;
            }
        }
        if(count == N-1) System.out.println(sum - result);
        else System.out.println(-1);
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a>b) parent[a] = b;
            else parent[b] = a;
        }
    }
    private static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
    static class Edge{
        int s;
        int e;
        int value;
        Edge(int s,int e,int value){
            this.s = s;
            this.e = e;
            this.value = value;
        }
    }
}
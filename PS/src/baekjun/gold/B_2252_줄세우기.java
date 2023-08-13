package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_2252_줄세우기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        int[] indegree = new int[node+1];
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            indegree[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=node;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int i : arr[now]){
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        System.out.println(sb.toString());
    }
}
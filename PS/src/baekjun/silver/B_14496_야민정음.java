package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_14496_야민정음 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int[] distance = new int[node+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[s] = 0;
        Queue<Integer> q=  new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                if(distance[i] > distance[now]+1){
                    distance[i] = distance[now]+1;
                    q.add(i);
                }
            }
        }
        if(distance[e] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(distance[e]);
        }
        
    }
}

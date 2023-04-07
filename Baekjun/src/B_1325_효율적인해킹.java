

import java.util.*;
import java.io.*;

public class B_1325_효율적인해킹{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] believe;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        believe = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }
        // 여기서 believe 배열을 업데이트
        for(int i=1;i<=N;i++){
            visited=  new boolean[N+1];
            BFS(i);
        }
        int max = 0;
        for(int i=1;i<=N;i++){
            if(believe[i]>max) max = believe[i];
        }
        List<Integer> sol = new ArrayList<>();
        StringBuffer sb  =new StringBuffer();
        for(int i=1;i<=N;i++){
            if(max == believe[i]) sol.add(i);
        }
        if(sol.size()==1) sb.append(sol.get(0));
        else{
            Collections.sort(sol);
            for(int i : sol){
                sb.append(i+" ");
            }
        }
        System.out.print(sb.toString());
    }

    private static void BFS(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i : arr[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    believe[i]++;
                }
            }
        }
    }
}

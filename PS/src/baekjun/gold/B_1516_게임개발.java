package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_1516_게임개발{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        int[] selfBuild = new int[N+1];
        int[] indegree = new int[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st  = new StringTokenizer(br.readLine()," ");
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true){
                int upBuild = Integer.parseInt(st.nextToken());
                if(upBuild == -1) break;
                arr[upBuild].add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int[] result = new int[N+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                indegree[i]--;
                result[i] = Math.max(result[i],result[now]+selfBuild[now]);
                if(indegree[i] == 0) q.offer(i);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            sb.append(result[i] + selfBuild[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}
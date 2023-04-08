package gold;
import java.io.*;
import java.util.*;
public class B_1948_임계경로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> arr = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseArr = new ArrayList<>();
        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(s).add(new dNode(e,v));
            reverseArr.get(e).add(new dNode(s,v));
            indegree[e]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(startDosi);
        int[] result = new int[N+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(dNode next : arr.get(now)){
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode],result[now]+next.value);
                if(indegree[next.targetNode] == 0){
                    q.offer(next.targetNode);
                }
            }
        }
        int resultCount = 0;
        boolean visited[] = new boolean[N+1];
        q = new LinkedList<>();
        q.offer(endDosi);
        visited[endDosi] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(dNode next : reverseArr.get(now)){
                if(result[next.targetNode]+next.value == result[now]){
                    resultCount++;
                    if(visited[next.targetNode] == false){
                        visited[next.targetNode]  = true;
                        q.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[endDosi]);
        System.out.println(resultCount);
    }
}

class dNode{
    int targetNode;
    int value;
    dNode(int targetNode,int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}

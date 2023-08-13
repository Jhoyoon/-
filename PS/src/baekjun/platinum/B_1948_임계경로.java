package baekjun.platinum;
import java.io.*;
import java.util.*;
public class B_1948_임계경로{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        // 최장거리 경로라는것은 각 노드들을 어떤 순서로 방문하느냐가 중요하다.
        // 그러므로 최장거리 경로 값을 찾을 때 위상정렬을 사용할수 있다.
        ArrayList<Node>[] arr = new ArrayList[node+1];
        ArrayList<Node>[] reverseArr = new ArrayList[node+1];
        int[] indegree = new int[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
            reverseArr[i] = new ArrayList<>();
        } 
        StringTokenizer st;
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e,value));
            reverseArr[e].add(new Node(s,value));
            indegree[e]++;
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        // 위상정렬 결과를 저장할 배열.시작 도시로부터 최대 거리값을 나타낸다
        int[] result = new int[node+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node i : arr[now]){
                indegree[i.node]--;
                result[i.node] = Math.max(result[i.node],result[now]+i.value);
                if(indegree[i.node] == 0) q.offer(i.node);
            }
        }
        q = new LinkedList<>();
        q.add(end);
        boolean[] visited = new boolean[node+1];
        visited[end] = true;
        int resultCount=0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node i : reverseArr[now]){
                if(result[now] == result[i.node] + i.value){
                    resultCount++;
                    if(!visited[i.node]){
                        q.add(i.node);
                        visited[i.node] = true;
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(resultCount);
    }
    static class Node{
        int node;
        int value;
        Node(int node,int value){
            this.node = node;
            this.value = value;
        }
    }
}
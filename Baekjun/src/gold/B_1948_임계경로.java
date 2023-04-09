 package gold;
// import java.io.*;
// import java.util.*;
// public class B_1948_임계경로 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
//         // 도시의 개수, 도로의 개수(에지의 개수) 입력받음
//         int N = Integer.parseInt(br.readLine());
//         int M = Integer.parseInt(br.readLine());
//         // 정방향 인접 리스트,역방향 인접 리스트.가중치가 있기에 노드를 넣어줌
//         ArrayList<dNode>[] arr = new ArrayList[N+1];
//         ArrayList<dNode>[] reverseArr = new ArrayList[N+1];
        
//         for(int i=1;i<=N;i++){
//             arr[i] = new ArrayList<>();
//             reverseArr[i] = new ArrayList<>();
//         }
//         int[] indegree = new int[N+1]; // 차수 배열 선언
//         //도로의 정보를 입력받음 출발-도착-시간
//         for(int i=0;i<M;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             arr[s].add(new dNode(e,v));
//             // 거꾸로도 입력받음.도착 도시에서 출발해서 출발 도시로 도착
//             reverseArr[e].add(new dNode(s,v));
//             indegree[e]++;
//         }
//         // 출발 도시와 도착 도시 입력받음
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int startDosi = Integer.parseInt(st.nextToken());
//         int endDosi = Integer.parseInt(st.nextToken());
//         // q선언 
//         Queue<Integer> q = new LinkedList<>();
//         // 일반적인 위상정렬과 다르게 startDosi에서 출발
//         q.add(startDosi);
//         // 정답 배열 선언
//         int[] result = new int[N+1];
//         while(!q.isEmpty()){
//             int now = q.poll();
//             for(dNode i : arr[now]){
//                 indegree[i.targetNode]--;
//                 result[i.targetNode] = Math.max(result[i.targetNode],result[now]+i.value);
//                 if(indegree[i.targetNode] == 0){
//                     q.offer(i.targetNode);
//                 }
//             }
//         }
//         int resultCount = 0;
//         boolean visited[] = new boolean[N+1];
//         q = new LinkedList<>();
//         q.offer(endDosi);
//         visited[endDosi] = true;
//         while(!q.isEmpty()){
//             int now = q.poll();
//             for(dNode next : reverseArr[now]){
//                 if(result[next.targetNode]+next.value == result[now]){
//                     resultCount++;
//                     if(visited[next.targetNode] == false){
//                         visited[next.targetNode]  = true;
//                         q.offer(next.targetNode);
//                     }
//                 }
//             }
//         }
//         System.out.println(result[endDosi]);
//         System.out.println(resultCount);
//     }
// }

// class dNode{
//     int targetNode;
//     int value;
//     dNode(int targetNode,int value){
//         this.targetNode = targetNode;
//         this.value = value;
//     }
// }
import java.io.*;
import java.util.*;
public class B_1948_임계경로{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Node1948>[] arr = new ArrayList[N+1];
        ArrayList<Node1948>[] reverseArr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
            reverseArr[i] = new ArrayList<>();
        }
        int[] degree = new int[N+1];
        StringTokenizer st;
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Node1948(e, v));
            reverseArr[e].add(new Node1948(s, v));
            degree[e]++;
        }
        st = new StringTokenizer(br.readLine()," ");
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(startDosi);
        int[] result = new int[N+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node1948 i : arr[now]){
                degree[i.targetnode]--;
                result[i.targetnode] = Math.max(result[i.targetnode],result[now]+i.value);
                if(degree[i.targetnode]==0) q.add(i.targetnode);
            }
        }
        int resultCount = 0;
        q = new LinkedList<>();
        q.add(endDosi);
        boolean[] visited = new boolean[N+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node1948 i : reverseArr[now]){
                if(result[now] == result[i.targetnode]+i.value){
                    resultCount++;
                    if(visited[i.targetnode] == false){
                        visited[i.targetnode] = true;
                        q.add(i.targetnode);
                    }
                }
            }
        }


        System.out.println(result[endDosi]);
        System.out.println(resultCount);
    }
}
class Node1948{
    int targetnode;
    int value;
    Node1948(int targetnode,int value){
        this.targetnode = targetnode;
        this.value = value;
    }
}
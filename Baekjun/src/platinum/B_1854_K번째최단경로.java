package platinum;
import java.io.*;
import java.util.*;
public class B_1854_K번째최단경로{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 우선순위 큐에 경로들을 다 넣는다.우선순위 크기를 K로 설정하면 K번째 최단경로를 
        // 출력할수 있다.
        ArrayList<Node>[] arr = new ArrayList[node+1];
        for(int i=1;i<=node;i++){
            arr[i] = new ArrayList<>();
        }
        PriorityQueue<Integer>[] distance = new PriorityQueue[node+1];
        for(int i=1;i<=node;i++){
            distance[i] = new PriorityQueue<>(K,(o1,o2)->{
                return o2-o1;
            });
        }
        distance[1].add(0);
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e =  Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e,value));
        }
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            return o1.value - o2.value;
        });
        q.add(new Node(1,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            for(Node i : arr[now.node]){
                if(distance[i.node].size() <K){
                    distance[i.node].add(now.value + i.value);
                    q.add(new Node(i.node,now.value+i.value));
                }else if(distance[i.node].peek() > now.value+i.value){
                    distance[i.node].poll();
                    distance[i.node].add(now.value+i.value);
                    q.add(new Node(i.node,now.value+i.value));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=node;i++){
            if(distance[i].size() == K){
                sb.append(distance[i].peek()+"\n");
            }else{
                sb.append(-1+"\n");
            }
        }
        System.out.print(sb.toString());
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
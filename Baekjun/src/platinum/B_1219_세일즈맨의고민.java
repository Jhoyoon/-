package platinum;
import java.io.*;
import java.util.*;
public class B_1219_세일즈맨의고민{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        Edge[] arr = new Edge[edge];
        long[] distance = new long[node];
        // 최대값을 찾아야 하기에 일반적인 벨만포드와 반대로 최솟값을 넣는다
        Arrays.fill(distance,Integer.MIN_VALUE);
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Edge(s,e,value);
        }
        st = new StringTokenizer(br.readLine());
        int[] money = new int[node];
        for(int i=0;i<node;i++){
            money[i] = Integer.parseInt(st.nextToken());
        } 
        distance[start] = money[start];
        // 변형된 벨만포드를 실행한다.우선 반복횟수를 충분히 늘려서 양의 사이클이
        // 모든 연결 노드에 퍼지도록 한다.그 후 양의 사이클에 걸린 노드들을 Max 값으로 넣는다.
        for(int i=0;i<node*100;i++){
            for(int j=0;j<edge;j++){
                Edge now = arr[j];
                if(distance[now.s] == Integer.MIN_VALUE) continue;
                else if(distance[now.s] == Integer.MAX_VALUE) distance[now.e] = Integer.MAX_VALUE;
                else if(distance[now.e] < distance[now.s] - now.value + money[now.e]){
                    distance[now.e] = distance[now.s] - now.value + money[now.e];
                    if(i >= node-1) distance[now.e] = Integer.MAX_VALUE;
                }
            }
        }
        if(distance[end]==Integer.MIN_VALUE) System.out.println("gg");
        else if(distance[end] == Integer.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[end]);

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
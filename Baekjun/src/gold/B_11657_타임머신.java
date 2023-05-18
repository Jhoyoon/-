package gold;
import java.io.*;
import java.util.*;
public class B_11657_타임머신{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        // 엣지 리스트 
        Edge[] arr = new Edge[edge+1];

        // 거리 리스트
        long[] distance = new long[node+1];

        // 출발점 0으로 나머지 무한대로 초기화
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;

        // 엣지리스트 정보 저장
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Edge(s,e,value);
        }
        // 벨만포드 알고리즘 시작
        // 노드 개수 -1만큼 반복해준다. 모든 엣지 리스트를 돌면서 조건에 맞으면 
        // 거리를 업데이트 해준다.
        for(int i=0;i<node-1;i++){
            for(int j=1;j<=edge;j++){
                Edge now = arr[j];
                if(distance[now.s] != Integer.MAX_VALUE && now.value + distance[now.s] < distance[now.e]){
                    distance[now.e] = now.value + distance[now.s];
                }
            }
        }
        // 마지막으로 음수 사이클이 있는지 판단한다.
        boolean find = true;
        for(int i=1;i<=edge;i++){
            Edge now = arr[i];
            if(distance[now.s] != Integer.MAX_VALUE && now.value + distance[now.s] < distance[now.e]){
                find = false;
            }
        }
        StringBuffer sb = new StringBuffer();
        // 음수 사이클이 존재할시 -1만 출력
        // 1번에서 해당 노드까지 도달할 길이 없을시 해당 노드 자리에 -1 출력
        if(find){
            for(int i=2;i<=node;i++){
                if(distance[i] == Integer.MAX_VALUE) sb.append("-1\n");
                else sb.append(distance[i]+"\n");
            }
        }else{
            sb.append("-1\n");
        }
        System.out.print(sb.toString());
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
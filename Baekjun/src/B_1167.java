import java.util.*;
import java.io.*;

public class B_1167{
    // 방문한 여부 판단하는 배열
    static boolean visited[];
    // 거리 저장하는 배열
    static int[] distance;
    // 노드와 노드까지의 거리 저장하는 배열
    static ArrayList<Edge>[] arr;
    public static void main(String[]args){
        Scanner sc  = new Scanner(System.in);
        // 입력값 갯수 저장
        int N = sc.nextInt();
        // 입력값이 1부터 주어지기 때문
        arr = new ArrayList[N+1];
        // 일단 ArrayList를 초기화.내가 선언한 클래스인 Edge로 선언해야 됨.
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<Edge>();
        }
        // 이제 입력값을 받음
        for(int i=0;i<N;i++){
            // 대상 노드
            int S = sc.nextInt();
            // -1이 나올 때 까지 계속 반복하면서 입력값을 받는다.
            while(true){
                // 대상 노드
                int E = sc.nextInt();
                // 만일 입력값이 -1이면 탈출
                if(E==-1) break;
                // 대상 노드까지의 거리
                int V = sc.nextInt();
                // edge 배열에 노드와 거리를 저장한다.
                arr[S].add(new Edge(E,V));
            }
        }
        // 여기까지해서 입력 다 받았음


        // 거리 저장하는 배열 초기화.노드 숫자가 1부터 주어지니까 N+1로 선언
        distance = new int[N+1];
        // 방문 여부 저장하는 배열 초기화.같은 이유로 N+1로 선언
        visited = new boolean[N+1];
        //BFS를 돌려준다.BFS에서 하는건 거리 배열을 업데이트 해주는거임
        BFS(1);

        int Max = 1;
        // 제일 먼 노드를 찾는 과정
        for(int i=2;i<=N;i++){
            if(distance[Max]<distance[i]){
                Max = i;
            }
        }
        // 거리와 방문여부 배열 초기화
        distance  = new int[N+1];
        visited = new boolean[N+1];
        // 가장 먼 노드로 다시 BFS 수행
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int index){
        // 큐로 선언
        Queue<Integer> qu = new LinkedList<Integer>();
        //들어온거 큐에 넣어주고
        qu.add(index);
        //들어왔으니까 방문 했다고 표시해주고
        visited[index]=true;
        // 이제 while문 돌려줘
        while(!qu.isEmpty()){
            // 들어있는거 꺼내고
            int now_node = qu.poll();
            // 들어있는게 edge형의 배열임
            for(Edge i : arr[now_node]){
                // 현재 노드
                int e = i.e;
                // 현재 노드의 거리
                int v = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    qu.add(e);
                    // e라는건 지금 노드에서 목표하는 노드
                    // 
                    distance[e] = distance[now_node]+v;
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;
    public Edge(int e,int value){
        this.e = e;
        this.value = value;
    }
}

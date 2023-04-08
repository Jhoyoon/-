package silver;
import java.util.*;
import java.io.*;

public class B_11724{
    // arraylist형 배열 선언.리스트 배열을 만든다.
    static ArrayList<Integer>[] arr;
    // 이 노드를 방문 했나 안 했나 확인하는 불린형 배열
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //배열들 선언
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        // ArrayList형 배열 초기화.숫자 보기 편하게 하려고 N+1로 선언
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<Integer>();
        }
        // 각각의 ArrayList에 입력값들을 넣어준다.
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        // DFS를 몇번 돌았는지 확인하는 카운트
        int count = 0;
        for(int i=1;i<=N;i++){
            // 해당 노드를 방문한적 없다면
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int a){
        // 해당 노드를 방문한적 있다면 리턴해서 스택 종료
        if(visited[a]) return;
        // 방문했다고 업데이트함
        visited[a] = true;
        // ArrayList에 있는 연결 노드들 전부 DFS에 넣음
        for(int i : arr[a]){
            // 방문한적 없는 노드들만
            if(!visited[i])
            // 방문한적 없는 노드들을 전부 돌게 된다.
                DFS(i);
        }
    }
}

// import java.util.*;
// import java.io.*;

// public class B_11724{
//     static ArrayList<Integer>[] arr;
//     static boolean visited[];
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         arr = new ArrayList[N+1];
//         visited = new boolean[N+1];
//         for(int i=1;i<=N;i++){
//             arr[i] = new ArrayList<>();
//         }

//         for(int i=0;i<M;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             arr[s].add(e);
//             arr[e].add(s);
//         }

//         int count = 0;
//         for(int i=1;i<=N;i++){
//             if(!visited[i]){
//                 count++;
//                 DFS(i);
//             }
//         }
//         System.out.println(count);
//     }

//     private static void DFS(int d){
//         if(visited[d]) return;
//         visited[d]=true;
//         for(int i : arr[d]){
//             // 이게 탐색한적 없는 노드인게 확인되면
//             if(!visited[i]){
//                 DFS(i);
//             }
//         }
//     }
// }
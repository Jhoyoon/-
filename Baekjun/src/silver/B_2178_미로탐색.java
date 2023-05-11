package silver;
import java.io.*;
import java.util.*;
// public class B_2178_미로탐색{
//     static int[] dx = {0,0,-1,1};
//     static int[] dy = {-1,1,0,0};
//     static int[][] arr;
//     static boolean[][] visited;
//     static int N,M;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//         arr = new int[N][M];
//         visited = new boolean[N][M];
//         for(int i=0;i<N;i++){
//             char[] c = br.readLine().toCharArray();
//             for(int j=0;j<M;j++){
//                 arr[i][j] = c[j]-'0';
//             }
//         }
//         BFS(0,0);
//         System.out.println(arr[N-1][M-1]);
//     }
//     private static void BFS(int i,int j){
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[] {i,j});
//         visited[i][j] = true;
//         while(!q.isEmpty()){
//             int[] now = q.poll();
//             for(int k=0;k<4;k++){
//                 int x = now[0] + dx[k];
//                 int y = now[1] + dy[k];
//                 if(x>=0 && y>=0 && x<N && y<M && !visited[x][y] && arr[x][y] != 0){
//                     visited[x][y] = true;
//                     q.add(new int[] {x,y});
//                     arr[x][y]=arr[now[0]][now[1]]+1;
//                 }
//             }
//         }
//     }
// }
public class B_2178_미로탐색{
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] arr;
    static boolean[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                arr[i][j] = c[j]-'0';
            }
        }
        DFS(0,0,1);
        System.out.println(arr[N-1][M-1]);
    }
    private static void DFS(int i, int j, int depth){
        if(i==N-1 && j==M-1){
            arr[i][j] = depth;
            return;
        }
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x>=0 && y>=0 && x<N && y<M && !visited[x][y] && arr[x][y] != 0){
                DFS(x, y, depth+1);
            }
        }
    }
}

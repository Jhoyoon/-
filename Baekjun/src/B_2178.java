// import java.util.*;
// import java.io.*;
// public class B_2178 {
//     static int[] dx = {0,1,0,-1};
//     static int[] dy = {1,0,-1,0};
//     static boolean[][] visited;
//     static int[][] arr;
//     static int N,M;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//         // 미로 값 입력 배열
//         arr= new int[N][M];
//         visited = new boolean[N][M];
//         for(int i=0;i<N;i++){
//             st = new StringTokenizer(br.readLine());
//             String line = st.nextToken();
//             for(int j=0;j<M;j++){
//                 arr[i][j]=line.charAt(j)-'0';
//             }
//         }
//         BFS(0,0);
//         System.out.println(arr[N-1][M-1]);        
//     }
    
//     private static void BFS(int i,int j){
//         // i,j 형태로 이루어진 배열이기에 큐에도 int 배열형을 넣는다
//         Queue<int[]> qu = new LinkedList<>();
//         // 큐에 좌표 배열을 일단 넣어줌
//         qu.offer(new int[] {i,j});
//         //방문했다는거 표시함
//         visited[i][j]=true;
//         // 넣어주고 검사하고 다시 넣고 반복

//         while(!qu.isEmpty()){
//             int now[] = qu.poll();
//             for(int k=0;k<4;k++){
//                 int x = now[0]+dx[k];
//                 int y = now[1]+dy[k];
//                 if(x>=0 && y>=0 && x<N && y<M){
//                     if(!visited[x][y] && arr[x][y]!=0){
//                         visited[x][y]=true;
//                         arr[x][y]=arr[now[0]][now[1]]+1;
//                         qu.add(new int[]{x,y});
//                     }
//                 }
//             }
//         }
//     }
// }

import java.util.*;
import java.io.*;

public class B_2178{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int[][] arr;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited = new boolean[N][M];
        // 입력 완료
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }
        BFS(0,0);
        System.out.println(arr[N-1][M-1]);
    }   
    private static void BFS(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0;k<4;k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                if(x>=0 && y>=0 && x<N && y<M){
                    if(!visited[x][y] && arr[x][y]!=0){
                        visited[x][y]=true;
                        arr[x][y]=arr[now[0]][now[1]]+1;
                        q.add(new int[] {x,y});
                    }
                }
            } 
        }
    }
}
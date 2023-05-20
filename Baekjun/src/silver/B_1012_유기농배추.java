package silver;
import java.io.*;
import java.util.*;
public class B_1012_유기농배추{
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int baechu = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i=0;i<baechu;i++){
                st = new StringTokenizer(br.readLine()," ");
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                map[n][m] = 1;
            }
            visited = new boolean[N][M];
            count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] != 0 && !visited[i][j]){
                        BFS(i,j);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.print(sb.toString());

    }
    private static void BFS(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0;k<4;k++){
                int y = now[0]+dy[k];
                int x = now[1]+dx[k];
                if(x >= 0 && x<M && y>= 0 && y < N){
                    if(map[y][x] != 0 && !visited[y][x]){
                        q.add(new int[]{y,x});
                        visited[y][x] = true;
                    }
                }
            }
        }
    }
    private static void DFS(int i,int j){
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int y = i + dy[k];
            int x = j + dx[k];
            if(x >= 0 && x< M && y>=0 && y <N){
                if(map[y][x] !=0 && !visited[y][x]){
                    DFS(y,x);
                }
            }
        }
    }   
}
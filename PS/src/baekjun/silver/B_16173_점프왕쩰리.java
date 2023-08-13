package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_16173_점프왕쩰리{
    static boolean find;
    static boolean[][] visited;
    static int[][] map;
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<size;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find = false;
        visited = new boolean[size][size];
        BFS(0,0);
        if(find) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
    private static void BFS(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]= true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int first = now[0];
            int second = now[1];
            int jump = map[first][second];
            if(jump == -1){
                find = true;
                break;
            }
            if(first+jump >= 0 && first+jump <size && !visited[first+jump][second]){
                q.add(new int[]{first+jump,second});
                visited[first+jump][second] = true;
            }
            if(second+jump>=0 && second+jump < size && !visited[first][second+jump]){
                q.add(new int[]{first,second+jump});
                visited[first][second+jump] = true;
            }
        }

    }
    private static void DFS(int i,int j){
        visited[i][j]= true;
        int jump = map[i][j];
        if(jump == -1){
            find = true;
            return;
        }
        if(j+jump >=0 && j+jump<size && !visited[i][j+jump]){
            DFS(i,j+jump);
        } 
        if( i+jump >=0 && i+jump<size && !visited[i+jump][j]){
            DFS(i+jump,j);
        }
    }
}
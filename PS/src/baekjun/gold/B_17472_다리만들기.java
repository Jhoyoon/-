package baekjun.gold;
import  java.io.*;
import  java.util.*;

public class B_17472_다리만들기{
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static int[] parent;
    static int[][] map;
    static int N,M,sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist;
    static PriorityQueue<int []> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sNum = 1;
        sumlist = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != 0 && !visited[i][j] ){
                    BFS(i,j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }

    }
    private static void BFS(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i,j};
        q.add(start);
        mlist.add(start);
        visited[i][j]=true;
        map[i][j]=sNum;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            for(int d=0;d<4;d++){
                int tempR = dr[d];
                int tempC = dc[d];
                while(r+tempR >=0 && r+tempR <N && c+tempC >=0 && c+tempC<M){
                    if(!visited[r+tempR][c+tempC] && map[r+tempR][c+tempC]!=0){
                    }
                }
            }
        }
    }
}
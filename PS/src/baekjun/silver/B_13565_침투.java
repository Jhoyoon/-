package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_13565_침투 {
    static int H,W;
    static boolean[][] visited;
    static int[][] arr;
    static boolean find;
    static int[] dh = {0,0,-1,1};
    static int[] dw = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        for(int i=0;i<H;i++){
            char[] c=  br.readLine().toCharArray();
            for(int j=0;j<W;j++){
                arr[i][j] = c[j]-'0';
            }
        }
        find = false;
        visited = new boolean[H][W];
        for(int i=0;i<W;i++){
            DFS(0,i);
            if(find) break;
        }
        if(find) System.out.println("YES");
        else System.out.println("NO");
    }
    private static void DFS(int h,int w){
        if(h == H-1){
            find = true;
            return;
        }
        for(int i=0;i<4;i++){
            int af_h = h + dh[i];
            int af_w = w + dw[i];
            if(af_h >=0 && af_w >=0 && af_h <H && af_w <W ){
                if(arr[af_h][af_w] != 1 && !visited[af_h][af_w]){
                    visited[af_h][af_w] = true;
                    DFS(af_h,af_w);
                }
            }
        }
    }
    private static void BFS(int h,int w){
        Queue<int[]> q=  new LinkedList<>();
        q.add(new int[]{h,w});
        visited[h][w] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0;i<4;i++){
                int af_h = now[0] + dh[i];
                int af_w = now[1] + dw[i];
                if(af_h >= 0 && af_w >= 0 && af_h <H && af_w < W){
                    if(!visited[af_h][af_w] && arr[af_h][af_w] != 1){
                        if(af_h == H -1){
                            find = true;
                            break;
                        }
                        visited[af_h][af_w]=true;
                        q.add(new int[]{af_h,af_w});
                    }
                }
            }
        }
    }
}

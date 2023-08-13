package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_11123_양한마리 {
    static boolean[][] visited;
    static int[][] arr;
    static int count;
    static int H,W;
    static int[] dh = {0,0,-1,1};
    static int[] dw = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new int[H][W];
            visited = new boolean[H][W];
            count = 0;
            for(int i=0;i<H;i++){
                char[] c=  br.readLine().toCharArray();
                for(int j=0;j<W;j++){
                    if(c[j] == '#') arr[i][j]=1;
                    else arr[i][j] = 0;
                }
            }
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        DFS(i,j);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.print(sb.toString());
    }
    private static void DFS(int i,int j){
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int af_dh = i+dh[k];
            int af_dw = j+dw[k];
            if(af_dh >=0 && af_dw >= 0 && af_dh <H && af_dw < W){
                if(arr[af_dh][af_dw] == 1 && !visited[af_dh][af_dw]){
                    DFS(af_dh,af_dw);
                }
            }
        }
    }
    private static void BFS(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0;k<4;k++){
                int af_dh = now[0]+dh[k];
                int af_dw = now[1]+dw[k];
                // 유효성 검사
                if(af_dh >=0 && af_dw >= 0 && af_dh <H && af_dw < W){
                    if(arr[af_dh][af_dw] == 1 && !visited[af_dh][af_dw]){
                        visited[af_dh][af_dw] = true;
                        q.add(new int[]{af_dh,af_dw});
                    }
                }
            }
        }
    }
}

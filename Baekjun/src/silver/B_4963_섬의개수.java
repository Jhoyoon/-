package silver;
import java.io.*;
import java.util.*;
public class B_4963_섬의개수 {
    static ArrayList<Integer> answer;
    static int[][] arr;
    static int[] dw = new int[]{0,0,-1,1,-1,1,1,-1};
    static int[] dh = new int[]{-1,1,0,0,-1,-1,1,1};
    static boolean[][] visited;
    static int w,h;
    public static void main(String[] args) throws IOException{
        answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0){
                break;
            }
            arr = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<w;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        BFS(i,j);
                        count++;
                    }
                }
            }
            answer.add(count);
        }
        StringBuffer sb = new StringBuffer();
        for(int i : answer){
            sb.append(i+"\n");
        }
        System.out.print(sb.toString());
    }
    private static void DFS(int i,int j){
        visited[i][j] = true;
        for(int k=0;k<8;k++){
            int af_dh = i + dh[k];
            int af_dw = j+dw[k];
            // 유효성 검사
            if(af_dh >=0 && af_dw >=0 && af_dh <h && af_dw < w){
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
            for(int k=0;k<8;k++){
                int af_dh=now[0]+dh[k];
                int af_dw=now[1]+dw[k];
                if(af_dh >=0 && af_dw >=0 && af_dh <h && af_dw < w){
                    if(arr[af_dh][af_dw] == 1 && !visited[af_dh][af_dw]){
                        visited[af_dh][af_dw] = true;
                        q.add(new int[]{af_dh,af_dw});
                    }
                }
            }
        }
    }
}

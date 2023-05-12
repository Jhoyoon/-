package silver;
import java.io.*;
import java.util.*;
// public class B_1388_바닥장식{
// 	static int[] dx = {-1,1,0,0};
// 	static int[] dy = {0,0,-1,1};
// 	static int N,M;
// 	public static void main(String[] args) throws IOException{
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st = new StringTokenizer(br.readLine()," ");
// 		int N = Integer.parseInt(st.nextToken());
// 		int M = Integer.parseInt(st.nextToken());
// 		char[][] c = new char[N][M];
// 		for(int i=0;i<N;i++){
// 			c[i] = br.readLine().toCharArray();
// 		}
// 		int count = 0;
// 		boolean find = true;
// 		for(int i=0;i<N;i++){
// 			for(int j=0;j<M;j++){
// 				if(c[i][j] == '-' && find){
// 					count++;
// 					find = false;
// 				}else if(c[i][j] =='|'){
// 					find = true;
// 				}
// 			}
// 			find = true;
// 		}
// 		for(int j=0;j<M;j++){
// 			for(int i=0;i<N;i++){
// 				if(c[i][j] == '|' && find){
// 					count++;
// 					find = false;
// 				}else if(c[i][j] =='-'){
// 					find = true;
// 				}
// 			}
// 			find = true;
// 		}
// 		System.out.println(count);
// 	}
// }

//  public class B_1388_바닥장식{
//     static int[] dx = {0, 1};
//     static int[] dy = {1, 0};
//     static int N, M;
//     static char[][] arr;
//     static boolean[][][] visited;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//         arr = new char[N][M];
//         visited = new boolean[2][N][M];
//         for(int i=0;i<N;i++){
//             arr[i] = br.readLine().toCharArray();
//         }
//         int count = 0;
//         for(int i=0;i<N;i++){
//             for(int j=0;j<M;j++){
//                 if(arr[i][j] == '-' && !visited[0][i][j]){
//                     DFS(i, j, 0);
//                     count++;
//                 }
//                 if(arr[i][j] == '|' && !visited[1][i][j]){
//                     DFS(i, j, 1);
//                     count++;
//                 }
//             }
//         }
//         System.out.println(count);
//     }

//     private static void DFS(int i, int j, int dir){
//         visited[dir][i][j] = true;
//         int x = i + dx[dir];
//         int y = j + dy[dir];
//         if(x>=0 && y>=0 && x<N && y<M && arr[x][y] == arr[i][j] && !visited[dir][x][y]){
//             DFS(x, y, dir);
//         }
//     }
// }
public class B_1388_바닥장식{
    static char[][] c;
    static boolean[][][] visited;
    static int N,M;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        c = new char[N][M];
        visited = new boolean[2][N][M];
        for(int i=0;i<N;i++){
            c[i] = br.readLine().toCharArray();
        }
        int count =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(c[i][j] == '-' && !visited[0][i][j]){
                    DFS(i,j,0);
                    count++;
                }
                if(c[i][j] == '|' && !visited[1][i][j]){
                    DFS(i,j,1);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static void DFS(int i,int j,int d){
        visited[d][i][j] = true;
        int x = i + dx[d];
        int y = j + dy[d];
        if(x>= 0 && y>= 0 && x<N&&y<M&& c[x][y] == c[i][j] && !visited[d][x][y]){
            DFS(x,y,d);
        }
    }
}
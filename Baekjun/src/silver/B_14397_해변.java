package silver;
import java.io.*;
import java.util.*;

public class B_14397_해변 {
    // row가 홀수냐 짝수냐에 따라서 column의 값이 달라진다
    // 홀수일 때 [-1,0] [-1,1] [0,-1] [0,1] [1,0] [1,1]
    // 짝수일 때 [-1,-1] [-1,0] [0,-1] [0,1] [1,-1] [1,0]
    static int[] dr = {-1, -1, 0, 0, 1, 1};
    static int[] dc_odd = {0, 1, -1, 1, 0, 1};
    static int[] dc_even = {-1, 0, -1, 1, -1, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                // .은 물
                if(c[j] == '.') map[i][j] = 0;
                // #은 땅
                else if(c[j]=='#') map[i][j] = 1;
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                // 물일경우
                if(map[i][j] == 0) continue;
                for(int k=0;k<6;k++){
                    int tmpr = i + dr[k];
                    // row가 짝수일 때
                    int tmpc; 
                    if(i%2 == 0){
                        tmpc = j + dc_even[k]; 
                    // row가 홀수일 때
                    }else{
                        tmpc = j + dc_odd[k];
                    }
                    if(tmpr >= 0 && tmpc >=0 && tmpr <N && tmpc <M){
                        if(map[tmpr][tmpc] == 0) count++;
                    }
                }
            }
        }
        System.out.println(count);

    }
}

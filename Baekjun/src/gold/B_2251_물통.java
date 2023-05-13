package gold;
import java.io.*;
import java.util.*;
public class B_2251_물통{
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,1,2,2,0,0};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int now[] = new int[3];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];
        BFS();
        for(int i=0;i<answer.length;i++){
            if(answer[i]) System.out.println(i+" ");
        }
    }
    private static void BFS(){
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0,0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while(!q.isEmpty()){
            AB p = q.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2]-A-B;
            for(int k=0;k<6;k++){
                int[] next = {A,B,C};
                next[receiver[k]] += next
            }
        }
    }
    static class AB{
        int A;
        int B;
        AB(int A,int B){
            this.A = A;
            this.B = B;
        }
    }
}
package gold;
import java.io.*;
import java.util.*;
// ** 개어렵다. 물을 옮기는 모든 경우의 수를 떠올리는게 쉽지 않다
public class B_2251_물통{
    static int[] receiver = {0,0,1,1,2,2};
    static int[] sender = {2,2,0,0,1,1};
    static boolean[][] visited;
    static ArrayList<Integer> answer;
    static int[] now;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        now = new int[3];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new ArrayList<>();
        BFS();
        Collections.sort(answer);
        StringBuffer sb = new StringBuffer();
        for(int i : answer){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
    private static void BFS(){
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0,0));
        visited[0][0] = true;
        answer.add(now[2]);
        while(!q.isEmpty()){
            AB p = q.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2]-A-B;
            for(int i=0;i<6;i++){
                int[] next = {A,B,C};
                next[receiver[i]] = next[receiver[i]] + next[sender[i]];
                next[sender[i]] = 0;
                if(next[receiver[i]] > now[receiver[i]]){
                    next[sender[i]] = next[receiver[i]]-now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0],next[1]));
                    if(next[0]==0) answer.add(next[2]);
                }
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
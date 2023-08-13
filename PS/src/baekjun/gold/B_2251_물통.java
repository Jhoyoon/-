package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_2251_물통{
    // 물을 따르는 물통 인덱스
    static int[] sender = {0,0,1,1,2,2};
    // 물이 따라지는 물통 인덱스
    static int[] receiver = {2,2,0,0,1,1};
    // 방문 배열.0,1 물통 양을 통해서 이미 나온적 있는 경우의 수인지 체크한다
    static boolean[][] visited;
    // 각 물통 최대값
    static int[] now = new int[3];
    // 정답값을 저장할 어레이리스트
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 최대값이 저장되는 now 배열
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        // 모든 경우의 수를 BFS로 탐색한다
        result = new ArrayList<>();
        //물의 최대양이 200이라 201로 만듬
        visited = new boolean[201][201];
        DFS(0,0);
        // 정답 배열을 오름차순 정렬
        Collections.sort(result);
        StringBuffer sb = new StringBuffer();
        for(int i : result){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
    private static void BFS(){
        // ab의 현재 물 양을 큐에 저장한다
        Queue<AB> q = new LinkedList<>();
        // 초기 상태는 ab 0;
        q.add(new AB(0,0));
        // 0,0 방문했음
        visited[0][0] = true;
        // 초기 상태는 항상 a가 0이기에 정답배열에 3번째 물통 최대값을 저장해줌
        result.add(now[2]);
        while(!q.isEmpty()){
            AB p = q.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2]-A-B;
            for(int k=0;k<6;k++){
                int[] next = {A,B,C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;
                if(next[receiver[k]] > now[receiver[k]]){
                    next[sender[k]] = next[receiver[k]]-now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]]; 
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0],next[1]));
                    if(next[0] ==0) result.add(next[2]);
                }
            }
        }
    }
    private static void DFS(int a,int b){
        visited[a][b] = true;
        int A = a;
        int B = b;
        int C = now[2] -A -B;
        if(A == 0) result.add(C);
        for(int i=0;i<6;i++){
            int[] next = {A,B,C};
            next[receiver[i]] = next[receiver[i]] + next[sender[i]];
            next[sender[i]] = 0;
            if(next[receiver[i]] > now[receiver[i]]){
                next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                next[receiver[i]] = now[receiver[i]];
            }
            if(!visited[next[0]][next[1]]){
                DFS(next[0],next[1]);
            }
        }
    }
    // ab의 물양
    static class AB{
        int A;
        int B;
        AB(int A,int B){
            this.A = A;
            this.B = B;
        }
    }
}
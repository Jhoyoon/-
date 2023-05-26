package silver;
import java.io.*;
import java.util.*;
public class B_17204_죽음의게임{
    static int target,answer,node;
    static boolean find;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        node = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[node];
        find = false;
        answer = 0;
        for(int i=0;i<node;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        DFS(0,0);
        if(find) System.out.println(answer);
        else System.out.println(-1);
    }
    private static void DFS(int n,int count){
        int now = arr[n];
        if(now == target){
            answer = count+1;
            find = true;
            return;
        }
        if(count == node) return;
        DFS(now,count + 1);

    }
    private static void BFS(int n){
        // 숫자를 외치면서 쏘고 그 외친 숫자가 지정한 숫자랑 똑같으면 그 사람이 술래
       Queue<Integer> q = new LinkedList<>();
       q.add(0);
       int count = 0;
       while(!q.isEmpty()){
        // now에 해당하는 사람이 외치는 숫자는 
            int now = arr[q.poll()];
            count++;
            if(now == target){
                // 반드시 count를 넣어야 함.이 문제에서 찾는건 몇번 쐈을 때 찾는 노드가 됐는지임
                answer = count;
                find = true;
                break;
            }
            if(count == node) break;
            q.add(now);
       }
    }
}
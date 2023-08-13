package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_21316_스피카 {
    public static void main(String[] args) throws IOException{
        // 스피카는 연결된 별이 3개이고 그 3개의 별들의 연결차수가 1,2,3인 별이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>[] arr = new ArrayList[13];
        for(int i=1;i<=12;i++){
            arr[i] = new ArrayList<>();
        }
        // 12개의 간선을 입력받는다
        for(int i=1;i<=12;i++){
            StringTokenizer st  =new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        int ans = 0;
        // 12개의 별들을 돌면서
        for(int i=1;i<=12;i++){
            int[] connect = new int[3];
            // 연결된 별이 3개일경우
            if(arr[i].size() == 3){
                // 연결된 3개의 별들의 연결차수를 구한다.
                connect[0]=arr[arr[i].get(0)].size();
                connect[1]=arr[arr[i].get(1)].size();
                connect[2]=arr[arr[i].get(2)].size();
                // 오름차순으로 나오도록 정렬하고
                Arrays.sort(connect);
                // 1,2,3일경우 정답
                if(connect[0] == 1 && connect[1] == 2 && connect[2] == 3){
                    ans = i;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}

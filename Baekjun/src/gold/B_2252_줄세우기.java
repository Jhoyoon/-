package gold;
import java.io.*;
import java.util.*;
public class B_2252_줄세우기{
    static ArrayList<Integer>[] arr;
    static int[] sortArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int num = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        sortArr = new int[num+1];
        arr = new ArrayList[num+1];
        for(int i=1;i<=num;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            sortArr[e]++;
        }
        Queue<Integer> q=  new LinkedList<>();
        for(int i=1;i<=num;i++){
            if(sortArr[i] == 0){
                q.add(i);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int i : arr[now]){
                sortArr[i]--;
                if(sortArr[i] == 0) q.add(i);
            }
        }
        System.out.println(sb.toString());
    }
}
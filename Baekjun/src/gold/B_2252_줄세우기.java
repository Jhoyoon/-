package gold;
// import java.io.*;
// import java.util.*;

// public class B_2252_줄세우기{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();
//         ArrayList<Integer>[] arr = new ArrayList[N+1];
//         for(int i=1;i<=N;i++){
//             arr[i] = new ArrayList<>();
//         }
//         int[] degree = new int[N+1];
//         for(int i=0;i<M;i++){
//             int s = sc.nextInt();
//             int e = sc.nextInt();
//             arr[s].add(e);
//             degree[e]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=1;i<=N;i++){
//             if(degree[i]==0) q.add(i);
//         }
//         List<Integer> sol = new ArrayList<>();
//         while(!q.isEmpty()){
//             int now = q.poll();
//             sol.add(now);
//             for(int i : arr[now]){
//                 degree[i]--;
//                 if(degree[i]==0) q.add(i);
//             }
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i : sol){
//             sb.append(i+" ");
//         }
//         System.out.print(sb.toString());
//     }
// }

import java.util.*;
import java.io.*;

public class B_2252_줄세우기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        int[] degree = new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            degree[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(degree[i]==0) q.add(i);
        }
        List<Integer> sol = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.poll();
            sol.add(now);
            for(int i : arr[now]){
                degree[i]--;
                if(degree[i]==0) q.add(i);
            }
        }
        StringBuffer sb  = new StringBuffer();
        for(int i: sol){
            sb.append(i+" ");
        }
        System.out.print(sb.toString());

    }
}
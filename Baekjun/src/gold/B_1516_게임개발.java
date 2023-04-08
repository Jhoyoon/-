package gold;
// import java.io.*;
// import java.util.*;

// public class B_1516_게임개발 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         ArrayList<Integer>[] arr = new ArrayList[N+1];
//         for(int i=1;i<=N;i++){
//             arr[i]  = new ArrayList<>();
//         }
//         int[] indegree = new int[N+1];
//         int[] selfBuild = new int[N+1];
//         // 그냥 입력 데이터를 전부 입력 받은거임.정렬 배열도 초기화 시키고 짖는 시간도 초기화 
//         // 시키고 인접 리스트도 초기화 시키고
//         for(int i=1;i<=N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             selfBuild[i] = Integer.parseInt(st.nextToken());
//             while(true){
//                 int preTemp = Integer.parseInt(st.nextToken());
//                 if(preTemp == -1) break;
//                 arr[preTemp].add(i);
//                 indegree[i]++;
//             }
//         }

//         Queue<Integer> q = new LinkedList<>();
//         // 0인 애들을 q에 집어넣는다
//         for(int i=1;i<=N;i++){
//             //0이다 = 그래프에서 연결된적이 없다 = 건물들의 최고 조상이다.
//             if(indegree[i]==0){
//                 q.offer(i);
//             }
//         }
//         // 정답 배열 선언
//         int[] result = new int[N+1];
//         while(!q.isEmpty()){
//             int now = q.poll();
//             for(int i : arr[now]){
//                 indegree[i]--;
//                 result[i] = Math.max(result[i],result[now]+selfBuild[now]);
//                 if(indegree[i]==0) q.add(i);
//             }
//         }
//         StringBuffer sb  =new StringBuffer();
//         for(int i=1;i<=N;i++){
//             sb.append(result[i]+selfBuild[i]+"\n");
//         }
//         System.out.print(sb.toString());
//     }
// }

import java.io.*;
import java.util.*;

public class B_1516_게임개발{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<>();
        }
        int[] degree = new int[N+1];
        int[] selfBuild = new int[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==-1) break;
                arr[tmp].add(i);
                degree[i]++;

            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            // 0이다  = 최고조상이다
            if(degree[i]==0) q.add(i);
        }
        int[] result = new int[N+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : arr[now]){
                degree[i]--;
                result[i] = Math.max(result[i],result[now]+selfBuild[now]);
                if(degree[i]==0) q.add(i);
            }
        }
        StringBuffer sb = new StringBuffer();
       for(int i=1;i<=N;i++){
        sb.append(result[i]+selfBuild[i]+"\n");
       }
        System.out.print(sb.toString());

    }
}
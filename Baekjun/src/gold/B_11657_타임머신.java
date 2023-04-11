// package gold;

// import java.io.*;
// import java.util.*;
// public class B_11657_타임머신 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         // 노드와 엣지를 입력 받음
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         // 엣지 리스트 배열 생성.시작 - 도착 - 가중치
//         Node11657[] edges = new Node11657[M];
//         // 거리배열을 무한대로 초기화해준다.
//         long[] distance = new long[N+1];
//         Arrays.fill(distance,Integer.MAX_VALUE);
//         // 엣지 리스트를 초기화해준다.
//         for(int i=0;i<M;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             // 시작 도착 가중치
//             edges[i] = new Node11657(s, e, v);
//         }
//         // 시작점 거리 초기화
//         distance[1] = 0;
//         // 노드보다 하나 적게 반복한다
//         for(int i=1;i<N;i++){
//             // 엣지의 개수 만큼
//             for(int j = 0;j<M;j++){
//                 Node11657 edge = edges[j];
//                 if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start]+edge.time){
//                     distance[edge.end] = distance[edge.start]+edge.time;
//                 }
//             }
//         }
//         boolean mCycle = false;
//         //음수 사이클을 판별하기 위해서 딱 한번만 더한다.
//         for(int i=0;i<M;i++){
//             Node11657 edge = edges[i];
//             if(distance[edge.start]!=Integer.MAX_VALUE && distance[edge.end]>distance[edge.start]+edge.time) mCycle = true; 
//         }
//         if(!mCycle){
//             for(int i=2;i<=N;i++){
//                 if(distance[i]==Integer.MAX_VALUE) System.out.println("-1");
//                 else System.out.println(distance[i]);
//             }
//         }else System.out.println("-1");
//     }

// }

// class Node11657{
//     int start;
//     int end;
//     int time;
//     Node11657(int start,int end,int time){
//         this.start = start ; 
//         this.end = end;
//         this.time = time;
//     }
// }

package gold;
import java.util.*;

import java.io.*;

public class B_11657_타임머신{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        Node11657[] edges = new Node11657[M+1];
        long[] distance = new long[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Node11657(start, end, time);
        }
        // 이제 벨만포드 시작
        distance[1] = 0;
        for(int i=1;i<N;i++){
            for(int j=1;j<=M;j++){
                Node11657 edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end]>distance[edge.start]+edge.time) distance[edge.end] = distance[edge.start]+edge.time;
            }
        }

        // 한번 더 돌려줘
        boolean sw = false;
        for(int i=1;i<=M;i++){
            Node11657 edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end]>distance[edge.start]+edge.time) sw = true;
        }
        StringBuffer sb  =new StringBuffer();
        if(!sw){
            for(int i=2;i<=N;i++){
                if(distance[i] == Integer.MAX_VALUE) sb.append(-1+"\n");
                else sb.append(distance[i]+"\n");
            }
        }else{
            sb.append(-1);
        }
        System.out.print(sb.toString());
    }
}

class Node11657{
    int start;
    int end;
    int time;
    Node11657(int start,int end,int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
package gold;
// import java.util.*;
// import java.io.*;

// public class B_2251_물통{
//     static int[] now;
//     static boolean[][] visited;
//     static boolean[] answer;
//     static int[] receiver = {0,0,1,1,2,2};
//     static int[] sender = {2,2,0,0,1,1};
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st=  new StringTokenizer(br.readLine()," ");
//         now = new int[3];
//         visited = new boolean[201][201];
//         answer = new boolean[201];
//         now[0] = Integer.parseInt(st.nextToken());
//         now[1] = Integer.parseInt(st.nextToken());
//         now[2] = Integer.parseInt(st.nextToken());
//         BFS();
//         StringBuffer sb  =new StringBuffer();
//         for(int i=0;i<201;i++){
//             if(answer[i]) sb.append(i+" ");
//         }
//         System.out.print(sb.toString());
//     }
//     private static void BFS(){
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{0,0});
//         visited[0][0] = true;
//         answer[now[2]] = true;
//         while(!q.isEmpty()){
//             int[] p = q.poll();
//             int A = p[0];
//             int B = p[1];
//             int C = now[2]-A-B;
//             for(int i=0;i<6;i++){
//                 int[] next = {A,B,C};
//                 next[receiver[i]]=next[receiver[i]]+next[sender[i]];
//                 next[sender[i]]=0;
//                 if(next[receiver[i]]>now[receiver[i]]){
//                     next[sender[i]] = next[receiver[i]]-now[receiver[i]]; 
//                     next[receiver[i]] = now[receiver[i]];
//                 }
//                 if(!visited[next[0]][next[1]]){
//                     q.add(new int[]{next[0],next[1]});
//                     visited[next[0]][next[1]]=true;
//                     if(next[0]==0) answer[next[2]] = true;
//                 }
//             }
//         }
//     }
// }

// import java.util.*;
// import java.io.*;

// public class B_2251_물통{
//     static boolean[][] visited;
//     static boolean[] check;
//     static int[] receiver={0,0,1,1,2,2};
//     static int[] sender = {2,2,0,0,1,1};
//     static int[] now;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         now = new int[3];
//         check = new boolean[201];
//         visited = new boolean[201][201];
//         now[0]  = Integer.parseInt(st.nextToken());
//         now[1] = Integer.parseInt(st.nextToken());
//         now[2] = Integer.parseInt(st.nextToken());
//         BFS();
//         StringBuffer sb = new StringBuffer();
//         for(int i=0;i<check.length;i++){
//             if(check[i]) sb.append(i+" ");
//         }
//         System.out.print(sb.toString());
//     }
//     private static void BFS(){
//         Queue<AB> q = new LinkedList<>();
//         q.add(new AB(0,0));
//         visited[0][0] = true;
//         check[now[2]] = true;
//         while(!q.isEmpty()){
//             AB p = q.poll();
//             int A = p.A;
//             int B = p.B;
//             int C = now[2]-A-B;
//            for(int i=0;i<6;i++){
//             int[] next = {A,B,C};
//             next[receiver[i]] += next[sender[i]];
//             next[sender[i]] = 0;
//             if(next[receiver[i]]>now[receiver[i]]){
//                 next[sender[i]] = next[receiver[i]] - now[receiver[i]];
//                 next[receiver[i]] = now[receiver[i]];
//             }
//             if(!visited[next[0]][next[1]]){
//                 visited[next[0]][next[1]] = true;
//                 q.add(new AB(next[0],next[1]));
//                 if(next[0]==0) check[next[2]] = true;
//             }
//            }
//         }

//     }
// }

// class AB{
//     int A;
//     int B;
//     AB(int A,int B){
//         this.A = A;
//         this.B = B;
//     }
// }

import java.util.*;
import java.io.*;

public class B_2251_물통{
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {2,2,0,0,1,1};
    static int[] now;
    static boolean[] answer;
    static boolean[][] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        answer = new boolean[201];
        visited = new boolean[201][201];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        
        BFS();
        StringBuffer sb = new StringBuffer();
       for(int i=0;i<201;i++){
        if(answer[i]) sb.append(i+" ");
       }
        System.out.print(sb.toString());
    }
    private static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        answer[now[2]] = true;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int A = p[0];
            int B = p[1];
            int C = now[2]-A-B;
            for(int i=0;i<6;i++){
                int[] next = {A,B,C};
                next[receiver[i]] = next[receiver[i]]+next[sender[i]];
                next[sender[i]] = 0;
                if(next[receiver[i]]>now[receiver[i]]){
                    next[sender[i]] = next[receiver[i]]-now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]] = true;
                    q.add(new int[]{next[0],next[1]});
                    if(next[0]==0) answer[next[2]] = true;
                }
            }
        }
    }
}
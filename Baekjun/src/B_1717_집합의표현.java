// import java.io.*;
// import java.util.*;

// public class B_1717_집합의표현 {
//     static int[] parent;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         parent = new int[N+1];
//         for(int i=0;i<=N;i++){
//             parent[i] = i;
//         }
        
//         for(int i=0;i<M;i++){
//             st = new StringTokenizer(br.readLine()," ");
//             int question = Integer.parseInt(st.nextToken());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             if(question == 0){ // union 연산
//                 union(a,b);
//             }else{ //find 연산
//                 int a2 = find(a);
//                 int b2 = find(b);
//                 if(a2==b2) System.out.println("yes");
//                 else System.out.println("no");
//             }
//         }
//     }    
//     private static void union(int a,int b){
//         // 대표 노드를 찾아서 연결한다
//         a= find(a);
//         b = find(b);
//         if(a!=b) parent[b] = a;
//     }
//     private static int find(int a){
//         if(a==parent[a]) return a;
//         else{
//             return parent[a] = find(parent[a]);
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class B_1717_집합의표현{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(question==1){
                a=  find(a);
                b= find(b);
                if(a==b) System.out.println("yes");
                else System.out.println("no");
            }else{
                union(a,b);
            }
        }
    }
    private static void union(int a,int b){
        // 대표 노드를 찾는다
        a = find(a);
        b = find(b);
        if(a!=b) parent[a] = b;
    }
    private static int find(int a){
        if(a==parent[a]) return a;
        else{
            return parent[a]=find(parent[a]);
        }
    }
}
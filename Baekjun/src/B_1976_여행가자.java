// import java.io.*;
// import java.util.*;
// public class B_1976_여행가자 {
//     public static int[] parent;
//     public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         int M = sc.nextInt();
//         int[][] city = new int[N+1][N+1];
//         // 도시의 연결 정보를 인접행렬로 입력받음
//         for(int i=1;i<=N;i++){
//             for(int j=1;j<=N;j++){
//                 city[i][j] = sc.nextInt();
//             }
//         }
//         // 연결 루트를 입력받음
//         int[] route = new int[M+1];
//         for(int i=1;i<=M;i++){
//             route[i] = sc.nextInt();
//         };

//         parent = new int[N+1];
//         // 연결 노드 저장소 초기화
//         for(int i=1;i<=N;i++){
//             parent[i]  =i;
//         }
//         // 도시 연결정보 배열을 돌면서 두 도시가 연결되어 있다면 합집합 연산을 한다.
//         for(int i=1;i<=N;i++){
//             for(int j=1;j<=N;j++){
//                 if(city[i][j] == 1) union(i,j);
//             }
//         }
//         // 여행 계획의 첫번째 도시를 가져옴
//         int index = find(route[1]);

//         for(int i=2;i<route.length;i++){
//             if(index!=find(route[i])){
//                 System.out.println("NO");
//                 return;
//             }
//         }
//         System.out.println("YES");
//     }
//     private static void union(int a,int b){
//         a = find(a);
//         b = find(b);
//         if(a!=b){
//             parent[a] = b;
//         }
//     }
//     private static int find(int a){
//         if(a==parent[a]) return a;
//         else{
//             return parent[a]= find(parent[a]);
//         }
//     }  
// }
import java.io.*;
import java.util.*;

public class B_1976_여행가자{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M  = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        // 도시 연결 정보 입력받고
        int[][] city = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 내가 갈 루트 입력받고
        int[] route = new int[M+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=M;i++){
            route[i] = Integer.parseInt(st.nextToken());
        }
        // 연결되어 있으면 합연산 해준다
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(city[i][j]==1) union(i,j);
            }
        }
        // 어느 집합에 속하는지를 반환한다.
        int index = find(route[1]);
        boolean s = true;
        for(int i=2;i<=M;i++){
            if(index!=find(route[i])) s = false;
        }
        if(s) System.out.println("YES");
        else System.out.println("NO");
    }
    private static int find(int a){
        if(a==parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
             if(a>b) parent[a]=b;
             else parent[b]=a;
        }
    }
}
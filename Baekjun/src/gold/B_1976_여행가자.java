package gold;
import java.io.*;
import java.util.*;
public class B_1976_여행가자{
    static int[] parent;
    static int[] route;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        // 경로에 속한 도시들이 전부 같은 집합에 속해있는지만 확인하면 되는 문제임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int route_node = Integer.parseInt(br.readLine());
        parent = new int[node+1];
        for(int i=1;i<=node;i++){
            parent[i] = i;
        }
        route = new int[route_node];
        arr = new int[node+1][node+1];
        StringTokenizer st;
        for(int i=1;i<=node;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=node;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) union(i,j);
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<route_node;i++){
            route[i] = Integer.parseInt(st.nextToken());
        }
        int index = find(route[0]);
        boolean result = true;
        for(int i=1;i<route_node;i++){
            if(index != find(route[i])){
                result = false;
                break;
            }
        }
        if(result) System.out.println("YES");
        else System.out.println("NO");
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a>b) parent[a] = b;
            else parent[b] = a;
        }
    }
    private static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
}
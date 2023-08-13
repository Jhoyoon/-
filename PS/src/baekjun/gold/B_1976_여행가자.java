package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_1976_여행가자{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[node+1][node+1];
        parent = new int[node+1];
        for(int i=1;i<=node;i++){
            parent[i] = i;
        }
        StringTokenizer st;
        for(int i=1;i<=node;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=node;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) union(i,j);
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int[] route = new int[num+1];
        for(int i=1;i<=num;i++){
            route[i] = Integer.parseInt(st.nextToken());
        }
        int result = find(route[1]);
        boolean check = true;
        for(int i=2;i<=num;i++){
            if(result != find(route[i])) check = false;
        }
        if(check) System.out.println("YES");
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
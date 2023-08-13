package baekjun.silver;
import java.io.*;
import java.util.*;
// 확률 계산을 하는 그래프 문제.각 간선을 통과 할 때 마다 기존 확률에서 이 간선의 확률을 곱해주자!
public class B_16502_그녀를찾아서{
    static int time,edge;
    static ArrayList<Node>[] arr = new ArrayList[4];
    static double[] result=new double[4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        time = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
    
        for(int i=0;i<4;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            char s = st.nextToken().charAt(0);
            char e = st.nextToken().charAt(0);
            double value = Double.parseDouble(st.nextToken());
            arr[s-'A'].add(new Node(e-'A',value));
        }
        for(int i=0;i<4;i++){
            DFS(i,0.25,0);
        }
        StringBuffer sb = new StringBuffer();
        for(double i : result){
            sb.append(String.format("%.3f\n", i));
        }
        System.out.print(sb.toString());
    }
    private static void DFS(int node,double p,int count){
        if(count == time){
            result[node] += p*100;
            return;
        }
        for(Node i : arr[node]){
            DFS(i.node,p*i.value,count+1);
        }
    }
    static class Node{
        int node;
        double value;
        Node(int node,double value){
            this.node = node;
            this.value = value;
        }
    }
}
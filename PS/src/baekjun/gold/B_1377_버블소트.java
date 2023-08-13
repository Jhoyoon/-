package baekjun.gold;
import java.io.*;
import java.util.*;
public class B_1377_버블소트{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for(int i=0;i<N;i++){
            arr[i] = new Node(i,Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int minus = arr[i].index - i;
            if(max < minus) max = minus;
        }
        System.out.println(max+1);
    }
    static class Node implements Comparable<Node>{
        int index;
        int value;
        Node(int index,int value){
            this.index= index;
            this.value = value;
        }
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
}
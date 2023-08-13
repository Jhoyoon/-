package baekjun.platinum;
import java.io.*;
import java.util.*;
public class B_11003_최솟값찾기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        Deque<Node> deq = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken());
            while(!deq.isEmpty() && deq.getLast().value > now){
                deq.removeLast();
            }
            deq.addLast(new Node(now,i));
            while(deq.getLast().index - deq.getFirst().index >= M){
                deq.removeFirst();
            }
            sb.append(deq.getFirst().value+" ");
        }
        System.out.println(sb.toString());
    }
    static class Node{
        int value;
        int index;
        Node(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
}
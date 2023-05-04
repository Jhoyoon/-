package silver;
import java.io.*;
import java.util.*;
public class B_11286_절댓값힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            int o1Abs = Math.abs(o1);
            int o2Abs = Math.abs(o2);
            if(o1Abs == o2Abs){
                return o1-o2;
            }else{
                return o1Abs - o2Abs;
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }else{
                pq.add(num);
            }
        }
        System.out.print(sb.toString());
    }
}

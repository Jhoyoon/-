import java.util.*;
import java.io.*;
public abstract class B_1715_카드정렬 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            q.add(arr[i]);
        }
        int sum=0;
        int data1 = 0;
        int data2=0;
        // 카드 묶음을 하나로 만들 때 까지의 비용을 계산하는 것이기에 하나를 남긴다.
        while(q.size()>1){
            data1=q.poll();
            data2=q.poll();
            sum = sum+data1+data2;
            q.add(data1+data2);
        }
        System.out.println(sum);


    }
}

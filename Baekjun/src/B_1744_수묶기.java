import java.util.*;
import java.io.*;

public class B_1744_수묶기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> plusQ = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for(int i=0;i<N;i++){
            if(arr[i]>1){
                plusQ.add(arr[i]);
            }else if(arr[i]<0){
                minusQ.add(arr[i]);
            }else if(arr[i]==1){
                one++;
            }else{
                zero++;
            }
        }
        int sum = 0;
        while(plusQ.size()>1){
            int a = plusQ.remove();
            int b = plusQ.remove();
            sum = sum+a*b;
        }
        if(!plusQ.isEmpty()){
            sum = sum + plusQ.poll();
        }
        while(minusQ.size()>1){
            int a = minusQ.poll();
            int b = minusQ.poll();
            sum = sum +a*b;
        }
        if(!minusQ.isEmpty()){
            if(zero == 0){
                sum = sum + minusQ.poll();
            }
        }
        sum = sum+one;
        System.out.println(sum);
    }
}

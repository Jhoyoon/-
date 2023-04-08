package silver;
import java.io.*;
import java.util.*;

public class B_7568 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node2[] arr = new Node2[N];
        for(int i=0;i<N;i++){
            arr[i] = new Node2(sc.nextInt(),sc.nextInt());
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            int rank = 1;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(arr[i].weight<arr[j].weight && arr[i].height<arr[j].height) rank++;
            }
            sb.append(rank+" ");
        }
        System.out.println(sb.toString());
    }
}

class Node2{
    public int weight;
    public int height;
    Node2(int weight,int height){
        this.weight = weight;
        this.height = height;
    }
}

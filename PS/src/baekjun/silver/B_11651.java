package baekjun.silver;
import java.util.*;
import java.io.*;

public class B_11651 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node3[] arr = new Node3[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i] = new Node3(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr,(o1,o2)->{
            if(o1.y==o2.y) return o1.x-o2.x;
            else return o1.y-o2.y;
        });
        StringBuffer sb = new StringBuffer();
        for(Node3 i : arr){
            sb.append(i.x+" "+i.y+"\n");
        }
        System.out.println(sb.toString());
       
    }
}

class Node3{
    int x;
    int y;
    Node3(int x,int y){
        this.x = x;
        this.y=y;
    }
}
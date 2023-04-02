// import java.util.*;
// import java.io.*;

// public class B_1715_카드정렬{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         PriorityQueue<Integer> q = new PriorityQueue<>();
//         for(int i=0;i<N;i++){
//             q.add(Integer.parseInt(br.readLine()));
//         }
//         int sum = 0;
//         while(q.size()>1){
//             int a = q.poll();
//             int b  =q.poll();
//             sum  = sum+a+b;
//             q.add(a+b);
//         }
//         System.out.println(sum);
//     }
// }

import java.io.*;
import java.util.*;
public class B_1715_카드정렬{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            q.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while(q.size()!=1){
            int a = q.poll();
            int b  =q.poll();
            sum = sum+a+b;
            q.add(a+b);
        }
        System.out.println(sum);
    }
}

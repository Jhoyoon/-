package gold;


// import java.util.*;

// public class B_1016_제곱ㄴㄴ수{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         long min = sc.nextLong();
//         long max = sc.nextLong();
//         boolean[] check = new boolean[(int)(max-min+1)];

//         for(long i=2;i*i<=max;i++){
//             long pow = i*i;
//             long start_index = min/pow;
//             if(min%pow!=0) start_index++;
//             for(long j=start_index;j*pow<=max;j++){
//                 check[(int)((j*pow)-min)]=true;
//             }
//         }
//         int count=0;
//         for(boolean i : check){
//             if(!i) count++;
//         }
//         System.out.println(count);
//     }
// }
import java.io.*;
import java.util.StringTokenizer;

public class B_1016_제곱ㄴㄴ수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] arr = new boolean[(int)(max-min+1)];

        for(long i=2;i*i<=max;i++){
            long pow = i*i;
            long start_index = min/pow;
            if(min%pow!=0) start_index++;
            for(long j = start_index;j*pow<=max;j++){
                arr[(int)(j*pow-min)] = true;
            }
        }
        int count = 0;
        for(boolean i : arr){
            if(!i) count++;
        }
        System.out.println(count);
    }
}
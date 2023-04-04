// import java.io.*;
// import java.util.StringTokenizer;
// public class B_1934_최소공배수 {
//     public static void main(String[] args)throws IOException{
//         BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         for(int i=0;i<N;i++){
//             StringTokenizer st = new StringTokenizer(br.readLine()," ");
//             int min = Integer.parseInt(st.nextToken());
//             int max = Integer.parseInt(st.nextToken());
//             int result = min*max/gcd(min,max);
//             System.out.println(result);
//         }
//     }
//     private static int gcd(int a,int b){
//         if(b==0){
//             return a;
//         }else{
//             return gcd(b,a%b);
//         }
//     }
// }

import java.io.*;
import java.util.StringTokenizer;

public class B_1934_최소공배수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int max = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int gcd = 0;
            int multi = max*min;
            // 최대공약수를 찾는 연산을 수행하자!
            while(true){
                int temp = max%min;
                if(temp==0){
                    gcd=min;
                    break;
                }
                max=min;
                min=temp;
            }
            int result = multi/gcd;
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
        
}
}
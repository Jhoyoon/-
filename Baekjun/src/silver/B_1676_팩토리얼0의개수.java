package silver;
// import java.io.*;
// import java.math.*;
// import java.util.*;
// public class B_1676_팩토리얼0의개수 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         BigInteger f = factorial(N);
//         String str = String.valueOf(f);
//         int count = 0;
//         for(int i=str.length()-1;i>=0;i--){
//             char ch = str.charAt(i);
//             if(ch=='0') count++;
//             else break;
//         }
//         System.out.println(count);
//     }
//     private static BigInteger factorial(int n){
//         BigInteger bi = new BigInteger("1");
//         for(int i=1;i<=n;i++){
//             bi = bi.multiply(BigInteger.valueOf(i));
//         }
//         return bi;
//     }
// }
import java.io.*;
import java.util.*;
public class B_1676_팩토리얼0의개수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        while(num>=5){
            count += num/5;
            num /= 5;
        }
        System.out.println(count);
    }
}
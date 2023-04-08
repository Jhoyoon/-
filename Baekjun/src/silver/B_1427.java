package silver;
import java.util.*;
import java.io.*;

//** arrays.sort를 사용한 방식

public class B_1427{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        Integer[] arr = new Integer[length];
        for(int i=0;i<length;i++){
            arr[i] = str.charAt(i)-'0';
        }
        Arrays.sort(arr,(o1,o2)->{
            return o2-o1;
        });
        StringBuffer sb = new StringBuffer();
        for(int i : arr){
            sb.append(i);
        }
        System.out.println(sb.toString());


    }
}

// ** 선택 정렬을 이용해서 푼 코드 **//

// public class B_1427{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String str = br.readLine();
//         int length = str.length();
//         int[] arr = new int[length];
//         for(int i=0;i<length;i++){
//             arr[i] = str.charAt(i)-'0';
//         }

//         for(int i = 0;i<length;i++){
//             int max = i;
//             for(int j=i+1;j<length;j++){
//                 if(arr[max]<arr[j]){
//                     max = j;
//                 }
//             }
//             if(arr[i]<arr[max]){
//                 int temp = arr[i];
//                 arr[i] = arr[max];
//                 arr[max] = temp;
//             }
//         }
//         StringBuffer sb  =new StringBuffer();
//         for(int i : arr){
//             sb.append(i);
//         }
//         System.out.println(sb.toString());
//     }
// }


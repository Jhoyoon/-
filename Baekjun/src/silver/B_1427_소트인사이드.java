package silver;
import java.io.*;
import java.util.*;
// import java.util.*;
// import java.io.*;

//** arrays.sort를 사용한 방식

// public class B_1427_소트인사이드{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         char[] ch = br.readLine().toCharArray();
//         Integer[] arr = new Integer[ch.length];
//         for(int i=0;i<ch.length;i++){
//             arr[i] = ch[i]-'0';
//         }
//         Arrays.sort(arr,(o1,o2)->{
//             return o2-o1;
//         });
//         StringBuffer sb  =new StringBuffer();
//         for(int i : arr){
//             sb.append(i);
//         }
//         System.out.println(sb.toString());

//     }
// }

// ** 선택 정렬을 이용해서 푼 코드 **//

// public class B_1427_소트인사이드{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         char[] ch = br.readLine().toCharArray();
//         int[] arr=  new int[ch.length];
//         int N = ch.length;
//         for(int i=0;i<N;i++){
//             arr[i] = ch[i]-'0';
//         }
//         for(int i=0;i<N-1;i++){
//             int max = i;
//             for(int j=i+1;j<N;j++){
//                 if(arr[max] < arr[j]){
//                     max = j;
//                 }
//             }
//                 int tmp = arr[max];
//                 arr[max] = arr[i];
//                 arr[i] = tmp;
            
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i: arr){
//             sb.append(i);
//         }
//         System.out.println(sb.toString());
//     }
// }
// 삽입 정렬을 이용해서 푼 코드
public class B_1427_소트인사이드{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int N = ch.length;
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = ch[i]-'0';
        }
        // 삽입정렬
        for(int i=1;i<N;i++){
            int insert_index = i;
            int insert_value = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i] < arr[j]){
                    insert_index = j+1;
                    break;
                }
                if(j==0){
                    insert_index = 0;
                }
            }
            for(int j=i;j>insert_index;j--){
                arr[j] = arr[j-1];
            }
            arr[insert_index] = insert_value;
        }
        StringBuffer sb = new StringBuffer();
        for(int i: arr){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
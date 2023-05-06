package bronze;
import java.io.*;
import java.util.*;
// import java.io.*;
// import java.util.*;
// public class B_2750_수정렬하기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int[] arr = new int[N];
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(br.readLine());
//         }
//         boolean change = false;
//         for(int i=0;i<N-1;i++){
//             for(int j=0;j<N-1-i;j++){
//                 if(arr[j] > arr[j+1]){
//                     change = true;
//                     int tmp = 0;
//                     tmp = arr[j];
//                     arr[j] = arr[j+1];
//                     arr[j+1] = tmp;
//                 }
//             }
//             if(change = false){
//                 break;
//             }
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i : arr){
//             sb.append(i+"\n");
//         }
//         System.out.print(sb.toString());
//     }
// }

// 선택정렬로 구현

// public class B_2750_수정렬하기{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int[] arr = new int[N];
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(br.readLine());
//         }
//         for(int i=0;i<N-1;i++){
//             int min = i;
//             for(int j = i+1;j<N;j++){
//                 if(arr[j] < arr[min]) min = j;
//             }
//             int tmp = arr[i];
//             arr[i] = arr[min];
//             arr[min] = tmp;
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i: arr){
//             sb.append(i+"\n");
//         }
//         System.out.print(sb.toString());
//     }
// }

// 삽입정렬로 구현
public class B_2750_수정렬하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 삽입정렬
        for(int i=1;i<N;i++){
            int insert_index = i;
            int insert_value = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i] > arr[j]){
                    insert_index = j+1;
                    break;
                }
                if(j == 0){
                    insert_index = 0;
                }
            }
            // insert_index부터 i까지 오른쪽으로 한칸씩 이동
            for(int j=i;j>insert_index;j--){
                arr[j] = arr[j-1];
            }
            arr[insert_index] = insert_value;
        }
        StringBuffer sb = new StringBuffer();
        for(int i : arr){
            sb.append(i+"\n");
        }
        System.out.print(sb.toString());
    }
}
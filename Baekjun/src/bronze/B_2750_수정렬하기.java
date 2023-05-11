package bronze;
import java.io.*;
import java.util.*;

// ** 버블정렬로 구현 ** 
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
//         for(int i=0;i<N;i++){
//             int min = i;
//             for(int j=i+1;j<N;j++){
//                 if(arr[min] > arr[j]) min = j;
//             }
//             if(arr[min] < arr[i]){
//                 int tmp = arr[min];
//                 arr[min] = arr[i];
//                 arr[i] = tmp;
//             }
//         }
//         StringBuffer sb  =new StringBuffer();
//         for(int i : arr){
//             sb.append(i+"\n");
//         }
//         System.out.print(sb.toString());
//     }
// }

//삽입정렬로 구현
public class B_2750_수정렬하기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1;i<N;i++){
            int insertPoint = i;
            int insertValue = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j] < arr[i]){
                    insertPoint = j+1;
                    break;
                }
                if(j == 0) insertPoint = 0;
            }
            for(int j=i;j>insertPoint;j--){
                arr[j] = arr[j-1];
            }
            arr[insertPoint] = insertValue;
        }
        StringBuffer sb = new StringBuffer();
        for(int i: arr){
            sb.append(i+"\n");
        }
        System.out.print(sb.toString());
    }
}
// ** 퀵정렬 **
// public class B_2750_수정렬하기{
//     static int[] arr;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         arr = new int[N];
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(br.readLine());
//         }
//         quickSort(0,N-1);
//         StringBuffer sb = new StringBuffer();
//         for(int i : arr){
//             sb.append(i+"\n");
//         }
//         System.out.print(sb.toString());
//     }
//     private static void quickSort(int s,int e){
//         if(s < e){
//             int pivot = partition(s,e);
//             quickSort(s,pivot-1);
//             quickSort(pivot+1,e);
//         }
//     }
//     private static int partition(int s,int e){
//         if(s+1 == e){
//             if(arr[s] > arr[e]) swap(s,e);
//             return e;
//         }
//         int pivot = arr[s];
//         int i = s+1;
//         int j = e;
//         while(i<=j){
//             while(i <= e && arr[i]<pivot) i++;
//             while(j>=s && arr[j] >pivot) j--;
//             if(i<=j){
//                 swap(i++,j--);
//             }
//         }
//         swap(s,j);
//         return j;
//     }
//     private static void swap(int s,int e){
//         int tmp = arr[s];
//         arr[s] = arr[e];
//         arr[e] = tmp;
//     }
// }
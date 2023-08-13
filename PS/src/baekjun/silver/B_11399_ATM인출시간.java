package baekjun.silver;
import java.util.*;
import java.io.*;
// ** 삽입정렬을 사용한 방법 **
// public class B_11399_ATM인출시간{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int[] arr = new int[N];
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(st.nextToken());
//         }
//         for(int i=1;i<N;i++){
//             int insert_index = i;
//             int insert_value = arr[i];
//             for(int j=i-1;j>=0;j--){
//                 if(arr[i] > arr[j]){
//                     insert_index = j+1;
//                     break;
//                 }
//                 if(j==0){
//                     insert_index=0;
//                 }
//             }
//             for(int j=i;j>insert_index;j--){
//                 arr[j] = arr[j-1];
//             }
//             arr[insert_index] = insert_value;
//         }
//         int[] sum = new int[N+1];
//         int ans = 0;
//         for(int i=1;i<=N;i++){
//             sum[i] = sum[i-1]+arr[i-1];
//             ans = ans + sum[i];
//         }
//         System.out.println(ans);
//     }
// }

public class B_11399_ATM인출시간{
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0,N-1);
        int[] S = new int[N+1];
        int sum = 0;
        for(int i=1;i<=N;i++){
            S[i] = S[i-1] + arr[i-1];
            sum = sum + S[i];
        }
        System.out.println(sum);
    }
    private static void quickSort(int s,int e){
        if(s<e){
            int pivot = partition(s,e);
            quickSort(s,pivot-1);
            quickSort(pivot+1,e);
        }
    }
    private static int partition(int s,int e){
        if(s+1 == e){
            if(arr[s] > arr[e]) swap(s,e);
            return e;
        }
        int pivot = arr[s];
        int i = s+1;
        int j = e;
        while(i<=j){
            while(i<= e && arr[i] < pivot ) i++;
            while(j>=s && arr[j] > pivot) j--;
            if(i<=j){
                swap(i++,j--);
            }
        }
        swap(s,j);
        return j;
        
    }
    private static void swap(int s,int e){
        int tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }
}
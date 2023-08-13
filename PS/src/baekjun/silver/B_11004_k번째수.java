package baekjun.silver;
import java.io.*;
import java.util.*;
// public class B_11004_k번째수 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int[] arr = new int[N];
//         st = new StringTokenizer(br.readLine()," ");
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(st.nextToken());
//         }
//         Arrays.sort(arr);
//        System.out.println(arr[M-1]); 
//     }
// }

// ** 퀵정렬을 사용한 방법 **
public class B_11004_k번째수{
    static int[] arr;
    static int K;
    public static void main(String[] args) throws IOException{
        // pivot을 선정할 규칙을 정하고
        // 퀵정렬을 수행한뒤 피봇의 인덱스를 k값이랑 비교한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0,N-1);
        System.out.println(arr[K-1]);
    }
    private static void quickSort(int s,int e){
        int pivot = partition(s,e);
        if(pivot == K-1) return;
        else if(pivot > K-1){
            quickSort(s,pivot-1);
        }else{
            quickSort(pivot+1,e);
        }
    }
    private static int partition(int s,int e){
        if(s+1 == e){
            if(arr[s] > arr[e]) swap(s,e);
            return e;
        }
        int M = (s+e)/2;
        int pivot = arr[M];
        swap(M,s);
        int i = s+1;
        int j = e;
        while(i<=j){
            while(arr[i] < pivot && i <= e) i++;
            while(arr[j] > pivot && j>=s) j--;
            if(i<=j){
                swap(i++,j--);
            }
        }
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }
    private static void swap(int s,int e){
        int tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }
}
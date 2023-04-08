package silver;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

import java.io.*;

// public class B_11399{
//     public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        int N = Integer.parseInt(st.nextToken());
//        int M  = Integer.parseInt(st.nextToken());
//        int[] arr = new int[N];
//        st = new StringTokenizer(br.readLine()," ");
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(st.nextToken()); 
//         }
        
//         System.out.println(arr[M-1]);
//     }
// }
public class B_11399{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N  = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr,0,N-1,K-1);
        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] arr,int S,int E,int K){
        if(S<E){
            int pivot  =partition(arr,S,E);
            if(K==pivot) return;
            else if(K>pivot){
                quickSort(arr,pivot+1,E,K);
            }else{
                quickSort(arr,S,pivot+1,K);
            }
        }
    }

    public static int partition(int[] arr,int S,int E){
        return 1;
    }
    
    public static void swap(int[] arr,int S,int E){
        int temp = arr[S];
        arr[S] = arr[E];
        arr[E] = temp;
    }
}
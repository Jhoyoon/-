package platinum;


// import java.util.*;
// import java.io.*;

// public class B_1517{
//     static int[] arr;
//     static int[] tmp;
//     static int count;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         arr = new int[N];
//         tmp = new int[N];
//         count=0;
//         StringTokenizer st = new StringTokenizer(br.readLine()," ");
//         for(int i=0;i<N;i++){
//             arr[i] = Integer.parseInt(st.nextToken());
//         }
//         mergeSort(0,N-1);
//         System.out.println(count);
//     }

//     private static void mergeSort(int s,int e){
//         if(e-s<1) return;

//         int m  = (e+s)/2;
//         mergeSort(s,m);
//         mergeSort(m+1,e);

//         for(int i=s;i<=e;i++){
//             tmp[i] = arr[i];
//         }
//         int k = s;
//         int index1 = s;
//         int index2 = m+1;

//         while(index1<=m && index2 <= e){
//             if(tmp[index1]>tmp[index2]){
//                 count = count + (index2-k);
//                 arr[k] = tmp[index2];
//                 k++;
//                 index2++;
//             }else{
//                 arr[k]=tmp[index1];
//                 k++;
//                 index1++;
//             }
//         }
//         while(index1<=m){
//             arr[k] = tmp[index1];
//             k++;
//             index1++;
//         }
//         while(index2<=e){
//             arr[k]=tmp[index2];
//             k++;
//             index2++;
//         }
//     }
// }

import java.util.*;
import java.io.*;

public class B_1517{
    static int[] arr;
    static int[] tmp;
    static long count;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        count=0;
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 입력값 입력
        
        mergeSort(0,N-1);
        System.out.println(count);
    }

    private static void mergeSort(int s,int e){
        if(e-s<1) return;
        int m = (e+s)/2;
        mergeSort(s,m);
        mergeSort(m+1,e);

        for(int i=s;i<=e;i++){
            tmp[i] = arr[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m+1;

        while(index1<=m && index2<=e){
            if(tmp[index1]>tmp[index2]){
                count  = count + index2-k;
                arr[k]=tmp[index2];
                k++;
                index2++;
            }else{
                arr[k]=tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1<=m){
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2<=e){
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
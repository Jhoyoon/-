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
// ** 삽입 정렬 ** 
// public class B_1427_소트인사이드{
//     public static void main(String[] args)throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         char[] ch = br.readLine().toCharArray();
//         int N = ch.length;
//         int[] arr = new int[N];
//         for(int i=0;i<N;i++){
//             arr[i] = ch[i]-'0';
//         }
//         // 삽입정렬
//         for(int i=1;i<N;i++){
//             int insert_index = i;
//             int insert_value = arr[i];
//             for(int j=i-1;j>=0;j--){
//                 if(arr[i] < arr[j]){
//                     insert_index = j+1;
//                     break;
//                 }
//                 if(j==0){
//                     insert_index = 0;
//                 }
//             }
//             for(int j=i;j>insert_index;j--){
//                 arr[j] = arr[j-1];
//             }
//             arr[insert_index] = insert_value;
//         }
//         StringBuffer sb = new StringBuffer();
//         for(int i: arr){
//             sb.append(i);
//         }
//         System.out.println(sb.toString());
//     }
// }
// ** 퀵정렬 **
// public class B_1427_소트인사이드{
//     static int[] arr;
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         char[] c = br.readLine().toCharArray();
//         arr = new int[c.length];
//         for(int i=c.length-1;i>=0;i--){
//             arr[i] = c[i]-'0';
//         }
//         quickSort(0,arr.length-1);
//         StringBuffer sb = new StringBuffer();
//         for(int i: arr){
//             sb.append(i);
//         }
//         System.out.println(sb.toString());
//     }
//     private static void quickSort(int s,int e){
//         if(s<e){
//             int pivot = partition(s,e);
//             quickSort(s,pivot-1);
//             quickSort(pivot+1,e);
//         }
//     }
//     private static int partition(int s,int e){
//         if(s+1 == e){
//             if(arr[s] < arr[e]) swap(s,e);
//             return e;
//         }
//         int pivot = arr[s];
//         int i = s+1;
//         int j = e;
//         while(i<=j){
//             while(i <=e && arr[i] > pivot) i++;
//             while(j >=s && arr[j] < pivot) j--;
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
// ** 병합정렬 **
public class B_1427_소트인사이드{
    static int[] arr,tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        arr = new int[c.length];
        tmp = new int[c.length];
        for(int i=c.length-1;i>=0;i--){
            arr[i] = c[i]-'0';
        }
        mergeSort(0,arr.length-1);
        StringBuffer sb = new StringBuffer();
        for(int i : arr){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
    private static void mergeSort(int s,int e){
        if(e-s < 1) return;
        int m = s+(e-s)/2;
        mergeSort(s,m);
        mergeSort(m+1,e);
        for(int i=s;i<=e;i++){
            tmp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1 <= m && index2 <= e){
            if(tmp[index1] < tmp[index2]){
                arr[k] = tmp[index2];
                k++;
                index2++;
            }else{
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m){
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
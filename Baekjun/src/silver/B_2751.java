package silver;
import java.util.*;
import java.io.*;
// 병합정렬 구현
public class B_2751 {
    static int arr[];
    static int tmp[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0,N-1);
        StringBuffer sb  = new StringBuffer();
        for(int i: arr){
            sb.append(i+"\n");
        }
        System.out.print(sb.toString());
    }

    private static void mergeSort(int s, int e){
        if(e-s<1) return;
        int m = (s+e)/2;
        // 호출 스택을 나눠서 각각을 병합정렬 하는거임.
        mergeSort(s,m);
        mergeSort(m+1,e);

        for(int i=s;i<=e;i++){
            tmp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1<=m && index2<=e){
            if(tmp[index1]<tmp[index2]){
                arr[k] = tmp[index1];
                k++;
                index1++;
            }else{
                arr[k] = tmp[index2];
                k++;
                index2++;
            }
        }

        while(index1<=m){
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2<=e){
            arr[k]=tmp[index2];
            k++;
            index2++;
        }
    }
}

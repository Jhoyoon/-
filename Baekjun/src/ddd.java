import java.util.*;
import java.io.*;

public class ddd {
    //일단 반으로 나누고 정렬 후 병합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());
        int arr[]=new int[num];
        int temp[]=new int[num];
        for (int i=0;i<num;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        mergeSort(arr,0,num-1,temp);
        for (int a:arr
             ) {
            System.out.println(a);
        }
    }

    private static void mergeSort(int[] arr, int n, int m,int temp[]) {
        if(n<m){
            int middle=(n+m)/2;
            mergeSort(arr,n,middle,temp);
            mergeSort(arr,middle+1,m,temp);
            merge(arr,n,middle,m,temp);
        }
    }

    private static void merge(int []arr,int n,int middle,int m,int temp[]){
        int i=n,j=middle+1;
        int k=n;
        while(i<=middle&&j<=m){
            if(arr[i]<arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }

        if(i>middle)// j 남음
            for(i=j;i<=m;i++)
                temp[k++]=arr[i];
        else //i 남음
            for(;i<=middle;i++)
                temp[k++]=arr[i];
        for(i=n;i<=m;i++){
            arr[i]=temp[i];
        }
    }
}
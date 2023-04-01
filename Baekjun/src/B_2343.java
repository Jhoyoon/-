import java.util.*;
import java.io.*;
public class B_2343 {
    static int[] arr;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max<arr[i]) max = arr[i];
            sum = sum+arr[i];
        }
        binarySearch(max,sum);
    }
    private static void binarySearch(int s,int e){
        while(e>=s){
            int m = (s+e)/2;
            int blueray = 0;
            int count = 0;
            // 블루레이에 비디오 넣기
            for(int i=0;i<arr.length;i++){
                if(blueray+arr[i]>m){
                    count++;
                    blueray = 0;
                }
                blueray = blueray+arr[i];
            }
            if(blueray!=0) count++;

            if(count>M){
                s = m+1;
            }else{
                e=m-1;
            }
        }
        System.out.println(s);
    }
}

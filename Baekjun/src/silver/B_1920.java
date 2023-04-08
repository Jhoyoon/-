package silver;
import java.util.*;
import java.io.*;
public class B_1920 {
    static int[] arr;
    static int[] aa;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 꼭 정렬해야 함
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        int[] arrCheck = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            arrCheck[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            binarySearch(arrCheck[i]);
        }
    }

    private static void binarySearch(int num){
        int s = 0;
        int e = arr.length-1;
        boolean found=true;
        while(e>=s){
            // m은 반드시 와일문 안에 넣어야 함
            int m = (s+e)/2;
            if(num >arr[m]){
                s = m+1;
            }else if(num<arr[m]){
                e = m-1;
            }else{
                found =false;
                System.out.println(1);
                break;
            }
        }
        if(found){
            System.out.println(0);
        }
    }
}

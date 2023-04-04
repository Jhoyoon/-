import java.util.*;
import java.io.*;
public class B_1456_거의소수 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // 일단 저 범위에서 소수를 판별하고 
        // 그 다음 그 소수들을 전부 제곱하고 범위를 벗어난 애들은 제외하고 
        //남은 숫자들의 숫자를 출력하자
        int[] arr = new int[b+1];
        for(int i=1;i<=b;i++){
            arr[i] = i;
        }
        arr[1]=0;
        for(int i=2;i<=Math.sqrt(b);i++){
            if(arr[i]==0) continue;
            for(int j=i+i;j<=b;j+=i){
                arr[j]=0;
            }
        }
        for(int i=2;i<=b;i++){
            arr[i]=arr[i]*arr[i];
            if(arr[i]>b) arr[i]=0;
        }
        int count = 0;
        for(int i=a;i<=b;i++){
            if(arr[i]!=0) count++;
        }
        System.out.println(count);
    }   
}

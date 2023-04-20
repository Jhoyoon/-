package silver;
import java.util.*;
import java.io.*;
public class B_13251_조약돌꺼내기{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        // 조약돌 색깔 종류
        int M = Integer.parseInt(br.readLine());
        int[] num = new int[51];
        int sum = 0;
        double[] probability = new double[51];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            num[i] = Integer.parseInt(st.nextToken());
            sum = sum+num[i];
        }
        double ans = 0.0;
        int choice = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            if(num[i]>=choice){
                probability[i] = 1.0;
                for(int j=0;j<choice;j++){
                    probability[i] = probability[i]*(num[i]-j)/(sum-j);
                }
            }
            ans = ans+probability[i];
        }
        System.out.print(ans);
    }
}
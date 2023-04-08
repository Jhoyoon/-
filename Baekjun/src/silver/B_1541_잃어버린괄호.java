package silver;
import java.util.*;
import java.io.*;
public class B_1541_잃어버린괄호{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력을 쫙 받고 -를 기준으로 토큰을 나눈다.
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        // 그리고 토큰의 개수만큼 배열을 만든다.
        int[] arr = new int[st.countTokens()];
        // 그리고 각 토큰의 합을 배열에 담는다
        int length=  st.countTokens();
        for(int i=0;i<length;i++){
            arr[i] = sumnum(st.nextToken());
        }

        int sol=0;
        // 첫번째는 그냥 더하고
        sol = sol+arr[0];
        // 
        for(int i=1;i<arr.length;i++){
            sol = sol-arr[i];
        }
        System.out.println(sol);
    }
    private static int sumnum(String num){
        StringTokenizer st = new StringTokenizer(num,"+");
        int[] arr = new int[st.countTokens()];
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum = sum+arr[i];
        }
        return sum;
    }
}
package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_25418_정수a를k로 {
    //그리디 방식을 사용한 방법
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        while(a != k){
            count++;
            if(k%2 == 0 && k/2>=a){
                 k = k/2;
            }else{
                k = k-1;
            }
        }
        System.out.println(count);
    }
}

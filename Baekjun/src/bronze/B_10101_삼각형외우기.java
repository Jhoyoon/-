package bronze;
import java.io.*;
import java.util.*;
public class B_10101_삼각형외우기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] triangle = new int[3];
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<3;i++){
            triangle[i] = Integer.parseInt(br.readLine());
        }
        // 삼각형 판별
        boolean Equilateral = true;
        int sum = 0;
        for(int i=0;i<3;i++){
            if(triangle[i] != 60) Equilateral = false;
            sum = sum + triangle[i];
        }
        if(Equilateral) sb.append("Equilateral");
        else{
            if(sum != 180){
                sb.append("Error");
            }else{
                if(triangle[0] == triangle[1] || triangle[0]==triangle[2] || triangle[1]==triangle[2]) sb.append("Isosceles");
                else sb.append("Scalene");
            }
        }
        System.out.println(sb.toString());

        
    }
}

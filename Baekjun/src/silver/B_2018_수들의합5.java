package silver;
import java.io.*;
import java.util.*;
public class B_2018_수들의합5{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int count = 0;
        int start_index = 1;
        int end_index = 1;
        while(end_index<=N){
            if(sum>N){
                sum -= start_index;
                start_index++;
            }else if(sum<N){
                end_index++;
                sum+=end_index;
            }else{
                count++;
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);

    }
}
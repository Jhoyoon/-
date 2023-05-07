package bronze;
import java.io.*;
import java.util.*;
public class B_5554_심부름가는길{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int sum = a+b+c+d;
        int min = 0;
        int sec = 0;
        while(sum >= 60){
            sum = sum - 60;
            min++;
            sec = sum;
        }
        System.out.print(min+"\n"+sec);
    }
}
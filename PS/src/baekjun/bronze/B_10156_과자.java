package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_10156_과자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int price = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        if(price*num > money){
            sb.append(price*num - money);
        }else{
            sb.append(0);
        }
        System.out.println(sb.toString());

    }
}

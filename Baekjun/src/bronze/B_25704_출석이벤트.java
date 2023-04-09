package bronze;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_25704_출석이벤트{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int money = Integer.parseInt(br.readLine());
        int pricemoney = money;
        if(N>=5){
            int discount5 = money -500;
            pricemoney = Math.min(pricemoney,discount5);
        }
        if(N>=10){
            int discount10 = (int)(money*0.9);
            pricemoney = Math.min(pricemoney,discount10);
        }
        if(N>=15){
            int discount15 = money -2000;
            pricemoney = Math.min(pricemoney,discount15);
        }
        if(N>=20){
            int discount20 = (int)(money*0.75);
            pricemoney = Math.min(pricemoney,discount20);
        }
        System.out.print(Math.max(pricemoney,0));
    }
}

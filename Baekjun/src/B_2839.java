import java.util.*;
import java.io.*;

public class B_2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0; //봉지 개수
        while(true){
            if(N%5==0){
                count +=N/5;
                break;
            }else if(N<3){
                count = -1;
                break;
            }
            N-=3;
            count++;
        }
        System.out.println(count);
    }        
}


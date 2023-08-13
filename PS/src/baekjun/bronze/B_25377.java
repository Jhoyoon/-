package baekjun.bronze;
import java.util.*;
public class B_25377 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int low = Integer.MAX_VALUE;
        boolean bb = false;
        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b-a<0) continue;
            if(low>b){
                low = b; 
                bb = true;
            }   
        }
        if(bb)
            System.out.println(low);
        else System.out.println(-1);

    }
}

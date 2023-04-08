package bronze;
import java.util.*;
public class B_14470 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 원래의 고기 온도
        int b = sc.nextInt(); // 목표 온도
        int c = sc.nextInt(); // 얼어있는 고기를 1도 데우는데 걸리는 시간
        int d = sc.nextInt(); // 얼어있는 고기를 해동하는데 걸리는 시간
        int e = sc.nextInt(); // 얼어있지 않는 고기를 1도 데우는데 걸리는 시간
        int time=0;
       if(a<0){
        time=(-a)*c;
        time+=d;
        time+=b*e;
       }else{
        time=(b-a)*e;
       }
       System.out.println(time);

    }
}

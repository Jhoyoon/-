package baekjun.bronze;
import java.io.*;
import java.util.*;
public class B_1595_꼬리를무는숫자나열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 좌우 길이 차이를 구해보자
        int N_x=0;
        int M_x=0;
        if(N%4 == 0){
            N_x = N/4;
        }else{
            N_x = N/4+1;
        }
        if(M%4 == 0){
            M_x = M/4;
        }else{
            M_x = M/4+1;
        }
        int 좌우  =Math.abs(M_x-N_x);
        // 위아래 길이를 구해보자
        int N_y = 0;
        int M_y = 0;
        if(N%4 == 0){
            N_y=4;
        }else if(N%4 == 3){
            N_y=3;
        }else if(N%4==2){
            N_y=2;
        }else if(N%4==1){
            N_y=1;
        }
        if(M%4 == 0){
            M_y=4;
        }else if(M%4 == 3){
            M_y=3;
        }else if(M%4==2){
            M_y=2;
        }else if(M%4==1){
            M_y=1;
        }
        int 위아래 = Math.abs(N_y - M_y);
        System.out.println(좌우+위아래);
    }
}

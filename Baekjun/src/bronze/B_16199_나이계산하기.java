package bronze;
import java.io.*;
import java.util.*;
public class B_16199_나이계산하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int age = y2-y;
        if(y==y2){
            System.out.println(0);
        }else{
            if(m > m2){
                System.out.println(age-1);
            }else if(m == m2){
                if(d >d2){
                    System.out.println(age-1);
                }else{
                    System.out.println(age);
                }
            }else{
                System.out.println(age);
            }

        }
        System.out.println(age+1);
        System.out.println(age);


    }
}

package bronze;
import java.util.*;
public class B_24883 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = str.charAt(0);
        if(c=='N'||c=='n'){
            System.out.println("Naver D2");
        }else{
            System.out.println("Naver Whale");
        }

    }
}

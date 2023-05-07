package bronze;
import java.io.*;
import java.util.*;
public class B_5543_상덕버거 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sang = Integer.parseInt(br.readLine());
        int joong = Integer.parseInt(br.readLine());
        int ha = Integer.parseInt(br.readLine());
        int cola = Integer.parseInt(br.readLine());
        int cider = Integer.parseInt(br.readLine());
        int min_buger = Math.min(sang,Math.min(joong,ha));
        int min_beverage = Math.min(cola,cider);
        System.out.println(min_buger+min_beverage-50);

    }
}

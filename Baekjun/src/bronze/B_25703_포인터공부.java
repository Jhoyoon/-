package bronze;
import java.io.*;
import java.util.*;

public class B_25703_포인터공부 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("int a;\n");
        sb.append("int *ptr = &a;\n");
        for(int i=2;i<=N;i++){
            sb.append("int ");
            for(int j=0;j<i;j++) sb.append("*");
            sb.append("ptr"+i+" = &ptr");
            if(i!=2) sb.append(i-1);
            sb.append(";\n");
        }
        System.out.print(sb.toString());
    }
}
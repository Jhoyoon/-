package bronze;
import java.util.Scanner;

public class B_25591_푸앙이와종윤이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.close();

        int a = 100 - num1;
        int b = 100 - num2;
        int c = 100 - (a + b);
        int d = a * b;

        int q = d / 100;
        int r = d % 100;

        int result1 = c + q;
        int result2 = r;

        System.out.printf("%d %d %d %d %d %d%n", a, b, c, d, q, r);
        System.out.printf("%d %d%n", result1, result2);
    }
}

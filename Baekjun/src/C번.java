import java.io.*;
import java.util.*;
public class C번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    B[i] = A[i] / 2;
                    C[i] = A[i] - B[i];
                } else {
                    C[i] = A[i] / 2;
                    B[i] = A[i] - C[i];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    B[i] = A[i] / 2;
                    C[i] = A[i] - B[i];
                } else {
                    C[i] = A[i] / 2;
                    B[i] = A[i] - C[i];
                }
            }
        }
        System.out.println("YES");
        for (int i = 0; i < n; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(C[i] + " ");
        }
    }
}

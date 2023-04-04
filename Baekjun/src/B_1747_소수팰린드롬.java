import java.util.*;
public class B_1747_소수팰린드롬 {
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[10000000];
        isPrime();
        int sol = pel(N);
        System.out.println(sol);
    }
    private static int pel(int N) {
        for(int i=N;i<arr.length;i++){
            if(arr[i]!=0){
                String s = String.valueOf(arr[i]);
                char[] c = s.toCharArray();
                int st = 0;
                int e = c.length-1;
                boolean flag = true;
                while(st<e){
                    if(c[st]==c[e]){
                        st++;
                        e--;
                    }else{
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return arr[i];
                }
            }
        }
        return 0;
    }
    private static void isPrime() {
        for(int i=2;i<arr.length;i++){
            arr[i] = i;
        }
        for(int i=2;i<Math.sqrt(arr.length);i++){
            if(arr[i]==0) continue;
            for(int j=i+i;j<arr.length;j+=i){
                arr[j]=0;
            }
        }
    }
}

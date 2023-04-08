package gold;
// import java.util.*;

// public class B_2023{
//     static int N;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         N = sc.nextInt();
//         DFS(2,1);
//         DFS(3,1);
//         DFS(5,1);
//         DFS(7,1);
//     }

//     private static void DFS(int num,int jarisu){
//         if(jarisu == N){
//             if(isPrime(num)){
//                 System.out.println(num);
//             }
//             return;
//         }

//         for(int i=1;i<10;i++){
//             if(isPrime(num*10+i)){
//                 DFS(num*10+i,jarisu+1);
//             }
//         }
//     }

//     private static boolean isPrime(int num){
//         for(int i=2;i<num;i++){
//             if(num%i==0) return false;
//         }
//         return true;
//     }
// }

import java.util.*;

public class B_2023{
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    private static void DFS(int num,int jarisu){
        if(jarisu == N){
            if(isPrime(num)){
                System.out.println(num);
                return;
            }
        }

        for(int i=1;i<10;i++){
            if(i%2==0) continue;
            if(isPrime(num*10+i)){
                // ++jarisu를 사용하면 이 DFS함수 내의 jarisu 값이 변경되어서 안 된다.
                DFS(num*10+i,jarisu+1);
            }
        }
    }

    private static boolean isPrime(int num){
        for(int i=2;i<num/2;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
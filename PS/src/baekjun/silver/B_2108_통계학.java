package baekjun.silver;
import java.util.*;
import java.io.*;

public class B_2108_통계학 {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            // 입력받은 수열의 총 합.나누기 계산 후 반올림 해야해서 double로 선언
            double sum = 0;
            // 최대값과 최소값을 저장할 변수들
            int max = Integer.MIN_VALUE;
            int low = Integer.MAX_VALUE;
            // 들어오는 값들의 count를 저장할 배열들
            int[] plus = new int[4001];
            int[] minus = new int[4001];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(br.readLine());
                //총합 저장
                sum+=arr[i];
                //최대 최소 저장
                if(arr[i]>max) max = arr[i];
                if(arr[i]<low) low = arr[i];
                // 양수,0은 plus에 음수는 minus에 넣는다
                if(arr[i]>=0){
                    plus[arr[i]]++;
                }else{
                    minus[-arr[i]]++;
                }
            }
            // 중앙값을 찾기 위해 정렬해준다.
            Arrays.sort(arr);
            // 가장 높은 count값을 저장하기 위한 변수.**count이다**
            int max_count = 0;
            //배열을 가변적으로 사용하기 위해서 ArrayList 사용
            ArrayList<Integer> same = new ArrayList<>();
            // plus와 minus 중에서 가장 큰 count값이 무엇인지 찾아낸다
            for(int i=0;i<4001;i++){
               if(plus[i]>max_count){
                max_count=plus[i];
               }
               if(minus[i]>max_count){
                max_count=minus[i];
               }
            }
            
            // 가장 큰 값과 일치하는 값들의 인덱스를 ArrayList에 저장한다.인덱스 = 입력한 숫자
             for(int i=0;i<4001;i++){
                if(max_count == plus[i]) same.add(i);
                if(max_count==minus[i]) same.add(-i);
             }
             // 정렬한다
            Collections.sort(same);
             int sol = 0;
             // 사이즈가 1보다 크다 = 가장 큰 값이 여러개였다.그럴경우 두번째로 작은 값을 출력
             if(same.size()>1){
                sol = same.get(1);
             }else{
                // 1개 밖에 없을경우 그냥 이거 출력
                sol = same.get(0);
             }

    
            System.out.println(Math.round(sum/N));
            System.out.println(arr[N/2]);
            System.out.println(sol);
            System.out.println(max-low);

        }
}

package gold;
import java.io.*;
import java.util.*;
public class B_1722_순열의순서 {
    public static void main(String[] args) throws IOException{
        int N,Q;
        // 각 자리별로 만들수 있는 경우의 수 저장하기 그럼 이 안에 모든 팩토리얼을 담아야겠네?아 그래서 long이구나
        long F[] = new long[21];
        // 순열을 담는 배열 숫자의 배열을 담는다
        int S[] = new int[21];
        // 숫자 사용 유무 저장 배열
        boolean visited[] = new boolean[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //숫자의 개수를 입력받음
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 아 질문이 뭔지
        Q = Integer.parseInt(st.nextToken());
        // 0팩은 무조건 1.계산이 의미가 없으므로 그냥 1로 초기화해줌
        F[0] = 1;
        // 모든 팩토리얼을 넣어준다. f[0]은 구했으니까 1부터 N까지 구해준다.
        for(int i=1;i<=N;i++){
            F[i] = F[i-1]*i;
        }
        // 1번문제. 3번째로 정렬된 팩토리얼을 찾아라!
        if(Q == 1){
            // K번째로 정렬된 수열을 찾아야한다.
            long K = Long.parseLong(st.nextToken());
            // 0번째는 없으므로 1부터 돌림
            for(int i=1;i<=N;i++){
                for(int j=1,cnt = 1;j<=N;j++){
                    if(visited[j]) continue;
                    if(K<=cnt*F[N-i]){
                        K-=((cnt-1)*F[N-i]);
                        S[i]=j;
                        visited[j]=true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i=1;i<=N;i++){
                System.out.print(S[i]+" ");
            }
        }else{
            long K = 1;
            for(int i=1;i<=N;i++){
                S[i]=Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j=1;j<S[i];j++){
                    if(visited[j]==false){
                        cnt++;
                    }
                }
                K+=cnt*F[N-i];
                visited[S[i]]=true;
            }
            System.out.println(K);
        }
    }
}

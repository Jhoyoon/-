package silver;
// import java.util.*;
// public class B_1966_프린터큐 {

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
//         // 테스트 케이스 입력받고
// 		int T = sc.nextInt();
		
// 		for (int i = 0; i < T; i++) {
//             // 종이의 개수
// 			int N = sc.nextInt();
//             // 내가 찾아야하는 번호
// 			int M = sc.nextInt();
//             // 숫자 세주는 카운터
// 			int cnt = 0;
//             // 그냥 기본 큐로 선언함.
// 			Queue<int[]> queue = new LinkedList<>();
//             //그냥 인덱스랑 바로 넣어버리네?
// 			for (int j = 0; j < N; j++) {
// 				queue.add(new int[] {j,sc.nextInt()});
// 			}
// 			//
// 			while (true) {
//                 //맨 위에꺼 하나 꺼내주고
// 				int now[] = queue.remove();
// 				boolean flag = true;
// 				// 큐에 있는걸 전부 꺼내서 배열에 넣네.이게 되네...
// 				for (int q[] : queue) {
//                     // 1이면 중요도.지금게 작을시 break;
// 					if(q[1] > now[1]) {
// 						flag = false;
// 						break;
// 					}
// 				}
				
// 				if(flag) {
// 					cnt++;
// 					if(now[0] == M) break;
// 				}else {
// 					queue.add(now);
// 				}
// 			}
// 			System.out.println(cnt);
// 		}
// 	}
// }

import java.util.*;
public class B_1966_프린터큐{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<T;i++){
			Queue<int[]> q = new LinkedList<>();
			int count = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			for(int j=0;j<N;j++){
				q.add(new int[]{j,sc.nextInt()});
			}
			while(true){
				int[] now = q.poll();
				boolean flag=true;
				for(int[] k : q){
					// 현재 now보다 중요도가 큰게 한개라도 있다면
					if(k[1] >now[1] ){
						flag=false;
						break;
					}
				}
				if(flag){
					count++;
					if(now[0]==M) break;
				}else{
					q.add(now);
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}
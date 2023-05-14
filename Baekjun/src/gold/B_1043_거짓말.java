package gold;
import java.io.*;
import java.util.*;
public class B_1043_거짓말{
  static int[] parent;
  public static void main(String[] args) throws IOException{
    // 진실을 아는 사람들과 아닌 사람들을 각각 다른 그룹으로 묶는다
    // 그리고 진실을 아는 사람들과 같은 파티에 참석시 모두 진실을 아는 사람들의 그룹으로 묶인다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int person = Integer.parseInt(st.nextToken());
    int party = Integer.parseInt(st.nextToken());
    parent = new int[person+1];
    for(int i=1;i<=person;i++){
      parent[i] = i;
    }
    st = new StringTokenizer(br.readLine()," ");
    int truePerson =  Integer.parseInt(st.nextToken());
    int[] truePersonArr = new int[truePerson];
    for(int i=0;i<truePerson;i++){
      truePersonArr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=0;i<party;i++){
      st = new StringTokenizer(br.readLine()," ");
      
    }

  }
}
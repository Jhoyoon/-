import java.io.*;

public class B_11689_오일러피{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = N;
        for(long i=2;i<=Math.sqrt(N);i++){
            if(N%i==0){
                result=result-result/i;
                while(N%i==0) N=N/i;
            }
        }
        if(N>1) result= result-result/N;
        System.out.println(result);
    }
}
package silver;
import java.util.*;
import java.io.*;

public class B_4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals(".")) break;
            System.out.println(solution(s));
        }
    }
    private static String solution(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='[') st.push('[');
            if(c=='(') st.push('(');
            if(c==']'){
                if(st.isEmpty() || st.peek()!='[') return "no";
                else st.pop();
            }
            if(c==')'){
                if(st.isEmpty() || st.peek()!='(') return "no";
                else st.pop();
            }
        }
        if(st.isEmpty()) return "yes";
        else return "no";
    }
}
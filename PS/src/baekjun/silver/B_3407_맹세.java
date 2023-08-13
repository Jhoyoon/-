package baekjun.silver;
import java.io.*;
import java.util.*;
public class B_3407_맹세 {
    static final String[] List = { "h", "he", "li", "be", "b", "c", "n", "o", "f", "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar", "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe", "cs", "ba", "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu", "hf", "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn", "fr", "ra", "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr", "rf", "db", "sg", "bh", "hs", "mt", "ds", "rg", "cn", "fl", "lv" };
    static HashSet<String> elements = new HashSet<>(Arrays.asList(List));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            boolean[] dp = new boolean[c.length+1];
            dp[0] = true;
            for(int j=0;j<c.length;j++){
                if(!dp[j]) continue;
                // j+1이 c.length와 같아도 된다.배열 인덱스로 주는건 j이기 때문
                if(j+1 <= c.length && elements.contains(String.valueOf(c[j]))) dp[j+1] = true;
                if(j+2 <= c.length && elements.contains(String.valueOf(c[j])+String.valueOf(c[j+1]))){
                    dp[j+2] = true;
                }
            }
            if(dp[c.length]) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb.toString());
    }
}

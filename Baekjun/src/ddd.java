import java.util.*;
import java.io.*;

public class ddd {
    //일단 반으로 나누고 정렬 후 병합
    public static void main(String[] args) throws IOException {
        char c = '0';
        String str = "";
        if(c >='a' && c<='z'){
            str = "0은 소문자입니다.";
        }else if(c >='A' && c <='Z'){
            str = "0은 대문자입니다.";
        }
        System.out.println(str);
    }
}
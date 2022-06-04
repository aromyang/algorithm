package sorting.solutions;

import java.util.Arrays;

public class JadenCase {
    public static void main(String[] args) {
        JadenCase j = new JadenCase();
        String s = "3people unFollowed me";

        System.out.println(j.makingJadenCase(s));
    }
    public String makingJadenCase(String s){
        //소문자로 변환 후 공백 기준으로 나눈다
        String[] strings = s.toLowerCase().split(" ");

        //입력받은 문자열의 마지막이 공백이었을 경우 예외 처리
        if(s.charAt(s.length() - 1) == ' ') {
            strings[strings.length-1] += " ";
        }

        for(int i=0; i<strings.length; i++){
            //공백 요소일 경우 예외 처리
            if(strings[i].length()==0) continue;
            //첫문자만 대문자로 바꾸기
            strings[i] = strings[i].substring(0,1).toUpperCase() + strings[i].substring(1);
        }

        //strings의 요소를 공백으로 구분해 String으로 담아 리턴
        return String.join(" ", strings);
    }

    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        String s2 = s.toLowerCase();
        char last = ' ';

        for(char c : s2.toCharArray()){
            if(last == ' ') c = Character.toUpperCase(c);
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }
    //String 사용과 StringBuilder 사용의 테스트 속도 차이가 엄청나다
}

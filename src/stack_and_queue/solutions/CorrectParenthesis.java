package stack_and_queue.solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CorrectParenthesis {
    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(correctParenthesis(s));
    }

    static boolean correctParenthesis(String s) {
        if (s.length() % 2 != 0 || s.startsWith(")") || s.endsWith("(")) return false;

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i += 2) queue.offer(s.substring(i, i + 2));

        int left = 0;
        int right = 0;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str.equals(")(")) return false;
            if (str.equals("((")) left++;
            if (str.equals("))")) right++;
        }

        if (left != right) return false;
        else return true;
    }
    //틀림) 정확성 13/18 효율성 1/2

    //괄호 열고 닫는 문제 -> 전형적인 스택 ㅠ
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (!stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty()==true;
    }

    static boolean solution2(String s){
        int stack = 0;
        for(char c : s.toCharArray()){
            if(c=='(') stack++;
            else{
                if(stack==0) return false;
                stack--;
            }
        }
        return stack==0;
    }
}

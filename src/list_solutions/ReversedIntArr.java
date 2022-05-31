package list_solutions;

public class ReversedIntArr {
    public int[] reversedIntArr(long n) {
        String longToStr = Long.toString(n);
        StringBuilder sb = new StringBuilder(longToStr);
        String reversedStr = sb.reverse().toString();

        int[] answer = new int[reversedStr.length()];
        for (int i = 0; i < reversedStr.length(); i++) {
            answer[i] = reversedStr.charAt(i) - '0';
        }
        return answer;
    }
}


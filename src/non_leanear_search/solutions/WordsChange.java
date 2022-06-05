package non_leanear_search.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordsChange {
    public static void main(String[] args) {
        WordsChange w = new WordsChange();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(w.wordsChanger(begin, target, words));

    }

    public int wordsChanger(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        boolean[] visited = new boolean[words.length];

        return verifyChangeable(begin, words, visited, target, 0);
    }

    public int verifyChangeable(String begin, String[] words, boolean[] visited, String target, int count) {
        for (int i = 0; i < words.length; i++) {
            int finishable = 0;
            int changeable = 0;
            for (int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j)!=target.charAt(j)) finishable++;
                if(begin.charAt(j)!=words[i].charAt(j)) changeable++;
            }

            if(finishable==1) return count+1;
            else if(changeable == 1 && !visited[i]) {
                begin = words[i];
                count++;
                visited[i] = true;
            }
        }

        return count;
    }

    //여기부터 해설 - dfs
    public int solution(String begin, String target, String[] words){
        if(!Arrays.asList(words).contains(target)) return 0;

        int answer = words.length;
        Set<String> used = new HashSet<>();

        Stack<Word> stack = new Stack<>();
        stack.add(new Word(begin, 0));

        while(!stack.isEmpty()){
            Word now = stack.pop();

            if(now.word.equals(target)){
                return now.depth;
            }

            for(String w : words){
                if(!changeable(now.word, w)) continue;
                if(used.contains(w)) continue;
                //바꿀 수 있는 단어들만 stack에 add(한글자만 다른 단어들)
                //사용하지 않은 단어
                used.add(w);
                stack.push(new Word(w, now.depth+1));
            }
        }
        return 0;
    }

    //word, depth 묶기
    class Word{
        String word;
        int depth;

        public Word(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }

    boolean changeable(String w1, String w2){
        int count = 0;

        for(int i=0; i<w1.length() && count<2; i++){
            if(w1.charAt(i) != w2.charAt(i)) count++;
        }
        return count==1;
    }

}

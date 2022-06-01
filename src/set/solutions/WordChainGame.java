package set.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordChainGame {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "words", "dream", "monster", "tank"};
        System.out.println(wordChainGameCheck(words));
        System.out.println(solution(words));

    }
    static boolean wordChainGameCheck(String[] words){
        //중복 없어야 하고
        if(Arrays.stream(words).distinct().toArray().length!=words.length) return false;
        //순서대로 이어져야 함
        for(int i=0; i<words.length-1; i++){
            if(words[i].charAt(words[i].length()-1)!=(words[i+1].charAt(0))) return false;
        }
        return true;
    }

    static boolean solution(String[] words){
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);

        for(int i=1; i<words.length; i++){
            String w = words[i];
            char first = w.charAt(0);

            if(last!=first) return false; //잘 이어지는지
            if(!set.add(w)) return false; //set은 중복 원소 허용하지 않으므로 중복이면 false

            last = w.charAt(w.length()-1);
        }

        return set.size()==words.length;
    }
}

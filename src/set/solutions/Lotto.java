package set.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static void main(String[] args) {
        int[] lotto = {4, 7, 32, 43, 22, 19};
        System.out.println(LottoNumber(lotto));
        System.out.println(solution(lotto));
        System.out.println(solution2(lotto));
    }

    static boolean LottoNumber(int[] lotto){
        //lotto 배열이 1~45 사이의 중복 없는 숫자를 가지고 있는지 확인한다

        Set<Integer> lottoSet = Arrays.stream(lotto).boxed().collect(Collectors.toSet());
        Set<Integer> numSet = IntStream.range(1, 46).boxed().collect(Collectors.toSet());

        numSet.removeAll(lottoSet);

        //중복 제거했을 때 길이가 6인지
        //1~45 사이인지
        if(numSet.size()==39) return true;
        else return false;
    }

    static boolean solution(int[] lotto){
        boolean[] checker = new boolean[46];
        for(int l : lotto){
            //1~45인지
            if(l < 1 || l > 45) return false;
            //중복 확인
            if(checker[l]) return false;
            //이미 들어간 값 true로 변경
            checker[l] = true;
        }
        return true;
    }

    static boolean solution2(int[] lotto){
        Set<Integer> set = new HashSet<>();
        for(int l : lotto){
            if(l<1 || l>45) return false;
            set.add(l);
        }
        return set.size()==lotto.length;
    }

}

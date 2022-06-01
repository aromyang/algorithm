package map.solutions;

import java.util.*;

public class Pokemon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(pokemonPicker(nums));
        System.out.println(pokemonPicker2(nums));
        System.out.println(solution(nums));
    }

    static int pokemonPicker(int[] nums){
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) map.replace(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        //contains로 확인할 필요 없었음 -> 중요한 건 키의 개수

        int maxNum = nums.length/2;

        if(map.size()>=maxNum) answer=maxNum;
        else answer=map.size();
        //Math.min 메서드로 간단히 확인 가능

        return answer;
    }

    //스트림으로 풀어보기
    static int pokemonPicker2(int[] nums){
        int count =  (int) Arrays.stream(nums)
                .distinct().count();
        return Math.min(count, nums.length/2);
    }

    static int solution(int[] nums){
        //겹치지 않는 요소의 개수와 길이의 절반 중 최소값을 선택해서 리턴한다

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, 0);
        }

        int n1 = map.keySet().size();
        int n2 = nums.length/2;

        return Math.min(n1, n2);
    }

    static int solution2(int[] nums){
        List<Integer> list = new LinkedList<>();

        for(int n : nums){
            if(!list.contains(n)) list.add(n);
        }
        //contains를 통해 계속 확인해야 하기 때문에 복잡도 증가

        int n1 = list.size();
        int n2 = nums.length/2;

        return Math.min(n1, n2);
    }

}


package map.solutions;

import java.util.*;

public class Spy {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}};

        System.out.println(spyClothes(clothes));
    }
    static int spyClothes(String[][] clothes){
        Map<String, Integer> map = new HashMap<>();
        //종류별로 키를 나누고, 키에 해당하는 원소들을 할당함
        for(int i=0; i<clothes.length; i++){
            if(!map.containsKey(clothes[i][1])) map.put(clothes[i][1], 1);
            else map.put(clothes[i][1], map.get(clothes[i][1])+1);
        }

        int count = 1;

        Set<String> keySet = map.keySet();
        for(String key : keySet){
            count *= (map.get(key)+1);
        }

        return count-1;
    }
    static int solution(String[][] clothes){
        Map<String, Integer> map = new HashMap<>();

        for(String[] c : clothes){
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        int count = 1;
        var iter = map.values().iterator();
        while(iter.hasNext()){
            count *= iter.next()+1;
        }

        return count-1;
    }
}

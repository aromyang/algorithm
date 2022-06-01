package map.solutions;

import java.lang.reflect.Array;
import java.util.*;

public class LeftPerson {
    public static void main(String[] args) {
        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};

        System.out.println(leftPerson(participant, completion));
        System.out.println(solution2(participant, completion));

    }
    static String leftPerson(String[] participant, String[] completion){
        Arrays.sort(participant);   //O(nlogn)
        Arrays.sort(completion);    //O(nlogn)

        String one = "";

        //O(n)
        for(int i=0; i<completion.length; i++){
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
            if(i==completion.length-1) one=participant[participant.length-1];
        }

        return one;
    }
    //전체 시간 복잡도 = O(nlogn)

    static String solution(String[] participant, String[] completion) {
        List<String> players = new LinkedList<>();

        for(String p : participant) players.add(p);
        for(String c : completion) players.remove(c);
        //remove 과정에서 c를 찾아야 하므로 복잡도 증가

        return players.get(0);
    }

    static String solution2(String[] participant, String[] completion){
        Map<String, Integer> players = new HashMap<>();

        //participant 배열 값을 키로, 값을 1로 넣어줌
        //같은 String이 나오는 경우 값은 2로 증가
        for(String p : participant){
            players.put(p, players.getOrDefault(p, 0)+1);
        }
        //O(n)

        //completion 배열을 키로 넣어 value에 -1한 값이 0이면 제거하고
        for(String c : completion){
            int n = players.get(c)-1;
            if(n==0) players.remove(c);
            //-1한 값이 0이 아니라면 완주하지 못한 것이므로 삭제 X
            //동명이인인 경우를 고려하기 위해 값을 갱신해서 남겨둠
            else players.put(c, n);
        }
        //O(n)


        return players.keySet().iterator().next();
                //keySet() -> Set<String> 타입 반환
                    //iterator().next()로 key를 얻어옴
        //O(1)
    }
    //전체 시간복잡도 = O(n)

}

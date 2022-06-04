package sorting.solutions;

import java.util.*;

public class StringSorting {
    public static void main(String[] args) {
        String[] strings = new String[]{"sun", "bed", "car"};
        StringSorting s = new StringSorting();
        System.out.println(Arrays.toString(s.stringSorting(strings, 1)));
        System.out.println(Arrays.toString(s.solution(strings, 1)));
    }

    public String[] stringSorting(String[] strings, int n){
        Arrays.sort(strings);
        List<String> list = new ArrayList<>();
        String[] result = new String[strings.length];

        for(int i=0; i<strings.length; i++){
            list.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i).substring(1);
        }

        return result;
    }

    public String[] solution(String[] strings, int n){
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n)==s2.charAt(n)) return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        });
        return strings;
    }


}

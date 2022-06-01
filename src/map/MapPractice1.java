package map;

import java.util.Hashtable;
import java.util.Map;

public class MapPractice1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();

        map.put("A", 1);
        map.put("B", 2);

        map.putIfAbsent("C", 10);

        map.put("A", 2); //같은 키가 추가되는 것이 아니라 같은 키에 값이 덧씌워짐

        map.remove("B", 3); //값이 달라서 안 지워짐

        map.replace("A", 10); //A=10
        map.replace("A", 10, 1); //A=1

        System.out.println("values=" + map.values());
        System.out.println("keys=" + map.keySet());


        System.out.println("map=" + map);

        System.out.println(map.get("A"));
        System.out.println(map.getOrDefault("C", -1));
    }
}

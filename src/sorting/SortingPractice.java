package sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SortingPractice {
    public static void main(String[] args) {
        List<MyData> list = new LinkedList<>();

        Random r  = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(r.nextInt(50)));

        //list.sort(Comparator.naturalOrder());
        //list.sort(Comparator.reverseOrder());
/*
        list.sort(new Comparator<Integer>(){
            @Override
            // 매개인자는 Comparable 상속해야 함
            public int compare(Integer o1, Integer o2) {
                //return o1.intValue()-o2.intValue(); //오름차순
                //내림차순 = o2-o1
                return o2.compareTo(o1); // 내림차순
            }
        });
        */

        //Comparator는 추상 메서드를 한개만 갖는 functional interface이다
        //람다식이 사용 가능하다
        //list.sort((o1, o2) -> o2.compareTo(o1));
        // -> list.sort(Comparator.reversedOrder());

/*        list.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });*/

        //list.sort(Comparator.naturalOrder());


        list = quickSort(list);

        System.out.println(list);
    }

    //quicksort 구현해보기
    static List<MyData> quickSort(List<MyData> list){
        if(list.size() <= 1) return list;
        //pivot 정하기
        MyData pivot = list.remove(0);

        List<MyData> lesser = new LinkedList<>();
        List<MyData> greater = new LinkedList<>();

        for(MyData m : list){
            //pivot보다 작은 값
            if(pivot.compareTo(m) > 0) lesser.add(m);
            else greater.add(m);
        }

        List<MyData> merged = new LinkedList<>();
        merged.addAll(quickSort(lesser)); //-> 오름차순
        merged.add(pivot);
        merged.addAll(quickSort(greater));

        return merged;
    }
}

class MyData implements Comparable<MyData> {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }

    @Override
    public int compareTo(MyData o){
        //return v-o.v;
        return Integer.compare(v, o.v);
    }

}

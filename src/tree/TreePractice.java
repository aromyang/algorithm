package tree;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TreePractice {
    public static void main(String[] args) {
        Set<MyData> set = new TreeSet<>(); // 내부 구현 = binary search tree

        set.add(new MyData(1));
        set.add(new MyData(2));
        set.add(new MyData(3));

        set.add(new MyData(1));
        set.add(new MyData(2));
        set.add(new MyData(3));


        System.out.println(set);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(v, o.v);
    }

}
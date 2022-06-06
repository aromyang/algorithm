package tree;

import java.util.*;

public class HeapPractice {
    public static void main(String[] args) {
        //heap 구현
        //Queue<Integer> queue = new LinkedList<>(); 기본 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //min heap으로 동작(작은 것부터)
        //Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); //max heap

        //PriorityQueue는 항상 최대값/최소값을 유지한다



        Random r = new Random();
        for(int i=0; i<20; i++) queue.offer(r.nextInt(50));

        System.out.println(queue); //배치는 무작위

        List<Integer> sorted = new LinkedList<>();
        while(!queue.isEmpty()) sorted.add(queue.poll()); //poll하면서 작은 순서대로 정렬됨(min heap)
        //heap sort

        System.out.println(sorted);

    }
}


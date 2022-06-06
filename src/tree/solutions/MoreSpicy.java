package tree.solutions;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        MoreSpicy m = new MoreSpicy();

        int[] scoville = new int[]{1, 9, 10, 2, 3, 12};

        System.out.println(m.moreSpicy(scoville, 7));
    }

    public int moreSpicy(int[] scoville, int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) queue.add(s);

        int count = 0;

        while(queue.size() >= 2){
            int first = queue.poll();
            if(first >= K) return count;
            int second = queue.poll();
            int newFood = first + second*2;

            queue.offer(newFood);
            count++;
        }

        if(!queue.isEmpty() && queue.poll() >= K) return count;

        return -1;
    }

}

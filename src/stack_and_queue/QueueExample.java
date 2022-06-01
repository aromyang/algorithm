package stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<6; i++) queue.offer(i);

        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}

//양쪽방향으로 데이터를 추가, 삭제할 수 있는 인터페이스 Deque
class DequeueExample{
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offerFirst(1);
        System.out.println(deque);

        deque.offerLast(2);
        System.out.println(deque);

        deque.offerFirst(3);
        System.out.println(deque);

        deque.offerLast(4);
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);


        //first last 없으면 뒤로 넣고 앞으로 뺀다
        deque.offer(10);
        System.out.println(deque);

        System.out.println(deque.poll());
        System.out.println(deque);

    }

}

class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<6; i++) stack.push(i);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
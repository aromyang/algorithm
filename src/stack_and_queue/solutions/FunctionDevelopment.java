package stack_and_queue.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] progresses2 = {93, 30, 55};
        int[] speeds2 = {1, 30, 5};

        int[] result = functionDevelopment(progresses, speeds);
        int[] result2 = functionDevelopment(progresses2, speeds2);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));


    }

    static int[] functionDevelopment(int[] progresses, int[] speeds) {
        List<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((float)(100 - progresses[i]) / speeds[i]);
            days.add(day);
        }

        System.out.println(days);

        List<Integer> result = new LinkedList<>();

        while (!days.isEmpty()) {
            for (int i = 0; i < days.size(); i++) {
                if (days.get(i) > days.get(0)) {
                    result.add(i);
                    days = days.subList(i, days.size());
                    break;
                }
                if (i == days.size() - 1) {
                    result.add(days.size());
                    days.clear();
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    static int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            float p = progresses[i];
            float s = speeds[i];
            int days = (int) Math.ceil((100-p) / s);
            queue.offer(days);
        }

        Queue<Integer> answer = new LinkedList<>();

        int d = queue.poll();
        int count = 1;

        while(!queue.isEmpty()){
            int n = queue.poll();
            if(d >= n){
                count++;
                continue;
            }
            answer.offer(count);
            count=1;
            d=n;
        }
        answer.offer(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


}

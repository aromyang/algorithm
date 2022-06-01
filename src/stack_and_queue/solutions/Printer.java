package stack_and_queue.solutions;

import java.util.LinkedList;
import java.util.List;

public class Printer {

    public int solution(int[] priorities, int location) {
        List<Paper> wait = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            wait.add(new Paper(priorities[i], i == location));
            //리스트에 우선순위와 뽑아야 할 문서인지가 표시된 Paper 인스턴스를 생성해 넣는다
        }

        int order = 0;

        while (!wait.isEmpty()) {
            //나머지와 비교하기 위해 대기열의 맨 처음 값 뽑아온다
            Paper now = wait.remove(0);
            //지금 뽑을 수 있는지 확인하기 위한 boolean 변수를 선언한다
            boolean printable = true;


            //리스트에 넣은 paper 인스턴스를 하나씩 불러와 비교한다
            for (Paper p : wait) {
                //처음 문서의 우선순위가 제일 크지 않다면 뒤로 밀려야 하므로
                if (now.priority < p.priority) {
                    //뽑을 수 없다고 표시하고
                    printable = false;
                    //for문을 빠져 나간다
                    break;
                }
            }

            //뽑을 수 없다면
            if (!printable) {
                //처음에 얻은 now 값을 제일 뒤로 넣고
                wait.add(now);
                //while문 처음으로 돌아가 반복을 계속한다
                continue;
            }

            //for문과 if문에 걸리지 않은 경우
            //즉 앞에 있던 now가 나머지 wait의 우선순위보다 제일 커서 뽑을 수 있는 경우
            //order에 1을 더해주고
            order++;

            //now를 통해 불러온 isMine이 true라면 order를 리턴하면서 끝낸다
            if(now.isMine) return order;
        }

        return order;
    }

    //검증을 위해 Paper 클래스를 만든다
    class Paper {
        //isMine==true일 경우의 order를 계산해야 한다
        boolean isMine;
        //배열에서 우선순위를 받아오기 위한 변수 선언
        int priority;

        Paper(int p, boolean m) {
            priority = p;
            isMine = m;
        }
    }

    //우선순위 큐를 사용한 풀이 추후 보충
}


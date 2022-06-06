package tree.solutions;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FurthestNode {
    public static void main(String[] args) {

    }

    public int solution(int n, int[][] edge){
        List<Node> list = new ArrayList<>(n);
        for(int i=0; i<n; i++) list.add(new Node(i+1));

        //노드들을 서로 연결한다
        for(int[] e : edge){
            //인덱스 = -1
            Node n1 = list.get(e[0]-1);
            Node n2 = list.get(e[1]-1);

            //연결 상태
            n1.links.add(n2);
            n2.links.add(n1);
        }

        int maxDistance = 0;

        Queue<Node> queue = new LinkedList<>();

        //리스트에서 시작점을 가져와 큐에 넣어주고 방문 상태를 기록한다
        Node first = list.get(0);
        first.visit = true;
        queue.offer(first);


        //모든 노드를 탐색하는 반복
        while(!queue.isEmpty()){
            //노드를 꺼내온다
            Node now = queue.poll();

            //꺼내온 노드의 연결 상태를 확인하는 반복
            for(Node node : now.links){
                //이미 방문했다면 다시 방문하지 않는다
                if(node.visit) continue;

                //방문 상태를 변경해주고
                node.visit = true;
                //거리의 정도를 이전 노드의 거리값에 +1을 해 넣어준다
                node.distance = now.distance + 1;

                //다음 연결 상태를 보기 위해 큐에 노드를 넣어주면서 반복을 계속한다
                queue.offer(node);

                //가장 먼 거리를 찾는 과정
                maxDistance = Math.max(maxDistance, node.distance);
            }
        }


        int answer = 0;

        //최대 거리를 갖는 노드들의 개수를 찾아 리턴한다
        for(Node node : list){
            if(node.distance == maxDistance) answer++;
        }

        return answer;
    }

    class Node{
        int n;
        int distance = 0;
        boolean visit = false;
        List<Node> links = new LinkedList<>();

        Node(int n) {
            this.n = n;
        }
    }
    //클래스를 만드는 게 포인트였다 아직 어렵다
    //클래스 타입을 '왜' 사용하는지에 대해 더 이해하고 익숙해지자

}

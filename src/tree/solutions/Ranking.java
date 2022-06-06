package tree.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ranking {
    public static void main(String[] args) {
        Ranking r = new Ranking();

        int[][] results = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(r.solution(5, results));
    }

    public int solution(int n, int[][] results){
        List<Node> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new Node(i+1));

        for(int[] result : results){
            Node winner = list.get(result[0]-1);
            Node loser = list.get(result[1]-1);
            winner.links.add(loser); //한 방향으로만 -> 방향성
        }

        for(Node winner : list){
            for(Node node : list) node.visit = false;

            Queue<Node> queue = new LinkedList<>();

            winner.visit = true;
            queue.offer(winner);

            while(!queue.isEmpty()){
                Node now = queue.poll();
                for(Node loser : now.links){
                    if(loser.visit) continue;
                    loser.visit = true;

                    queue.offer(loser);
                    winner.win += 1;
                    loser.lose += 1;
                }
            }
        }

        int answer = 0;

        for(Node node : list){
            if(node.win + node.lose == n-1) answer++;
        }

        return answer;
    }

    class Node {
        int n;
        int win = 0, lose = 0;
        boolean visit = false;
        List<Node> links = new LinkedList<>();
        Node(int n) { this.n = n; }
    }

    //접근을 잘못했다.
    //1. 방향성을 가지고 한 방향으로만 연결하고
    //2. win/lose 카운트를 각 노드별로 따로 하는 것이 포인트였다
}

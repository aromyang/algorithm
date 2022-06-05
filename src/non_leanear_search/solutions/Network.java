package non_leanear_search.solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Network {
    public static void main(String[] args) {
        Network n = new Network();
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(n.networks(3, computers));
    }
    public int networks(int n, int[][] computers){
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                count++;
                dfsSearch(computers, i, visited);
            }
        }
        return count;
    }
    public boolean[] dfsSearch(int[][] computers, int index, boolean[] visited){
        visited[index] = true;
        for(int i=1; i<computers.length; i++){
            if(computers[index][i]==1 && !visited[i]){
                dfsSearch(computers, i, visited);
            }
        }
        return visited;
    }

    public int solution(int n, int[][] computers){
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            count++;
            visitAllConnectedComputersBFS(computers, visited, i);
        }
        return count;
    }
    void visitAllConnectedComputersBFS(final int[][] computers, boolean[] visited, int index){
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        while(!q.isEmpty()){
            int i = q.poll();
            visited[i] = true;
            for(int j=0; i<computers[j].length; j++){
                if(visited[j]) continue;
                if(computers[i][j]==1) q.offer(j);
            }
        }
    }
    void visitAllConnectedComputersDFS(final int[][] computers, boolean[] visited, int index){
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while(!stack.isEmpty()){
            int i = stack.pop();
            visited[i] = true;
            for(int j=0; i<computers[j].length; j++){
                if(visited[j]) continue;
                if(computers[i][j]==1) stack.push(j);
            }
        }
    }
}

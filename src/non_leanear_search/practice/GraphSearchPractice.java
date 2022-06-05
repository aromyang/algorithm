package non_leanear_search.practice;

import java.util.*;

class Node {
    String name;
    List<Node> links;
    boolean visited;


    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    void link(Node node) {
        links.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    void visited(){
        this.visited = true;
    }

    boolean isVisited(){
        return this.visited;
    }

}

public class GraphSearchPractice {
    public static void main(String[] args) {
        List<Node> nodes = new LinkedList<>();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        //bfsQueue(a, e);

        //dfsStack(a, e);

    }

    static void bfsQueue(Node start, Node target){
        //bfs
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            n.visited();
            System.out.println(n);

            if (n.equals(target)){
                System.out.println("found " + n);
                break;
            }

            n.links.stream()
                    .filter(l -> !l.isVisited())
                    .filter(l -> !queue.contains(l))
                    .forEach(queue::offer);
        }

    }

    static void dfsStack(Node start, Node target){
        Stack<Node> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            Node n = stack.pop();
            n.visited();
            System.out.println(n);

            if (n.equals(target)){
                System.out.println("found " + n);
                break;
            }

            n.links.stream()
                    .filter(l -> !l.isVisited())
                    .filter(l -> !stack.contains(l))
                    .forEach(stack::push);
        }
    }

}

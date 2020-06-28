package dataStructures.Algorithms;

import java.util.*;

class Edge{
    Map<Integer, List<Integer>> edges = new HashMap<>();
    List<Integer> visited = new ArrayList<>();

    public void addEdge(int node1, int node2){
        add(node1,node2);
        add(node2,node1);
    }

    private void add(int node1, int node2){
        if(edges.get(node1) == null){
            addNode(node1);
        }
        edges.get(node1).add(node2);
    }

    public void addNode(int node){
        edges.put(node,new ArrayList<>());
    }

    public boolean checkConnected(int source, int destination) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);
        while (queue.size() != 0) {
            int edge = queue.poll();
            for (int i = 0; i < edges.get(edge).size(); i++) {
                int currentValue = edges.get(edge).get(i);
                if (destination == currentValue)
                    return true;
                if (!visited.contains(currentValue)) {
                    queue.add(currentValue);
                }
            }
        }
        return false;
    }

}

public class JusPay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Edge edge = new Edge();
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            edge.addNode(in.nextInt());
        }
        for(int i=0;i<n;i++){
            edge.addEdge(in.nextInt(),in.nextInt());
        }
        edge.edges.forEach((k,v) -> {
            System.out.println("key"+k+"value");
            v.forEach(System.out::print);
            System.out.println();
        });
        System.out.println(edge.checkConnected(in.nextInt(),in.nextInt()));
    }
}

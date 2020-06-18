package dataStructures.Graph;

import java.util.ArrayList;
import java.util.List;

class Graph {
    int vertices;
    List<ArrayList<Integer>> adjList;
    Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++)
            adjList.add(i, new ArrayList<>());
    }
    void addEdge(int source, int destination){
        adjList.get(source).add(destination);
    }
    public void findAllPath(int sourse, int destination){
        boolean [] visited = new boolean[vertices];
        visited[sourse] = true;
        ArrayList<Integer> thisList = new ArrayList<>();
        thisList.add(sourse);
        paths(sourse, destination, visited, thisList);
    }

    public void paths(int sourse, int destination, boolean [] visited, ArrayList<Integer> thisList){
        visited[sourse] = true;

        if(sourse == destination){
            System.out.println(thisList);
            visited[sourse] = false;
            return;
        }

        for(Integer edge : adjList.get(sourse)){
            if(!visited[edge]){
                thisList.add(edge);
                paths(edge, destination, visited, thisList);
                thisList.remove(edge);
            }
        }
        visited[sourse] = false;
    }

}
public class AllPaths {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(1,3);
        g.findAllPath(0,3);
    }

}

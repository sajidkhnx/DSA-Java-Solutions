import java.util.*;
import java.util.LinkedList;
public class AllPathsfromStoTo {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
    }
}
static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));    
    }

    public static void printallpaths(ArrayList<Edge>graph[],int src, int dest, String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printallpaths(graph, e.dest, dest, path+src);
        }
    }
public static void main(String[] args) {
    int V = 7; 
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph,V);
    // dfs(graph, 0, new boolean[V]);
    printallpaths(graph, 5, 1, "");
}
}

import java.util.*;
import java.util.LinkedList;
public class BellmanFord {
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

        graph[0].add(new Edge(0, 1, 2)); 
        graph[0].add(new Edge(0, 2, 4)); 

        // 1
        graph[1].add(new Edge(1, 2, -4));

        // 2
        graph[2].add(new Edge(2, 3, 2));
        
        // 3
        graph[3].add(new Edge(3, 4, 4));

        // 4
        graph[4].add(new Edge(4, 1, -1));
    }

public static void bellmanFord(ArrayList<Edge> graph[], int src){
    int dist[] = new int [graph.length];
    for(int i=0; i<dist.length;i++){
        if(i != src){
            dist[i] = Integer.MAX_VALUE;
        }
    }
    int V = graph.length;
        // algo  
        for(int i=0; i<V-1; i++){ 
            
            for(int j=0; j<graph.length;j++){ // har vertex ko nikalo
                 for(int k=0; k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation
                    if(dist[u]!=Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                 }
            } 
        }
        for(int i=0; i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
}
public static void main(String[] args) {
    int V = 5; 
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph,V);
    // dfs(graph, 0, new boolean[V]);
        // System.out.println(hasPath(graph, 0, 7, new boolean[V]));
    bellmanFord(graph, 0);
}
}

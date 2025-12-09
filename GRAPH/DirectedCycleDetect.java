import java.util.*;
import java.util.LinkedList;
public class DirectedCycleDetect {
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

        
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 3, 1)); 
        graph[3].add(new Edge(3, 0, 1));
        

    }

public static boolean isCycle(ArrayList<Edge>[]graph){
    boolean vis[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];
    for(int i=0 ;i<graph.length;i++){
        if(!vis[i]){
            if(isCycleutil(graph,i,vis,stack)){
                return true;
            }
        }
    }
    return false;
}
public static boolean isCycleutil(ArrayList<Edge>[]graph, int curr, boolean vis[], boolean []stack){
    vis[curr] = true;
    stack[curr] = true;
    
    for(int i=0; i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(stack[e.dest]){ // Cycle Exist
            return true;
        }
        if(!vis[e.dest] && isCycleutil(graph, e.dest, vis, stack)){
            return true;
        }
    }
    stack[curr] = false;
    return false;
}

public static void main(String[] args) {
    int V = 7; 
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph,V);
    System.out.println(isCycle(graph)?"Cycle Exist in graph":"Cycle Don't Exist in Graph");
}
}

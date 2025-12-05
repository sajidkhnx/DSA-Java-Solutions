import java.util.*;
import java.util.LinkedList;
public class DetectCycle {
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

        /*
        GRAPH FROM IMAGE
        -----------------

        1
       / \
      /   \
     0 ——— 2
      \
       \
        3 ——— 4

*/

        // Node 0 connections
         graph[0].add(new Edge(0, 1, 1));   // 0 → 1 (wt = 1)
        //  graph[0].add(new Edge(0, 2, 1));   // 0 → 2 (wt = 1)
         graph[0].add(new Edge(0, 3, 1));   // 0 → 3 (wt = 1)

         // Node 1 connections
         graph[1].add(new Edge(1, 0, 1));   // 1 → 0 (wt = 1)
         graph[1].add(new Edge(1, 2, 1));   // 1 → 2 (wt = 1)

         // Node 2 connections
        //  graph[2].add(new Edge(2, 0, 1));   // 2 → 0 (wt = 1)
         graph[2].add(new Edge(2, 1, 1));   // 2 → 1 (wt = 1)

         // Node 3 connections
         graph[3].add(new Edge(3, 0, 1));   // 3 → 0 (wt = 1)
         graph[3].add(new Edge(3, 4, 1));   // 3 → 4 (wt = 1)

         // Node 4 connections
         graph[4].add(new Edge(4, 3, 1));   // 4 → 3 (wt = 1)
        
    }
      


public static boolean detectcyclee(ArrayList<Edge>[]graph){
    boolean vis[] = new boolean [graph.length];
    for(int i =0; i<graph.length;i++){
        if(!vis[i]){
            if(detectcycleutil(graph,vis,i,-1)){
                return true; 
            }
        }
    }
    return false;
}
public static boolean detectcycleutil (ArrayList<Edge>[]graph, boolean vis[], int curr, int par){
    vis[curr] = true;

    for(int i=0; i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        // case 3
        if(!vis[e.dest]){
            if (detectcycleutil(graph, vis, e.dest, curr)){
                return true;
            }
            
        }
        // case 1;
        else if(vis[e.dest] && e.dest!=par){
            return true;
        }
        // case 2 ----> continue

    }
    return false;
}
public static void main(String[] args) {
    int V = 7; 
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph,V);
    System.out.println(detectcyclee(graph)?"Yes It Exist":"No its does Not Exist");
}
}

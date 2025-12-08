import java.util.*;
import java.util.LinkedList;
public class BipartiteGraph {
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

               1 ---- 3
              /        \
             0          5 ---- 6
              \        /
               2 ---- 4
*/

        // 0
   graph[0].add(new Edge(0, 1, 1));
   graph[0].add(new Edge(0, 2, 1));

   graph[1].add(new Edge(1, 0, 1));
   graph[1].add(new Edge(1, 3, 1));

   graph[2].add(new Edge(2, 0, 1));
   graph[2].add(new Edge(2, 4, 1));

   graph[3].add(new Edge(3, 1, 1));
//    graph[3].add(new Edge(3, 4, 1));

   graph[4].add(new Edge(4, 2, 1));
//    graph[4].add(new Edge(4, 3, 1));

    }
public static boolean isBipartite(ArrayList<Edge>[]graph){
    int col[] = new int[graph.length];
    for (int i=0; i<graph.length;i++){
        col[i] = -1; // no color
    }
    Queue<Integer> q = new LinkedList<>();
     for(int i=0; i<graph.length;i++){ // running loop for components like multiple graphs ho agr to gar component se true aana chaiye !!
        if(col[i]==-1){ // BFS
            q.add(i);
            col[i] = 0; // yellow
            while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0 ; j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j); // e.dest
                        if (col[e.dest]==-1){
                            int nextCol =  col[curr]== 0 ? 1:0; // current agar yellow 0 hai toh agale ko 1 dedo
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if (col[e.dest]==col[curr]){
                            return false;
                        }
                    }
            }
        }
     }
    return true;
}
public static void main(String[] args) {
    int V = 7; 
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph,V);
    System.out.println(isBipartite(graph)); 
}
}

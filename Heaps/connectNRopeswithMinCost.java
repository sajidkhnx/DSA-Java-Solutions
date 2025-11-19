import java.util.*;
public class connectNRopeswithMinCost {
    public static void main(String[] args) {
        int  ropes[] = {6,4,3,3,2};
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        // Priority queue matains the heap with accessing the minimal number at first index
        for(int i=0; i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        System.out.println("Priority Quesue Before"+ pq);
        int cost = 0;
        while(pq.size()>1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);
        }
        System.out.println("My Minimum Cost of Rope is "+ cost);
    }
}

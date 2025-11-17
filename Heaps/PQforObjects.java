import java.util.*;
public class PQforObjects {
    static class student implements Comparable<student>{
        String name;
        int rank;
        public student (String name, int rank){
            this.name = name;
            this .rank = rank;
        }

        @Override
        public int compareTo (student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<student> pq = new PriorityQueue<>();
        pq.add(new student("Sajid", 4)); 
        pq.add(new student("Muizz",5 ));
        pq.add(new student("Azim",2));
        pq.add(new student("Wali", 12));

        while (!pq.isEmpty()){
            System.out.println(pq.peek().name+"-->"+pq.peek().rank);
            pq.remove();
        }
    }
}

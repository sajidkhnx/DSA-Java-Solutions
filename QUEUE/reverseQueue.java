import java.util.*;
import java.util.LinkedList;
public class reverseQueue {
    public static void innerreverseQueue(Queue<Integer> q ){
    Stack <Integer> st = new Stack<>();
    while(!q.isEmpty()){
        st.push(q.remove());
    }
    while (!st.isEmpty()) {
        q.add(st.pop());
    }
    }
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.print("FRONT ");
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
          System.out.print(" REAR ");

          System.out.println();
        // AFTER REVERSAL  
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        innerreverseQueue(q);
        System.out.print("FRONT ");
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
          System.out.print(" REAR ");

    }
}

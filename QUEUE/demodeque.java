import java.util.*;
import java.util.LinkedList;

public class demodeque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(7);
        System.out.println(dq); // [2, 1, 7]
    }
}

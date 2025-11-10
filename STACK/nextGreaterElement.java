import java.util.*;
public class nextGreaterElement {
    
    public static int[] nextGreater (int nums1[], int nextgreater[]){
        Stack<Integer> s = new Stack<>();
        int n = nums1.length;
        for(int i=n-1; i>=0;i--){
            while (!s.isEmpty() && (int)s.peek()<=nums1[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nextgreater[i] = -1;
            }
            else{
                nextgreater[i] = (int) s.peek();
            }
            s.push(nums1[i]);           
    }
    return nextgreater;
}

    public static void main (String args[]){
        int nums1 [] = {6,8,0,1,3};  
        int nextgreater[] = new int[nums1.length];
        nextGreater(nums1,nextgreater);
        for(int i = 0;i<5;i++){
            System.out.print("["+nextgreater[i]+"]" );
        }
    }
}

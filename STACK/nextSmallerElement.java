import java.util.*;
public class nextSmallerElement {
    
    public static int[] nextSmaller (int nums1[], int nextSmaller_right[]){
        Stack<Integer> s = new Stack<>();
        int n = nums1.length;
        for(int i=n-1; i>=0;i--){
            while (!s.isEmpty() && nums1[s.peek()] >= nums1[i]){ // ye samj nai aaya 
                s.pop();
            }
            if (s.isEmpty()){
                nextSmaller_right[i] = n;
            }
            else{
                nextSmaller_right[i] = s.peek();
            }
            s.push(i);           
    }
    return nextSmaller_right;
}
    public static int[] nextSmallerleft (int nums1[], int nextSmaller_left[]){
        Stack<Integer> s = new Stack<>();
        int n = nums1.length;
        for(int i=0; i<n;i++){
            while (!s.isEmpty() && nums1[s.peek()] >= nums1[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nextSmaller_left[i] = -1; // ye saamj nahi aya
            }
            else{
                nextSmaller_left[i] =s.peek();
            }
            s.push(i);           
    }
    return nextSmaller_left;
}

    public static void main (String args[]){
        int nums1 [] = {2,1,5,6,2,3};  
        int size = nums1.length;
        int nextSmaller_right[] = new int[nums1.length];
        int nextSmaller_left[] = new int[nums1.length];
        nextSmaller(nums1,nextSmaller_right);
        for(int i = 0;i<size;i++){
            System.out.print("["+nextSmaller_right[i]+"]" );
        }
        System.out.println("");
        nextSmallerleft(nums1,nextSmaller_left);
        for(int i = 0;i<size;i++){
            System.out.print("["+nextSmaller_left[i]+"]" );
        }

        int max_area [] = new int [nums1.length];

        for(int i=0;i<size;i++){

            max_area[i] =  (nextSmaller_right[i] - nextSmaller_left[i] - 1)*nums1[i];
        }
        System.out.println("");
        for(int i = 0;i<size;i++){
            System.out.print("["+max_area[i]+"]" );
        }

        int maxVal = 0;
        for (int i = 0; i < max_area.length; i++) {
           maxVal = Math.max(maxVal, max_area[i]);
        }
        System.out.println("\nMax Area = " + maxVal);
    }
}

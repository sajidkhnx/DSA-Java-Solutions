import java.util.*;
public class Heapfunc{
   static class Heap{ // insertion in heap 
    ArrayList<Integer> arr = new ArrayList<>();
     public void add (int data){
        arr.add(data);
        int x = arr.size()-1; // child  index
        int par = (x-1)/2; // parent index
        while(arr.get(x)<arr.get(par)){// child value < parent  since it is min heap  
         // swap
         int temp = arr.get(x);
         arr.set(x,arr.get(par));
         arr.set(par,temp);
        } // 0(logn)
     }
     public int peek (){
      return arr.get(0);
     }
     public boolean isEmpty() {
            return arr.isEmpty();
      }
     private void heapify(int i){
      int left = 2*i+1;
      int right = 2*i+2;
      int minIdx = i;
      if(left<arr.size()&&arr.get(minIdx)>arr.get(left)){
         minIdx = left;
      }
      if(right<arr.size()&&arr.get(minIdx)>arr.get(right)){
         minIdx = right;
      }
      if(minIdx!=i){
         int temp = arr.get(i);
         arr.set(i,arr.get(minIdx));
         arr.set(minIdx,temp);

         heapify(minIdx);
      }
     } 
     public int remove(){
      int data = arr.get(0);
      // Step 1 : swap first and last
      int temp = arr.get(0);
      arr.set(0,arr.get(arr.size()-1));
      arr.set(arr.size()-1,temp);
      // Step 2 : dalate last
      arr.remove(arr.size()-1);
      // Step 3 : Heapify
      heapify(0);
      return data;
     }
   }
   public static void main(String[] args) {
      Heap h = new Heap();
      h.add(3);
      h.add(4);
      h.add(1);
      h.add(5);

      System.out.println("Elements removed from Min Heap (Sorted Order):");
      while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
      }
   } 
}

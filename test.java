import java.util.*;

public class test{
    
    public static void main (String args[]){
          PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        int nums [] = {1,1,2,3,4,5,3,5,2,2};
        HashMap <Integer,Integer> hp = new HashMap<>();
        /// 1 - 2 // 2 - 3 // 3 - 2 // 4 -1 // 5-2 // 
        for(int i = 0; i<nums.length;i++){
            hp.put(nums[i],hp.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> keys = new ArrayList<>(hp.keySet());

        System.out.println(keys);
        for (int i =0; i<keys.size();i++){
            int key = keys.get(i); // 1
            int val = hp.get(key);
            System.out.println(key+"-->"+ val);
              pq.offer(new int[]{val, key});

            if (pq.size() > 2)
                pq.poll();
        }
       while(!pq.isEmpty()){
             int[] temp = pq.remove();
             System.out.println(Arrays.toString(temp));
             
        }

        // pq = {2,3} {3,1}
        //  int[] result = new int[2];
        //  int i=0;
        //  while(pq.isEmpty()){
        //     result[i] = pq.remove(i)[0]
        //  }
    }
}
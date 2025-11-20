import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int resIndex = 0;
        // 1st Window
        for (int i=0; i<k;i++){
            // remove the smaller values 
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }

        for(int i=k; i<nums.length;i++){
            res[resIndex++] = nums[dq.peekFirst()];
            // remove elements which are not part of curr window
            while(dq.size()>0 && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            // remove the smaller values 
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.add(i);
        }
         res[resIndex] = nums[dq.peekFirst()];
       

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println("Sliding Window Maximums:");
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}

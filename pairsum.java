import java.util.*;
public class pairsum{

    private static int hasPairSum(ArrayList<Integer> list, int target){
        int left=0; int right = list.size()-1;
        int count = 0;
        Collections.sort(list);
        while(left<right){
            
            int sum = list.get(left)+list.get(right);
            if(sum == target){
                count++;
                left++;
                right--;
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
          
    }
      return count;
}

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;
    // if (hasPairSum(list, target)) {
    //         System.out.println("pair exists");
    //     }
    //     else{
    //         System.out.println("pair does not exist");  
    //     }

    System.out.println(hasPairSum(list, target));
        
}
}
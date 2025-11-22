import java.util.*;
public class findItenaryofTickets{
    // public static String getstart(HashMap<String,String> tickets){
    //     HashMap <String,String> revMap = new HashMap<>();
    //     for (String key : tickets.keySet()) {
    //         revMap.put(tickets.get(key),key);
    //     }
    //     // copying the elements int reverse order
    //     for(String key : tickets.keySet()){
    //         if(!revMap.containsKey(key)){
    //             return key;
    //         }   
    //     }
    // }
    public  boolean uniqueOccurrences(int[] arr) {
      
      return true;
    }
    public static void main(String[] args) {
        // HashMap<String,String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");

        int arr [] = {1,1,2,2,1,1,3,4,4,5};
        // System.out.println(uniqueOccurrences(int[] arr));
        HashMap <Integer,Integer>uniques = new HashMap<>();
      for(int i =0; i<arr.length;i++){
        uniques.put(arr[i], uniques.getOrDefault(arr[i], 0)+1);
      }
//       for (Integer key : uniques.keySet()) {
//       System.out.println("Element " + key + " occurs " + uniques.get(key)+ " times");
//       if(uniques.get(key)==1){
//     }
// }
for (int freq : uniques.values()) {
            System.out.println(freq);
        }
    
       
    }
}
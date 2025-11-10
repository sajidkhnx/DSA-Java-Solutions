
import java.util.*;
public class dsa{
    

    // public static int findlastOccur(int[] arr, int k,int i) {
    //     if (i<0) {
    //         return -1;
    //     }
    //     if(arr[i]==k){
    //         return i;
    //     }
    //     return findlastOccur(arr, k, i - 1);
        
    // }
    // public static int findfirstOccur(int[] arr, int k,int i) {
    //     if (i==arr.length) {
    //         return -1;
    //     }
    //     if(arr[i]==k){
    //         return i;
    //     }
    //     return findfirstOccur(arr, k, i + 1);
        
    // }
    // public static void findpermutation (String str, String ans){
    //     if (str.length()==0) {
    //         System.out.println(ans);
    //         return;
    //     }
    //     for (int i = 0; i < str.length(); i++) {
    //         char currchar = str.charAt(i);
    //         String newstr = str.substring(0, i)+str.substring(i+1);
    //         findpermutation(newstr, ans+currchar);
    //     }
    // }
    // public void permute(int[] nums) {
    //     if (nums.length==0) {
    //         array
    //         return;
    //     }
    // }
    public static int fact(int n){
        if (n==0) {
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n*fnm1;
        return fn;
    }

    public static void main(String[] args) {
        int nums = fact(5);
        System.out.println("sajid");
        // int[] arr = {8, 3, 6, 9, 5, 10, 2, 2, 3};
        // int[] arr2 = {8, 3, 6, 9, 5, 10, 2, 2, 3};
        // int k = 2; // Element to find the last occurrence of    
        // System.out.println(findlastOccur(arr, k,arr.length-1));
        // System.out.println(findfirstOccur(arr, k,0));
        // System.out.println(arr+arr2);
        // findpermutation("abc", "");
        
    }
// 7,6
}
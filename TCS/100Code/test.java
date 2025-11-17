import java.util.*;
public class test{
   private static int sumofn(int n,int k,int sum){
    if(n>k){
        return sum ;
    }
    return sumofn(n+1,k,sum+n);
}
    public static void main(String[] args) {
         int sum=0;
         int n =1;
         int k = 5;
       System.out.println(sumofn(n,k,sum));
    }
} // 
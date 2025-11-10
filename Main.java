import java.util.*;

class ArraysExample{
    void multiarray(){
        int[][] arr2  = {{5,5,3},{6,6,7},{9,5,3}};
        for(int j=0 ; j<3;j++){
        for(int k=0; k<3;k++){
            System.out.println(arr2[j][k]+"\n");
        }
    }
    }
    void demoArrays(){
        int sum =0;
        int[] arr1  = new int[5];
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the numbers");
        for (int i=0;i<=4;i++){
            int j = sc.nextInt();
            arr1[i] = j;
        }
        // int j = sc.nextInt();
        int max=0;
        for (int i=1;i<=4;i++){
             max = arr1[0] ;
            if(arr1[i]>max){
                max=arr1[i];
            }
            System.out.println(max);

            // sum = sum +  arr1[i];
            // System.out.println("\n"+arr1[i]);
            // System.out.println("\nSUM ="+ sum);

        }
        System.out.println(max);
        
        
        
    }
}    


public class Main {
    public static void main (String[] args){
    ArraysExample obj = new ArraysExample();
    obj.demoArrays();
    // obj.multiarray();   
}
}
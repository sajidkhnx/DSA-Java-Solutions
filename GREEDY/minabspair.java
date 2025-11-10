import java.util.*;
// MINIMUM SUM ABSOLUTE DIFFRENCE 
public class minabspair{
    public static void main(String[] args) {
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};
        Arrays.sort(A); // SORT KRNE SE MINIMUM GAPS MILENGE TOH EASY HOGA
        Arrays.sort(B);
        int minVal = 0;

        for (int i=0; i<A.length;i++){
            minVal += Math.abs(A[i] - B[i]);
        }
        System.out.println("Minimum Pair Value = "+ minVal);
    }
    
}
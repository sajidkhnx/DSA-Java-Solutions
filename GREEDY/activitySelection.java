import java.util.*;

public class activitySelection {
    public static void main (String args[]){
        int [] start = {1,3,0,5,8,5};
        int [] end = {2,4,6,7,9,9};
        int count = 1; // ek activity toh hogi hi na bhai
        // manle end time sorted nai hai to problem hogi isiliye sort krle
        int activities [][] = new int[start.length][3];
        for(int j = 0; j<start.length;j++){
            activities[j][0] = j;
            activities[j][1] = start[j];
            activities[j][2] = end[j];
        }                                                              
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int lastEnd = activities[0][2];
        for (int i=1; i<start.length; i++){
            if (activities[i][1]>lastEnd){
                count++;
                lastEnd = activities[i][2];
            }
        }

        System.out.println(count);
    } 
}

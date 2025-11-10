// import java.util.*;
// public class jobSequencingProblem {

//     public static void main(String[] args) {
//         int jobsInfo [][]= {{4,20},{1,10},{1,40},{1,30}};
//         Arrays.sort(jobsInfo, Comparator.comparingInt(o -> o[1]));
//         // 1,40  1,30  4,20  1,10
//         // 1,10 4,20 1,30 1,40 
//         // time = 2
//         int time = 0;
//         int n = jobsInfo.length;
//         int maxprofit = 0 ;
//         int deadline = jobsInfo[n-1][0]; // 1

//         for (int i=n-1; i>=0; i--){
//             deadline = jobsInfo[i][0];
//             if (time<deadline){ // 1 < 4
//                 time++;
//                 maxprofit += jobsInfo[i][1]; // 40 
                
//             }
//              // 4
          
//         }
//         System.out.println("Max Profit  = "+ maxprofit);
//     }
// }

import java.util.*;
public class jobSequencingProblem{
    public static class Jobs {
        int deadline ;
        int Profit ;
        int id;
        public Jobs(int i, int d , int p){
            id = i;
            deadline = d;
            Profit = p;
        }
    }
    public static void main(String[] args) {
         int jobsInfo [][]= {{4,20},{1,10},{1,40},{1,30}};

         ArrayList<Jobs> jobs = new ArrayList<>();

         for (int i=0 ; i<jobsInfo.length; i++){
            jobs.add(new Jobs(i, jobsInfo[i][0], jobsInfo[i][1]));
         }

         Collections.sort(jobs, (obj1 ,obj2) -> obj2.Profit-obj1.Profit);
         int time = 0;
         int maxprofit = 0;
         for(int i = 0 ; i<jobs.size();i++){
            Jobs curr = jobs.get(i);
            if(curr.deadline>time){
                time++;
                maxprofit+=curr.Profit;
            }
         }
         System.out.println( "Max Profit will be "+maxprofit);
    }
}
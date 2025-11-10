// import java.util.*;
// public class lemondeChange {
//     public static void main(String[] args) {
//         int bill []= {5,5,10,10,20};
//         int balance  = 0;
//         int change = 0;
//         boolean change_possible = true;
//         for (int i =0; i<bill.length;i++){
//             if (bill[i] == 5){
//                 balance += bill[i]; // 10 
//             }
//             else if(bill[i]== 10 ){
//                 change = bill[i] - 5; // 10-5=5
//                 if(balance<change){ // 15<5
//                     change_possible = false;
//                     break; if{
//                         i +1 % 2 
//                     }
//                 }
//                 balance = balance + (bill[i]); // 5+5 + 10+ = 20 and 15+10 = 25
//                 balance = balance - change; // 25 - 5 = 20 {BALANCE}
//             }
//             else {
//                  change = bill[i] - 5; // 20-5 = 15
//                 if(balance<change){ // 20<15
//                     change_possible = false;
//                     break;
//                 }
//                 balance = balance + (bill[i]); // 20 + 20 = 40
//                 balance = balance - change; // 40 -15 = 25 ans
//             }
//         }
//         System.out.println(change_possible);
//         System.out.println(balance);
//     }
// }
import java.util.*;

public class LemonadeChange{

    public static boolean lemondeChange(int[] bills) {
        int five = 0;   // count of $5 bills
        int ten = 0;    // count of $10 bills

        for (int bill : bills) {
            if (bill == 5) {
                five++; // we just gain a $5
            } 
            else if (bill == 10) {
                if (five == 0) return false; // no $5 to give as change
                five--; // give $5
                ten++;  // gain a $10
            } 
            else { // bill == 20
                // Prefer giving one $10 and one $5 as change if possible
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } 
                // Otherwise, give three $5 bills
                else if (five >= 3) {
                    five -= 3;
                } 
                else {
                    return false; // cannot make change
                }
            }
        }
        return true;
    }
     public static void main(String[] args) {
        int bills[] = {5, 5, 10, 10, 20};
        System.out.println(lemondeChange(bills));
    }
}

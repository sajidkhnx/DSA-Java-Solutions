import java.util.*;
public class duplicateParenthesis {
    public static boolean containsDuplicate(String str){
        int n = str.length();
        Stack<Character> st =  new Stack<>();
        for(int i=0; i<n;i++){
            char ch = str.charAt(i);

            // If closing bracket found
            if(ch == ')'){
                int count = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    st.pop();
                    count++;
                }
                st.pop(); // pop the '('

                // If there was nothing or only one element inside ()
                if(count < 1){
                    return true;
                }
            } else {
                st.push(ch); // push all other characters
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String str = "((a+b))";
        String str2 = "(a+b)";
        System.out.println(containsDuplicate(str)? "Contains Duplicate" : "No Duplicate Found");
        System.out.println(containsDuplicate(str2)? "Contains Duplicate" : "No Duplicate Found");
    }
}

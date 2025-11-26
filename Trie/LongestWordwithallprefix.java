public class LongestWordwithallprefix {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static String ans = "";
    public static void longestword(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i = 0; i<26;i++){
            if(root.children[i]!=null && root.children[i].eow ==true){
                char ch = (char)(i+'a'); // indx store hai bhai toh character mein kardo
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans =temp.toString();
                }
                longestword(root.children[i], temp);
                // Backtrack
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl","ap","apply","apple"};
        // Insert all words
        for (String w : words) {
            insert(w);
        }
        longestword(root, new StringBuilder(""));
        System.out.println(ans);

    }
}

public class startswithaProblem {

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
    // new fucnt
    public static boolean startswith(String prefix){
        Node curr = root;
        for(int level=0;level<prefix.length();level++){
            int idx = prefix.charAt(level) - 'a';
            if(curr.children[idx]==null){
            return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man","woman"};
        // Insert all words
        for (String w : words) {
            insert(w);
        }
        System.out.println(startswith(("dsa")));
    }
}

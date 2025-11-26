public class prefixtrie {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // 🔥 Function to find shortest unique prefix
    public static String uniquePrefix(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            prefix.append(word.charAt(i));
            curr = curr.children[idx];

            if (curr.freq == 1) {  // unique prefix found
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] words = {"zebra", "dog", "duck", "dove"};

        // Insert all words
        for (String w : words) {
            insert(w);
        }

        // Print unique prefixes
        System.out.println("Unique prefixes:");
        for (String w : words) {
            System.out.println(w + " -> " + uniquePrefix(w));
        }
    }
}

package TextProcessing;

public class UsingTries {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("Abhya");
        trie.add("Amiya");
        trie.add("Ashish");
        trie.add("Ayush");
        trie.add("Aryan");
        trie.add("Abha");
        trie.add("Ravi");
        trie.add("Sid");
        trie.add("Saurabh");
        trie.display();
        System.out.println(trie.search("Sid"));
        System.out.println(trie.search("Amiya"));
        System.out.println(trie.search("HyperLoop"));
        trie.add("HyperLoop");
        System.out.println(trie.search("HyperLoop"));
    }
}

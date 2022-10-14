package TextProcessing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {

    private class Node{
        private char data;
         HashMap<Character , Node> children;
        private boolean isTerminal;

        Node(char data ,boolean isTerminal){
            this.data=data;
            this.children = new HashMap<>();
            this.isTerminal=isTerminal;
        }

    }
    private Node root ;
    private int numberOfWord;
    Trie(){
        this.root=new Node('\0',false);
        this.numberOfWord=0;
    }

    public void add(String word){
        this.add(word,root);

    }
    private  void add(String word , Node parent){
        if(word.length()==0){
            if(parent.isTerminal){
                //already a word nothing to do
            }else{
                parent.isTerminal=true;
                this.numberOfWord++;
            }
            return;
        }
        char cc=word.charAt(0);
        String ros = word.substring(1);
        Node newNode = parent.children.get(cc);
        if(newNode==null){
            newNode=new Node(cc,false);
            parent.children.put(cc,newNode);
        }
        this.add(ros,newNode);
    }
    public void display(){
        this.display(this.root,"");
    }
    private void display(Node parent,String ofs){
        if(parent.isTerminal){
            String toDisplay = ofs.substring(1)+parent.data;
            System.out.println(toDisplay);
        }
        Set<Map.Entry<Character,Node>> entries = parent.children.entrySet();

        for (Map.Entry<Character,Node> entry:
             entries) {
            this.display(entry.getValue(),ofs+parent.data);

        }

    }
    public boolean search(String word){
        return this.search(word,this.root);

    }
    private boolean search(String word , Node parent){
        if(word.length()==0){
            return parent.isTerminal;
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if(child==null){
            return false;
        }
        return this.search(ros,child);
    }
    private void remove(String word , Node parent ){
        if(word.length()==0){
            if(parent.isTerminal){
                parent.isTerminal=false;
                this.numberOfWord--;
            }
            else{
                //word doesn't exist
            }
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if(child==null){
            return;
        }
        this.remove(ros,child);

        if(!parent.isTerminal&&child.children.size()==0){
            parent.children.remove(cc);
        }
    }

}

package CostumTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
    private class Node{
        int data;
        ArrayList<Node> children ;
        Node(int data){
            this.data =data;
            this.children = new ArrayList<>();
        }
    }
    private Node root;
    private int size;
    GenericTree(){
        Scanner s = new Scanner(System.in);
        this.size=0;
        this.root=takeInput(s , null,0);

    }

    private Node takeInput(Scanner s, Node parent, int ithChild) {
        if(parent==null){
            System.out.println("Enter the Data for root node");
        }else {
            System.out.println("Enter the data for " + ithChild+ "th child of " + parent.data);
        }
        int data = s.nextInt();
        Node node = new Node(data);
        this.size++;

        System.out.println("Enter the number of children for" + node.data);
        int k = s.nextInt();
        for (int i = 0; i < k; i++) {
            node.children.add(this.takeInput(s,node,i+1));
        }
        return node;

    }
    public void display(){
        this.display(root);
    }
    private void display(Node node){
        System.out.print(node.data + "=>");
        for (int i = 0; i < node.children.size(); i++) {
            System.out.print(node.children.get(i).data+", " );
        }
        System.out.println("END.");
        for (int i = 0; i < node.children.size(); i++) {
            display(node.children.get(i));
        }
    }
    public int size(){
        return size(root);
    }
    public int getSize(){
        return size;
    }
    private int size(Node node){
        int size = 0;
        for(int i = 0;i<node.children.size();i++){
            size = size+size(node.children.get(i));
        }
        return size+1;
    }
    private int max(Node node){
        int tm = node.data;
        for (Node child:
             node.children) {
            int cm = max(child);
            if(cm > tm ){
                tm = cm;
            }

        }
        return tm;
    }
    private boolean find(Node node,int x){
        if(node.data==x){
            return true;
        }
        for (Node child:
                node.children){
            boolean ans = find(child,x);
            if(ans)
                return true;
          //  ans = ans||find(child,x);
//            ans = find(child,x);
//            if(ans)
//                break; //this is also a working code
        }
        return false;
    }
    private int height(Node node){
        int mHeight = 1;
        for (Node child :
                node.children) {
            int cHeight= height(child);
            mHeight=Math.max(cHeight,mHeight);
        }
        return mHeight;
    }

}

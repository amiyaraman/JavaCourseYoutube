package CostumTree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class CustomBinaryTree {
    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
        Node(){

        }
    }
    private Node root;
    private int size;
    CustomBinaryTree(){
        Scanner s =new Scanner(System.in);
        this.root=takeInput(s , null,false);

    }

    private Node takeInput(Scanner s, Node parent, boolean isLeftChild) {
        if (parent==null){
            System.out.println("Enter data for root node");
        }
        else{
            if(isLeftChild){
                System.out.println("Enter data for left child of " + parent.data);
            }
            else {
                System.out.println("Enter data for right child of " + parent.data);
            }


        }
        int data = s.nextInt();
        Node node = new Node(data);
        size++;

        boolean choice = false;
        System.out.println("Do the node have a left child of  " + node.data + " ?");
        choice=s.nextBoolean();
        if(choice){
            node.left=takeInput(s,node,true);

        }
        choice = false;
        System.out.println("Do the node have a right child " + node.data + " ?");
        choice=s.nextBoolean();
        if(choice){
            node.right=takeInput(s,node,false);

        }
        return node;


    }
    public void display(){
        this.display(root);
    }
    private void display(Node node){
        if(node.left!=null){
            System.out.print(node.left.data+" => ");
        }else {
            System.out.print("END => ");
        }
        System.out.print(node.data);
        if(node.right!=null){
            System.out.println(" <= "+node.right.data);
        }
        else{
            System.out.println(" <= END. ");
        }
        if (node.left!=null){
            display(node.left);
        }if (node.right!=null){
            display(node.right);
        }

    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return -1;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return Math.max(lHeight,rHeight)+1;
    }
    public void preOrder(){
        System.out.print("[ ");
        preOrder(root);
        System.out.println("End]");
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + ",");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(){
        System.out.print("[ ");
        postOrder(root);
        System.out.println("End]");
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + ",");
    }
    public void inOrder(){
        System.out.print("[ ");
        inOrder(root);
        System.out.println("End]");
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + ",");
        inOrder(node.right);

    }
    private ArrayList<Node> ans = new ArrayList<>();
    private void inOrder1(Node node){
        if(node == null){
            return;
        }
        inOrder1(node.left);
        ans.add(node);
        inOrder1(node.right);


    }
    public void solve(){
        inorderSuccessor(root,root);
    }
    public Node inorderSuccessor(Node root,Node x)
    {
        inOrder1(root);
        for (int i = 0 ; i<ans.size();i++) {
            if(ans.get(i).data==x.data){
                return ans.get(i+1);
            }

        }
        return null;


    }
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.print("[");
        while (!q.isEmpty()){
            Node n = q.remove();
            System.out.print(n.data+",");
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
        System.out.println("End]");
    }
    public boolean isBST(){
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isBST(Node node,long min , long max){
        if(node==null){
            return true;
        }
        if(node.data<min||node.data>max){
            return false;
        }
        if(!isBST(node.left, min, node.data)){
            return false ;
        }
        if(!isBST(node.right,  node.data,max)){
            return false ;
        }
        return true;

    }
    public ArrayList<Integer> iterativeInOrder(){
        return iterativeInOrder(root);
    }
    private ArrayList<Integer> iterativeInOrder(Node node){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = node;
        stack.push(temp);
        while(true){
            if(temp!=null){
               stack.push(temp);
               temp=temp.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                else{
                    list.add(stack.pop().data);
                    temp=temp.right;
                }
            }

        }
        return list;
    }
    public int diameterOfTree(){
        return diameterOfTreeOptimised(root).diameter;
    }
    private int diameterOfTree(Node node){
        if(node==null){
            return 0;
        }
        int case1 = height(node.left)+height(node.right)+2;
        int case2 = diameterOfTree(node.left);
        int case3 = diameterOfTree(node.right);

        return Math.max(case1,Math.max(case2,case3));
    }

    private DiaPair diameterOfTreeOptimised(Node node){
        if(node == null){
            return new DiaPair(-1,0);
        }

        DiaPair lp = diameterOfTreeOptimised(node.left);
        DiaPair rp = diameterOfTreeOptimised(node.right);

        DiaPair mp =new DiaPair();
        mp.height = lp.height+rp.height+1;
        mp.diameter= Math.max(lp.diameter, Math.max(lp.height+rp.height+2,rp.diameter));
        return mp;


    }
    class DiaPair{
        int height;
        int diameter;
        DiaPair(){}
        DiaPair(int height , int diameter){
            this.diameter=diameter;
            this.height = height;
        }
    }
    public int sumOfLeafNode(){
        return sumOfLeafNode(root);
    }
    private int sumOfLeafNode(Node node){
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return node.data;
        }
        else{
            int curLSum=sumOfLeafNode(node.left);
            int curRSum = sumOfLeafNode(node.right);
            return curRSum+curLSum;
        }


    }
    public int sumOfLeftLeaves(Node node){
        if(node==null){
            return 0;
        }
        int rSum=0;
        if(isLeafNode(node.left)){
            rSum=  sumOfLeftLeaves(node.right);
            return node.left.data;

        }
        int lSum = sumOfLeftLeaves(node.left);

        return lSum+rSum;
    }
    private boolean isLeafNode(Node node){
        if(node ==null ){
            return false;
        }
        return node.left == null && node.right == null;
    }
    class BalancedPair{
        boolean isBalanced;
        int myHeight;
        BalancedPair(){
            this.isBalanced=false;
            this.myHeight=-1;
        }
        BalancedPair(boolean isBalanced,int myHeight){
            this.isBalanced=isBalanced;
            this.myHeight=myHeight;
        }
    }
    private BalancedPair isBalanced(Node node) {
        if(node==null){
            return new BalancedPair();
        }
        BalancedPair lbp = isBalanced(node.left);
        BalancedPair rbp = isBalanced(node.right);
        int bf = lbp.myHeight - rbp.myHeight;
        int cHeight = Math.max(lbp.myHeight,rbp.myHeight)+1;


        if(bf == 0 || bf == -1||bf == 1){
            return new BalancedPair(lbp.isBalanced && rbp.isBalanced,cHeight);
        }
        else{
            return new BalancedPair(false,cHeight);
        }
    }
    public boolean flipEquiv(Node root1, Node root2) {
        if(root1==null&&root2==null){
            return true;
        }
        // if(root1==null&&root2!=null){
        //     return false;
        // }
        // if(root2==null&&root1!=null){
        //     return false;
        // }
        if(root1==null|root2==null){
            return false;
        }
        if(root1.data!=root2.data){
            return false;
        }
        boolean ll =flipEquiv(root1.left,root2.left);
        boolean rr = flipEquiv(root1.right,root2.right);
        if(ll&&rr){
            return true;
        }
        boolean lr = flipEquiv(root1.left,root2.right);
        boolean rl = flipEquiv(root1.right,root2.left);

        return (lr&&rl);

    }
    private int treeSum(Node node){
        if(node == null){
            return  0 ;
        }
        int ls = treeSum(node.left);
        int rs = treeSum(node.right);

        return ls + rs + node.data;

    }
    private   int max = Integer.MIN_VALUE;
    public  int largestSubtreeSum(Node root){
        largestSubtreeSum1(root);
        return max;
    }

    public  int largestSubtreeSum1(Node root){
        if(root==null){
            return 0;
        }
        int ls = largestSubtreeSum1(root.left);
        int rs = largestSubtreeSum1(root.right);
        if(ls+rs+root.data>max){
            max = ls+ rs + root.data;
        }
        return ls+ rs + root.data;

    }
    public CustomBinaryTree(int[] pr,int[] in){
        root = constructor( pr,  0 , pr.length-1 , in,0,in.length-1);
    }

    private Node constructor(int[] pr, int prLo, int prH, int[] in, int inLo, int inH) {
        int element=pr[prLo];
        Node nn = new Node();
        nn.data  = element;

        int si=-1;

        int sIndex = 0;
        for(int i = 0 ;i<inH;i++){

            if(in[i]==element){
                si=i;
                break;
            }
            sIndex++;
        }
        nn.left = constructor(pr , prLo+1,prLo+sIndex,in,inLo,sIndex-1);
        nn.right = constructor(pr , prLo+sIndex+1,prH,in,sIndex+1,inH);

        return nn;
    }
    private int max (Node node){
        if(node.right==null){
            return node.data;
        }

        return max(node.right);
    }
    private Node deleteNode(Node Parent,boolean ilc , Node node , int k){
        if(k>node.data){
            deleteNode(node,false,node.right,k);
        }else if(k<node.data){
            deleteNode(node,true,node.left,k);
        }
        else{
            if(node.left==null&&node.right==null){
                if(ilc){
                    Parent.left = null;

                }else{
                    Parent.right=null;
                }
            }else if(node.left!=null&&node.right==null){
                if(ilc){
                    Parent.left = node.left;

                }else{
                    Parent.right=node.left;
                }

            } else if(node.left==null&&node.right!=null) {
                if(ilc){
                    Parent.left = node.right;

                }else{
                    Parent.right=node.right;
                }

            }else{
                int max= max(node.left);
                node.data=max;
                deleteNode(node,true,node.left,max);

            }

        }
        return node;
    }
    public static void leftView(Node node){
        List<Node> mainList = new ArrayList<>();
        Queue<Node> ls = new LinkedList<>();
        Queue<Node> ls2 = new LinkedList<>();
        ls2.add(node);
        while (!ls2.isEmpty()){

            ls =ls2;
            ls2 = new LinkedList<>();
            mainList.add(ls.peek());
            while (!ls.isEmpty()){
                Node nn = ls.remove();
                if(nn.left!=null){
                    ls2.add(nn.left);
                }
                if(nn.right!=null){
                    ls2.add(nn.right);
                }
            }
        }
    }
}
//class LeetCodeQuestion {
//    public TreeNode deleteNode(TreeNode root, int key) {
//        // if(root == null){
//        //     return null;
//        // }
//        return deleteNode2(null,false,root,key);
//
//
//    }
//    private int max (TreeNode node){
//        if(node.right==null){
//            return node.val;
//        }
//
//        return max(node.right);
//    }
//    private TreeNode deleteNode2(TreeNode Parent, boolean ilc , TreeNode node , int k){
//        if(node==null){
//            return null;
//        }
//        if(k>node.val){
//            deleteNode2(node,false,node.right,k);
//        }else if(k<node.val){
//            deleteNode2(node,true,node.left,k);
//        }
//        else{
//            if(node.left==null&&node.right==null){
//                if(Parent == null){
//                    return null;
//                }
//                else{
//                    if(ilc){
//                        Parent.left = null;
//
//                    }else{
//                        Parent.right=null;
//                    }
//
//                }
//
//            }else if(node.left!=null&&node.right==null){
//                if(Parent==null){node =node.left;
//
//                }
//                else{
//                    if(ilc){
//                        Parent.left = node.left;
//
//                    }else{
//                        Parent.right=node.left;
//                    }
//                }
//
//
//            } else if(node.left==null&&node.right!=null) {
//                if(Parent==null){
//                    node=node.right;
//                }else{
//                    if(ilc){
//                        Parent.left = node.right;
//
//                    }else{
//                        Parent.right=node.right;
//                    }
//                }
//
//
//            }else{
//
//                int max= max(node.left);
//                node.val =max;
//                deleteNode2(node,true,node.left,max);
//
//
//
//            }
//
//        }
//        return node;
//    }
//}



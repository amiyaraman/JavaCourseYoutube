package CostumTree;

public class UsingZoneBinaryTree {
    public static void main(String[] args) {
        CustomBinaryTree tree=new CustomBinaryTree();
        tree.display();
       // System.out.println(tree.isBST());
      //  tree.levelOrder();
        System.out.println(tree.sumOfLeafNode());
        tree.solve();
    }
}
// 50 true 25 true 38 false false true 48 true 18 false false false true  45 true 85 false false true 60 false false
//50 true 25 true 13 false false true 48 true 18 false false false true  45 true 85 false false true 60 false false
//2 true 1 false false true 3 false false

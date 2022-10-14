package CostumTree;

public class UsingGenericTree {
    public static void main(String[] args) {
        //GenericTree tree = new GenericTree();
        //tree.display();
       // System.out.println(tree.size());
      //  System.out.println(tree.getSize());
        MyTesting m = new MyTesting();
         MyTesting.myStaticClass ms  = new MyTesting.myStaticClass();
        MyTesting.myStaticClass ms2  = new MyTesting.myStaticClass();
        System.out.println(ms.nst);
        ms.nst="Other";
        System.out.println(ms.nst);
        System.out.println(ms2.nst);

    }
}
class MyTesting{
    public static String s = "This is a class Static variable";
    public static int abns = 10;
    String ns = "Non_static";

    static class myStaticClass{
          String nst  = "Non-Static class";
        public  void myStaticClassFunction(){
            System.out.println(nst);
            System.out.println(s);

        }
    }
    public void MyTestingFunction(){
        System.out.println(s);
        System.out.println(ns);
    }

}
//Input
//60 3 41 2 17 0 16 0 15 1 21 0 24 2 33 0 84 0
//10 3 20 2 50 0 60 0 30 0 40 2 10 1 23 0 13 1 12 0
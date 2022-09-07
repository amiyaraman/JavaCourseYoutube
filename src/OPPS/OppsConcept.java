package OPPS;

 class OppsConcept{


    public static void main(String[] args) {
        c obj1 = new c();
        c obj3 = obj1;
        System.out.println(obj1+","+obj3);

        p obj2 = new c();
        obj1=new c();
        System.out.println(obj1+","+obj3);

        System.out.println(obj2.d);
        System.out.println(obj1.d);
        System.out.println(((c)obj2).d2);
        obj3.d2=213;
        System.out.println(obj1.d2);

        obj1.fun3();
        obj2.fun1();

    }

}
class c extends p{
     int d = 12;
     int d2 = 1020;
     void fun(){
         System.out.println("hello its fun");
     }

     void fun3(){
         System.out.println("Hello it's fun3");

     }
}

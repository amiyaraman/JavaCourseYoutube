package CostumLinkedList;

public class UsingMyLinkedList {
    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        //linkedList.display(); this will throw exception

        linkedList.addFirst(10);

        linkedList.addFirst(-10);
        linkedList.addFirst(-20);
        linkedList.addFirst(-30);
        linkedList.addLast(0);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);

        linkedList.addAt(3,6);

        linkedList.display();
        System.out.println(linkedList.getMid());
        linkedList.reverseLinkedListPointer();
        linkedList.display();
        System.out.println(linkedList.getMid());

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.removeAt(4);

        linkedList.display();
        System.out.println(".."+linkedList.kThNodeFromLast(2));
        linkedList.reverseLinkedList();
        linkedList.display();
        System.out.println(linkedList.getMid());


    }
}

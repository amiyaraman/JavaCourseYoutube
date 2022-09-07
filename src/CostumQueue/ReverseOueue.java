package CostumQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOueue {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        System.out.println(q);
        reverseQueue(q);
        System.out.println(q);



    }
    public static void reverseQueue( Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int element = q.remove();
        reverseQueue(q);
        q.add(element);
    }
}

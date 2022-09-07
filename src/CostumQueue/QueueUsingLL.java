package CostumQueue;

import java.util.LinkedList;

public class QueueUsingLL {
    LinkedList<String> queue ;

    QueueUsingLL(){
        queue=new LinkedList<>();
    }
    QueueUsingLL(String data){
        queue=new LinkedList<>();
        queue.addLast(data);
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void enqueue(String data){
        queue.addLast(data);
    }
    public void dequeue(){
        queue.removeFirst();
    }
    public String getFront(){
        return queue.getFirst();
    }

    public static void main(String[] args) {
        QueueUsingLL queue=new QueueUsingLL();
        for(int i =0 ; i<10;i++){
            queue.enqueue("Amiya"+ (i+1));
        }

        queue.enqueue("A<safa");
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getFront());
    }


}

package CostumQueue;

import java.util.Stack;

public class QueueUsingTwoStack {
    public static void main(String[] args) {
        PushEfficientQueue queue = new PushEfficientQueue();
        for (int i =1 ;i<6;i++){
            queue.enqueue(i*10);
        }
        System.out.println(queue.getFirst());
        queue.display();
        queue.display();
        queue.deque();
        queue.deque();
        queue.display();
    }
}
class PushEfficientQueue{
    private Stack<Integer> primary = new Stack<>();
    private  Stack<Integer> secondary = new Stack<>();

    public void enqueue(int data){
        primary.push(data);
    }
    public int deque(){
        while (primary.size()!=1){
            int element = primary.pop();
            secondary.push(element);
        }
        int element=primary.pop();
        while (!secondary.isEmpty()){
            int a = secondary.pop();
            primary.push(a);
        }
        return element;

    }
    public int getFirst(){
        while (primary.size()!=1){
            int element = primary.pop();
            secondary.push(element);
        }
        int element = primary.peek();
        while (!secondary.isEmpty()){
            int a = secondary.pop();
            primary.push(a);
        }
        return element;

    }
    public void display(){
        reverserStack(primary,secondary,0);
        while(!primary.isEmpty()){
            int element = primary.pop();
            System.out.print(element+" => ");
            secondary.push(element);
        }
        System.out.println();
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        reverserStack(primary,secondary,0);


    }
    public boolean empty() {
        return primary.isEmpty()&&secondary.isEmpty();

    }
    private void reverserStack(Stack<Integer> primary,Stack<Integer> secondary , int index ){
        if (primary.isEmpty()){
            return;
        }
        int element = primary.pop();
        reverserStack(primary, secondary, index+1);
        secondary.push(element);
        if(index==0){
            while (!secondary.isEmpty()){
                int a =secondary.pop();
                primary.push(a);
            }
        }
    }
}
 class PopEfficientQueue
{
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static void enQueue(int x)
    {
        while (!s1.isEmpty())
        {
            s2.push(s1.pop());

        }

        s1.push(x);


        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
            //s2.pop();
        }
    }


    static int deQueue()
    {
        if (s1.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        int x = s1.peek();
        s1.pop();
        return x;
    }
}

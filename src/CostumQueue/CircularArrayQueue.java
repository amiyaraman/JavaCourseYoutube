package CostumQueue;

public class CircularArrayQueue {
    private int[] arr;
    private int cs;
    private int mc;
    private int front;
    private int rear;

    private static final int DEFAULT_CAPACITY=10;

    CircularArrayQueue(){
        this(DEFAULT_CAPACITY);
    }
    CircularArrayQueue(int capacity){
        this.arr = new int[capacity];
        this.front=0;
        this.rear=capacity-1;
        this.mc=capacity;
        this.cs=0;
    }

    public boolean isEmpty() {
        return this.cs == 0;
    }
    public boolean isFull(){
        return this.cs==this.mc;
    }
    public int size(){
        return this.cs;
    }

    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("Overflow");
            return;
        }
        this.rear=(this.rear+1)%this.arr.length;
        this.arr[this.rear]=data;
        this.cs=cs+1;
    }
    public void dequeue(){
        if(this.isEmpty()){
            System.out.println("Underflow");
            return;
        }
        System.out.println("Removing value:"+this.arr[this.front]);
        this.front=(this.front+1)%this.arr.length;
        this.cs=this.cs-1;
    }
    public int getFront(){
        return this.arr[this.front];
    }
    public void printQueue(){
        for (int a :
                arr) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        CircularArrayQueue queue=new CircularArrayQueue();
        for(int i =0 ; i<10;i++){
            queue.enqueue((int) (Math.random()*100));
        }
        queue.printQueue();
        queue.enqueue(12);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getFront());
        System.out.println(queue.size());
    }

}

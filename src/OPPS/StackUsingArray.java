package OPPS;

public class StackUsingArray {
    protected   int[] stack ;
   protected int top=-1;
   protected static final int DEFAULT_CAPACITY =10;

    StackUsingArray(){
        this.stack = new int[DEFAULT_CAPACITY];

    }
    StackUsingArray(int size ) throws  Exception{
        if(size<1){
            throw new Exception("Invalid Capacity");
        }
        this.stack = new int[size];

    }
    public void push(int val) throws Exception{
        if(this.top==this.stack.length-1){
            throw  new Exception("Stack Overflow");
        }
        this.top++;
        this.stack[this.top]=val;
        //System.out.println(val +  " added at " + (this.top+1) + "th Location");
    }
    public  int pop() throws Exception{
        if(this.top==-1){
            throw new Exception("Stack Underflow");
        }
        int temp = this.stack[this.top];
        this.stack[this.top]=0;
        this.top--;
        return temp;
    }
    public int Top() throws Exception{
        if(top==-1)
        {
            throw  new Exception("Stack Underflow");
        }
        return this.stack[top];
    }

    public  boolean isEmpty(){
        return top == -1;
    }
    public void display() throws Exception{
        if(top==-1){
            throw new Exception("Stack Underflow");
        }
        for ( int i = this.top;i>=0;i-- ) {
            System.out.print(stack[i]+" , ");
        }
        System.out.println("END");
    }
    public int Size(){
        return this.top+1;
    }
}

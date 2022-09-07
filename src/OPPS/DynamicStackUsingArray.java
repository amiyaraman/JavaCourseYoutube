package OPPS;

public class DynamicStackUsingArray extends StackUsingArray {

    DynamicStackUsingArray(){
        super();
    }
    DynamicStackUsingArray(int size) throws Exception {
        super(size);
    }

    @Override
    public void push(int val) throws Exception {
        if(this.stack.length==this.Size()){
            int[] arr = new int[this.stack.length*2];
            for(int i=0;i<this.stack.length;i++){
                arr[i]=this.stack[i];
            }
            this.stack=arr;
        }
        super.push(val);
    }

}

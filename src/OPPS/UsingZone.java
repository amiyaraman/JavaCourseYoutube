package OPPS;

import java.util.Stack;

public class UsingZone {
    public static void main(String[] args) throws Exception{
//        StackUsingArray stack = new StackUsingArray(5);
//        StackUsingArray hstack = new StackUsingArray(5);
//        System.out.println(stack.isEmpty());
//        for(int i=0;i<5;i++){
//            stack.push(i+1);
//        }

//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//            System.out.println(stack.Top());
//            stack.display();
//        }
//        stack.display();


//        stack.display();
//        reverserStack(stack,hstack,0);
//        stack.display();

        int[]  input = {2,1,3,8,6,7,5};
       // nextGreatest(input,7);
        String inp ="{([a+b])}";
        System.out.println(isBalancedParenthesis(inp));
    }
    public static void reverserStack(StackUsingArray mStack,StackUsingArray hStack ,int index ) throws Exception{
        //StackUsingArray hStack= new StackUsingArray(size);

        if(mStack.isEmpty()){
            return;
        }
        int temp = mStack.pop();
        reverserStack(mStack,hStack,index+1);
        hStack.push(temp);
        if(index==0){
            while (!hStack.isEmpty()){
                mStack.push(hStack.pop());
            }
        }

    }

    public static void nextGreatest(int[] arr , int size) throws Exception {
        StackUsingArray stackUsingArray = new StackUsingArray(size);
        for(int i=0; i<size;i++){
            while(!stackUsingArray.isEmpty()
                    && stackUsingArray.Top()<arr[i]){
                int temp = stackUsingArray.pop();
                System.out.println(temp+ " -> " + arr[i]);
            }
            stackUsingArray.push(arr[i]);
        }
        while (!stackUsingArray.isEmpty()){
            int temp = stackUsingArray.pop();
            System.out.println(temp + " -> " + -1);
        }
    }
    public static boolean isBalancedParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if(s.charAt(i) == '}'){
                    if(stack.peek()=='{')
                    {stack.pop();}
                    else
                    {return false;}
                }
                if(s.charAt(i) == ')'){
                    if(stack.peek()=='(')
                    {stack.pop();}
                    else
                    {return false;}
                }
                if(s.charAt(i) == ']'){
                    if(stack.peek()=='[')
                    {stack.pop();}
                    else
                    {return false;}
                }

            }
        }
        return stack.isEmpty();
    }
}

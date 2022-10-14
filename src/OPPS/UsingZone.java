package OPPS;

import java.util.*;

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
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int q = sc.nextInt();
//        Stack<Integer> a = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            a.push(sc.nextInt());
//        }
       // stackedOutput(a,q);

        int[]  input = {2,1,3,8,6,7,5};
        int[] arr1= {100 ,80 ,60 ,70 ,60 ,75 ,85};
        int[] arr2={1,2,3,4,5};
       // Deque<Integer> v = new LinkedList<>();
//        for (int c :
//                arr1) {
//            v.addLast(c);
//        }
    //    System.out.println(Arrays.toString(stockSpanBF(arr1)));
        System.out.println(largestRectangleArea(arr2));
       //ImpOfTime(q,5,arr2);
       // nextGreatest(input,7);
        //String inp ="(c*b)+a*(a+b)";
       // System.out.println(isBalancedParenthesis(inp));
       // System.out.println(redundantBracket(inp));
      //
        //  prateekSirCoding();
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
    public static boolean redundantBracket(String s ){
        boolean ans = false ;
        int count=0;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('||s.charAt(i)=='*'||s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='/'){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if(s.charAt(i) == '}'){
                    if(stack.peek()=='*'||stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='/')
                    { while (!stack.isEmpty()&&stack.peek()!='{')
                        stack.pop();
                    }
                    else
                    {
                        return true;
                    }
                    stack.pop();
                }
                if(s.charAt(i) == ')'){
                    if(stack.peek()=='*'||stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='/')
                    { while (!stack.isEmpty()&&stack.peek()!='(')
                        stack.pop();
                    }
                    else
                    {
                        return true;
                    }
                    stack.pop();
                }
                if(s.charAt(i) == ']'){
                    if(stack.peek()=='*'||stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='/')
                    { while (!stack.isEmpty()&&stack.peek()!='[')
                        stack.pop();
                    }
                    else
                    {
                        return true;
                    }
                    stack.pop();
                }

            }
        }
        while (!stack.isEmpty()&&(stack.peek()!='{'||stack.peek()!='['||stack.peek()!='('||stack.peek()!=']'||stack.peek()!='}'||stack.peek()!=')')){
            stack.pop();
        }

        return !stack.isEmpty();
    }
    static boolean checkRedundancy(String s) { // same code with optimal writing of code from GFG
        // create a stack of characters
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {

            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;

                while (top != '(') {

                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }

                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }

                // If operators not found
                if (flag == true) {
                    return true;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;
    }
    public static int countRedundantBracket(String s ){
        int ans = 0 ;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('||s.charAt(i)=='*'||s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='/'){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if(s.charAt(i) == '}'){
                    if(stack.peek()=='*'||stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='/')
                    { while (!stack.isEmpty()&&stack.peek()!='{')
                        stack.pop();
                    }
                    else
                    {
                        ans++;
                    }
                    stack.pop();
                }
                if(s.charAt(i) == ')'){
                    if(stack.peek()=='*'||stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='/')
                    { while (!stack.isEmpty()&&stack.peek()!='(')
                        stack.pop();
                    }
                    else
                    {
                        ans++;
                    }
                    stack.pop();
                }
                if(s.charAt(i) == ']'){
                    if(stack.peek()=='*'||stack.peek()=='+'||stack.peek()=='-'||stack.peek()=='/')
                    { while (!stack.isEmpty()&&stack.peek()!='[')
                        stack.pop();
                    }
                    else
                    {
                         ans++;
                    }
                    stack.pop();
                }

            }
        }

        return ans;
    }
    public static void ImpOfTime(Deque<Integer> q, int n, int[] arr) throws Exception {
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (q.getFirst() == arr[j]) {
                ans++;
                q.removeFirst();
            } else {
                while (q.getFirst() != arr[j]) {
                    int var = q.getFirst();
                    q.addLast(var);
                    q.removeFirst();
                    ans++;
                }
                ans++;
                q.removeFirst();
            }

        }
        System.out.println(ans);

    }
    public static void prateekSirCoding() {


        Scanner scn = new Scanner(System.in);

        int q = scn.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (q > 0) {

            int type = scn.nextInt();

            if (type == 1) {

                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }else {
                    System.out.println("No Code");
                }

            } else if(type==2) {
                int data =scn.nextInt();

                stack.push(data);
            }
            q--;
        }

    }
    static final int MAX = 1299709; // 10^5 th prime number
    static boolean[] sieve = new boolean[MAX];
    static ArrayList<Integer> primes = new ArrayList<>();
    static void createSieve() {
        for (int i = 0; i < MAX; i++) {
            sieve[i] = true;
        }
        sieve[0] = sieve[1] = false;
        for (int i = 2; i < MAX; i++) {
            if (sieve[i]) {
                primes.add(i);
                for (int j = i * i; j < MAX && j >= 0; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }
    public static void stackedOutput(Stack<Integer> arr , int q){
        createSieve();
        Queue<Integer> qu = new LinkedList<>();
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        for (int i = 1; i <= q; i++) {
            while(!arr.isEmpty()){
                if(arr.peek()%primes.get(i-1)==0){
                    int ele=arr.pop();
                    b.push(ele);
                }
                else{
                    a.push(arr.pop());
                }
            }
            while(!b.isEmpty()){
                qu.add(b.pop());
            }
            arr=a;
            a=new Stack<>();
        }
        while(!qu.isEmpty()){
            System.out.println(qu.remove());
        }
        while (!arr.isEmpty()){
            System.out.println(arr.pop());
        }

    }
    public static int[] nextMax(int[] nums ){
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i]=-1;
        }
        Stack<Integer> help = new Stack<>();
        for(int i =0 ; i<2*n;i++){
            while(!help.isEmpty()&&nums[help.peek()]<nums[i%n]){
                ans[help.peek()]=nums[i%n];
                help.pop();
            }
            if (i < n)
                help.push(i);
        }
        return ans;
    }
    public static int[] nextMax(int[] nums1 , int[] nums2){
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Stack<Integer> help  =new Stack<>();
        for(int i = 0 ; i< nums2.length;i++){
            while(!help.isEmpty()&&help.peek()<nums2[i]){
                int element = help.pop();
                hashMap.put(element,nums2[i]);
            }
            help.push(nums2[i]);
        }
        for(int i =0;i< nums1.length;i++){
            ans[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
    static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.empty()) {
            s.push(x);
            return;
        }

        int y = s.peek();
        s.pop();
        insertAtBottom(s, x);
        s.push(y);
    }

    static void reverseStack(Stack<Integer> s) {
        if (s.empty())
            return;

        int x = s.peek();
        s.pop();
        reverseStack(s);
        insertAtBottom(s, x);
    }
    public static int[] stockSpanBF(int[] arr){
        int[] ans = new int[arr.length];
        int i =0;
        int j = 0;
        for(;i<arr.length;i++){
            j=0;
            int count = 0;
            while (j<=i){
                if(arr[i]>=arr[j]){
                    count++;
                    j++;

                }
                else {
                    count = 0;
                    j++;

            }
            }
            ans[i]=count;


        }
        return ans;
    }
    public static int[] stocksSpan(int price[], int n){
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i=0;
        stack.push(i);
        ans[i++]=1;
        for(;i<n;i++){
            while(!stack.isEmpty()&&price[i]>=price[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=i+1;
            }
            else {
                ans[i]=i-stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }
    public static  int largestRectangleArea(int[] heights) {
        long maxArea = 0;
        long pArea = 0;

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        while (i < heights.length) {

            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
                i++;
            }

            else {
                int idx = stack.pop();
                long x = heights[idx];

                int R = i;

                if (stack.isEmpty()) {
                    pArea = R * x;
                } else {
                    int L = stack.peek();
                    pArea = (R - L - 1) * x;
                }

                if (pArea > maxArea) {
                    maxArea = pArea;
                }

            }

        }

        while (!stack.isEmpty()) {

            long x = heights[stack.pop()];

            int R = i;

            if (stack.isEmpty()) {
                pArea = R * x;
            } else {
                int L = stack.peek();
                pArea = (R - L - 1) * x;
            }

            if (pArea > maxArea) {
                maxArea = pArea;
            }

        }

        return (int)maxArea;


    }
}
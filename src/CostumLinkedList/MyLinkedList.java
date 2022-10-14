package CostumLinkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    MyLinkedList(){
        this.head=this.tail=null;
        this.size=0;
    }
    private class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data=data;
            next = null;
        }
    }
    public void display() throws Exception{
        if(size==0){
            throw new Exception("LinkedList is Empty");
        }
        Node<T> temp=head;
        System.out.print("[");
        while(temp.next!=null){
            System.out.print(temp.data+" => ");
            temp=temp.next;
        }
        System.out.print(temp.data+"]\n");

    }
    public T getFirst(){
        return head.data;
    }
    public T getLast(){
        return tail.data;
    }
    public void addFirst(T data) {
        Node<T> nn=new Node<>(data);
        if(size==0){
            nn.next=null;
            this.head=this.tail=nn;
            this.size++;
            return;
        }
        nn.next=this.head;
        this.head=nn;
        this.size++;

    }
    public void addLast(T data) {
        Node<T> nn= new Node<>(data);
        nn.next=null;
        if(size==0){
            this.head=this.tail=nn;
            this.size++;
            return;
        }
        tail.next=nn;
        tail=nn;
        this.size++;

    }
    public void addAt(int index,T data) throws Exception{
        if(size==0){
            throw new Exception("List is Empty");
        }
        else if(index<0||index>=size){
            throw new Exception("Invalid Index");
        }
        else if (index==0){
            addFirst(data);
        }
        else if(index==size-1){
            addLast(data);
        }
        Node<T> nn=new Node<>(data);
        Node<T> temp = getNodeAt(index-1);
        nn.next=temp.next;
        temp.next=nn;
        size++;

    }
    public T removeFirst() throws Exception{
        if(size==0){
            throw new Exception("List is Empty");
        }
        T data = head.data;
        if(size==1){
            head=tail=null;
            size--;
            return data;
        }
        head=head.next;
        size--;
        return data;

    }
    public T removeLast() throws Exception{
        if(size==0){
            throw new Exception("List is Empty");
        }
        T data = tail.data;
        if(size==1){
            head=tail=null;
            size--;
            return data;
        }
        Node<T> pN = getNodeAt(size-2);
        pN.next=null;
        tail=pN;
        size--;
        return data;

    }
    public T removeAt(int index) throws Exception{
        if(size==0){
            throw new Exception("List is Empty");
        }
        else if(index<0||index>=size){
            throw new Exception("Invalid Index");
        }
        else if (index==0){
            return  removeFirst();
        }
        else if(index==size-1){
            return  removeLast();
        }
        Node<T> temp = getNodeAt(index-1);
        T data = temp.next.data;
        temp.next=temp.next.next;
        size--;
        return data;

    }
    public T getAt(int index) throws Exception{
        if(size==0){
            throw new Exception("List is Empty");
        }
         else if(index<0||index>=size){
            throw new Exception("Invalid Index");
        }
        else if(index==0){
            return head.data;
        }
        else if(index==size-1){
            return tail.data;
        }
        Node<T> temp = head;
        for(int i =1;i<=index;i++){
            temp=temp.next;

        }
        return temp.data;
    }
    public int getSize(){
        return size;
    }
    public void reverseLinkedList() throws Exception {
        if(size==0) {
            throw new Exception("Empty Linkedlist");
        }
        int l=0;
        int r = size-1;
        while (l<r){
            Node<T> nl= getNodeAt(l);
            Node<T> nr = getNodeAt(r);
            T  temp = nl.data;
            nl.data= nr.data;;
            nr.data=temp;
            l++;
            r--;
        }
    }
    public void reverseLinkedListPointer() throws Exception{
        if(size==0) {
            throw new Exception("Empty Linkedlist");
        }
        Node<T> pr = this.head;
        Node<T> cur = this.head.next;


        while (cur!=null){
            Node<T> nt = cur.next;
            cur.next=pr;
            pr=cur;
            cur=nt;
        }
        Node<T> temp =this.head;
        this.head=this.tail;
        this.tail=temp;
        tail.next=null;


    }
    public T getMid() throws Exception{
        if(size==0){
            throw new Exception("LinkedList is empty");
        }
        if(size==1||size==2){
            return this.head.data;
        }
        Node<T> slow = this.head;
        Node<T> fast = this.head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;

    }
    private Node<T> getNodeAt(int index) throws Exception{
        if(size==0){
            throw new Exception("List is Empty");
        }
        else if(index<0||index>=size){
            throw new Exception("Invalid Index");
        }
        else if(index==0){
            return head;
        }
        else if(index==size-1){
            return tail;
        }
        Node<T> temp = head;
        for(int i =1;i<=index;i++){
            temp=temp.next;

        }
        return temp;
    }
    public T kThNodeFromLast(int k){
        Node<T> slow =this.head;
        Node<T> fast = this.head;
        for(int i = 1;i<=k;i++){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }
    public int getSize(Node<T> node){
        if(this.head==null){
            System.out.println("Empty LinkedList");
            return 1;
        }
        return getSize(head.next)+1;

    }
    public Node<T> getIntersectionNode(Node<T> headA, Node<T> headB) {
        Node<T> tempA = headA;
        Node<T> tempB = headB;

        int sizeA =getSize(tempA);
        int sizeB = getSize(tempB);

        if(sizeA>sizeB){
            for(int i=1;i<=sizeA-sizeB;i++){
                tempA=tempA.next;
            }
        }
        else if(sizeA<sizeB){
            for(int i=1;i<=sizeB-sizeA;i++){
                tempB=tempB.next;
            }
        }
        while(tempA!=null||tempB!=null){
            if(tempA==tempB){
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;

    }



}

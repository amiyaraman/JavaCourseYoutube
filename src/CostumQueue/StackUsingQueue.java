package CostumQueue;

import java.util.*;

public class StackUsingQueue {
    public static void main(String[] args) {
        PushEfficientStack p = new PushEfficientStack();
    }
}
class PushEfficientStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void remove() {
        if (q1.isEmpty())
            return;

        // Leave one element in q1 and
        // push others in q2.
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // Pop the only left element
        // from q1
        q1.remove();

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    void add(int x) {
        q1.add(x);
    }

    int top() {
        if (q1.isEmpty())
            return -1;

        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // last pushed element
        int temp = q1.peek();

        // to empty the auxiliary queue after
        // last operation
        q1.remove();

        // push last element to q2
        q2.add(temp);

        // swap the two queues names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    int size() {
        return q1.size();
    }
}

class PopEfficientStack {

        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();


        static int curr_size;

        static void push(int x) {

            q2.add(x);


            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }

            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static void pop() {


            if (q1.isEmpty())
                return;
            q1.remove();
        }

        static int top() {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }

        static int size() {
            return q1.size();
        }
}

package CostumHeap;

import java.util.ArrayList;

public class CustomHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    public void add(int element){
        this.heap.add(element);
        upheadify(this.heap.size()-1);
    }

    private void upheadify(int ci) {
        int pi = (ci-1)/2;
        if(this.heap.get(ci)<this.heap.get(pi)){
            swap(ci,pi);
            upheadify(pi);
        }


    }
    private void swap(int i , int j){
        int ith = this.heap.get(i);
        int jth  = this.heap.get(j);

        this.heap.set(i,jth);
        this.heap.set(j,ith);
    }
    public int remove(){
        swap(0,heap.size()-1);
        int ri = heap.remove(heap.size()-1);
        downHeapify(0);

        return ri;
    }
    public int get(){
        return heap.get(0);
    }
    private void downHeapify(int pi){
        int lci=2*pi+1;
        int rci=2*pi+2;

        int mini = pi;

        if(lci<heap.size()&&heap.get(lci)<heap.get(mini)){
            mini = lci;

        }
        if(lci<heap.size()&&heap.get(rci)<heap.get(mini)){
            mini=rci;

        }
        if(mini!=pi){
            swap(pi,mini);
            downHeapify(mini);
        }
    }
}

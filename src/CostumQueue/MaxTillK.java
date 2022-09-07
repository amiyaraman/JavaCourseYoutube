package CostumQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Maximum element in every window of size K
public class MaxTillK {
    public static void main(String[] args) {
        int[] input = {-1,3,-2,1,2,5,-2,6,-7};
        int k =3;
        System.out.println(Arrays.toString(firstNegativeTillK(input, k)));

    }
    public static  int[] maxTillK(int[] nums , int k){
        int[] ans =new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int index = 0;
        int i=0;

        for(; i<k;i++){
            while(!q.isEmpty()&&nums[i]>nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }

        for(;i<nums.length;i++){
            ans[index++]=nums[q.getFirst()];
            while(!q.isEmpty()&&(i-k)>=q.getFirst()){
                q.removeFirst();
            }
            while(!q.isEmpty()&&nums[i]>nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        ans[index]=nums[q.getFirst()];


        return ans;
    }
    public static  int[] firstNegativeTillK(int[] nums , int k){
        int[] ans = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> q = new LinkedList<>();
        int i =0;
        for(;i<k;i++){
            if(nums[i]<0){
                q.addLast(i);
            }

        }
        for(;i<nums.length;i++){
            if(!q.isEmpty()){
                ans[index++] = nums[q.getFirst()];
            }
            else{
                ans[index++] = 0;
            }
            while(!q.isEmpty()&&(i-k)>=q.getFirst()){
                q.removeFirst();
            }
            if(nums[i]<0){
                q.addLast(i);
            }

        }
        if(!q.isEmpty()){
            ans[index] = nums[q.getFirst()];
        }
        else{
            ans[index] = 0;
        }
        return ans;
    }
}

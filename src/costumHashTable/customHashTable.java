package costumHashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class customHashTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k =0;
        int[] arr = new int[n];
        while (k<n){
            arr[k]=sc.nextInt();
            k++;
        }
        System.out.println(indexReturn(arr,n));
    }
    public static boolean indexReturn(int[] arr,int n){
        //Your code here
        ArrayList<Integer> allSum =new ArrayList<>();
        HashMap<Integer,Boolean> h = new HashMap<Integer, Boolean>();
        int i =0;
        int j=1;
        int sum = 0;
        while (i<n){
            if(arr[i]==0){
                return true;
            }
            sum=sum+arr[i];
            if(h.containsKey(sum)){
                return true;
            }
            else {
                h.put(sum,true);
            }
            i++;
        }
        return h.containsKey(0);


    }



}

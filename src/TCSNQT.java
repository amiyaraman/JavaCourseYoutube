import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TCSNQT {
    public static void main(String[] args) {
//        int size = 10;
//        int l =100 ;
        int[] arr = {1,2,3,7,5};
//        int k = 9;
//      //  System.out.println(rangeRoom(arr,size,l));
//      //  TCSNQT tcs=new TCSNQT();
//       // int re=tcs.rangeRoom(arr,size,l);
//        sumsum(arr,5,9);
        ArrayList<Integer> ans = subarraySum(arr,5,12);
        System.out.println(ans);

    }
    public static int rangeRoom(int[] arr,int n,int L){
        int currIndex=0;
        for(int k =1;k<arr.length;k++){
            for (int i = 0; i < arr.length - k + 1; i++) {
                    int current_sum = 0;
                    for (int j = 0; j < k; j++){
                        current_sum = current_sum + arr[i + j];

                    }
                if(current_sum<L){
                    currIndex=k;
                }
            }

        }
        return currIndex;


    }
    public static void sumsum( int[] arr , int size,int count){
        int crrvaluer=1;
         count = count -size;
        int i =0;
        int sum = 0;
        while(i<size&&count>0){
            if(arr[i]==crrvaluer){
                i++;
                crrvaluer++;
                //sum=sum+arr[i];
            }
            else{
                count--;
                sum=sum+crrvaluer;
                crrvaluer++;

            }

        }
        System.out.println(sum);


    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> ans = new ArrayList();
        int currSum = 0;
        int sIndex=1;
        int eIndex = 0;
        for(int i =0;i<n;i++){
            currSum=currSum+arr[i];
            eIndex=i+1;

             if(currSum>s){
                while (currSum>s){
                    currSum=currSum-arr[sIndex-1];
                    sIndex++;
                }
            }
            if(currSum==s){
                ans.add(sIndex);
                ans.add(eIndex);

                return ans;
            }
        }

        return ans;
    }
}

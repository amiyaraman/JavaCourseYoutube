import java.util.*;

class TCSNQT {
    public static void main(String[] args) {
//        int size = 10;
//        int l =100 ;
        int[] arr = {444,514,540,518,825,940,585};
//        int k = 9;
//      //  System.out.println(rangeRoom(arr,size,l));
//      //  TCSNQT tcs=new TCSNQT();
//       // int re=tcs.rangeRoom(arr,size,l);
//        sumsum(arr,5,9);
    //    ArrayList<Integer> ans = subarraySum(arr,5,12);
      //  System.out.println(ans);
//        int n =5;
//        for(int i = n; i>=1;i--){
//            for(int j=n;j>=i;j--){
//                System.out.print(j+ " ");
//            }
//            System.out.println();
//        }
//        String input = "acbcabacacdsb";
//        printCount(input);
        //System.out.println(calculateAvg(arr));
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        System.out.println(findFilledBucket(5,));
        int[] arr3 = { 5,3,2,7,1,6 };
        int n = arr.length;

       // quickSort(arr3, 0, arr3.length-1);
      //  System.out.println("Sorted array: ");
    //    printArray(arr3, arr3.length);
       // System.out.println(ans(3,2));



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
    public static void printCount(String s){
        char temp = ' ';
        int count  = 0;
        StringBuilder ans = new StringBuilder();
        for(int i  = 0 ; i<s.length();i++){
            temp=s.charAt(i);
            count=0;
            if(ans.toString().contains(temp+""))
            {
                continue;
            }else{
                for(int j = 0 ; j < s.length();j++){
                    if(temp==s.charAt(j)){
                        count++;
                    }
                }
                ans.append(temp).append(":").append(count).append(",");

            }
        }
        System.out.println(ans);
    }
    public static double calculateAvg(List<Integer> inputArray){
        int sum=0;
        int count =0;
        for (int a :
                inputArray) {
            if (a % 3 == 0 && a % 2 == 0){
                sum+=a;
                count++;

            }
        }
        return ((double) sum/(double)count);
    }
    public static double calculateIncome(long input){
        if(input>0&&input<=250000){
            return  0;

        }
        if(input>250000&&input<=500000){
            double ans = ((input-250000)*10.0)/100;
            return ans;


        }
        if(input>500000&&input<=750000){
            int sum =000;
            double ans = ((input-500000)*15.0)/100;;
            return sum+ans;

        }
        if(input>750000&&input<=1000000){
            int sum = 00;
            double ans = (input*10.0)/100;
            return ans+sum;

        }
        if(input>1000000&&input<=1250000){
            int sum = 0000;
            double ans = (input*20.0)/100;
            return sum+ans;


        }
        if(input>1250000&&input<=1500000){
            int sum = 0000;
            double ans = (input*25.0)/100;
            return sum+ans;

        }
        if(input>1500000){
            int sum = 000;
            double ans = (input*30.0)/100;
            return ans+sum;


        }
        return 0;
    }

    public static int findFilledBucket(int N , List<Integer> queries){

        boolean[] bucket = new boolean[N];
        boolean even =false;
        boolean odd =false;


        for (int ch :queries) {
            switch (ch){
                case 1:for (int i =0;i<N;i++){
                    bucket[i]=true;
                }
                even=odd=true;
                    break;
                case 2:
                    for (int i =0;i<N;i++){
                        if(i%2==0){
                            bucket[i]=false;
                        }
                    }
                    even=false;
                    break;

                case 3:
                    for (int i =0;i<N;i++){
                        if(i%2!=0){
                            bucket[i]=false;
                        }
                    }
                    odd=false;
                    break;
                case 4:
                    for (int i =0;i<N;i++){
                        bucket[i]=false;
                    }
                    even=odd=false;
                    break;
                default:
            }

        }


        int count =0;
        for (boolean b :
                bucket) {
            if (b) {
                count++;
            }
        }
        return count;
    }
    public static String longestPalindrome(String s) {

        int maxLen=0;
        int start = 0;

        for(int i = 1;i<s.length();i++){
            int l = i-1;
            int r = i;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                if(maxLen<r-l+1){
                    maxLen=r-l+1;
                    start=l;
                }
                l--;
                r++;
            }
            l=i-1;
            r=i+1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                if(maxLen<r-l+1){
                    maxLen=r-l+1;
                    start=l;
                }
                l--;
                r++;
            }
        }
        return s.substring(start,start+maxLen);



    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    public static int ans=0;

    public static int sol(int a , int b , int x , int y){
        if(a==x&&b==y){
            return 0;
        }
        if(a>x||b>y){
            return -1;
        }
        int l = sol(a+b,b,x,y);
        int r = sol(a,a+b,x,y);
        if(l!=-1){
            return l+1;
        }
        else if(r!=-1){
            return r+1;
        }
        return -1;

    }
    static int ans(int x, int y) {
        return sol(1, 1, x, y);

    }





}

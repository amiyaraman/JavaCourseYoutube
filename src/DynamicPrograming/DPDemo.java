package DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;

public class DPDemo {
    public static void main(String[] args) {
      //  System.out.println(fibDp(45,new int[46]));
      //  System.out.println(countBoardPathDP(32,0,new int[33]));
      //  System.out.println("---------------------------------");
       // System.out.println(countBoardPathIterative(32,0));
      //  System.out.println("---------------------------------");
      //  System.out.println(countBoardPath(32,0));
       // System.out.println(LCS("hofubmnylkra","pqhgxgdofcvmr"));
        //System.out.println(countBinary(43));
        //System.out.println(countBinaryGFG(43));
//        int[] arr = {10,9,2,5,3,7,101,18};
//        //System.out.println(LIS(arr));
//       // System.out.println(BPBUSE(20));
//        int[] wine = {2,3,5,1,4};
//       // System.out.println(WSDPSE(wine,5));
//        int[] mc = {4,2,3,5,1};
//     //   System.out.println(MCMDPTD(mc , 5));
//        int[] wt = {1,3,4,5};
//        int[] pr = {1,4,5,7};
//        System.out.println(knapsac(wt,pr,7));
        int[] mixture = {40,60,20,50} ;
        //System.out.println(mixture(mixture));
        String s ="";
        // System.out.println(numBinaryTrees(7));
        System.out.println(minCut("fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgececggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccghggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefagfccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehcffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfhadifafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhbhefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgffbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcifedacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfdbghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadbacddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcfhdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgghciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihcgeefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddegfciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceiegiedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibiddadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdbdfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd"));
       // s.length()
    }
    public static int fibDp(int n , int[] storage){
        if(n<=1){
            return n;
        }
        if(storage[n]!=0){
            return storage[n];
        }
        storage[n]=fibDp(n-1,storage)+fibDp(n-2,storage);
        return storage[n];
    }
    public static int countBoardPathDP(int end , int curr,int[] storage){
        if (curr == end) {
            return 1;
        }
        if (curr > end) {
            return 0;
        }
        if(storage[curr]!=0){
            return storage[curr];
        }
        int count  =0;
        for(int i =1 ; i<=6;i++){
            count=count+countBoardPathDP(end ,curr+i,storage);
        }
        storage[curr] =count;
        return storage[curr];
    }
    public static int countBoardPathIterative(int end ,int curr){
        int[] arr = new int[end+1];
        arr[end] = 1;

        for(int i =end -1; i>=0;i--){
            int count  = 0 ;
            for(int dice  = 1 ; dice<=6&&dice+i<=end;dice++){
                count=count+arr[i+dice];
            }
            arr[i]=count;
        }
        System.out.println(Arrays.toString(arr));

        return arr[curr] ;
    }
    public static int BPBUSE( int end){
        int[] DParr = new int[6];
        DParr[0]=1;
        for(int i =1;i<=end;i++){
            int sum = DParr[5];
            for(int j = 4;j>=0;j--){
                sum=sum+DParr[j];
                DParr[j+1]=DParr[j];
            }
            DParr[0]=sum;

        }
        return DParr[0];
    }
    public static int countBoardPath(int end,int curr ){
        int[] arr = new int[end+1];
        arr[end] = 1;
        int dice = 6;
        int sum = 0;
        int negativeSum=0;

        for(int i =end -1; i>=0;i--){
            sum =sum + arr[i+1];
            if(dice+i<end){
                negativeSum=negativeSum+arr[dice+i+1];
            }
            arr[i]=sum-negativeSum;

        }
        System.out.println(Arrays.toString(arr));

        return arr[curr] ;
    }
    public static int LCS(String s1 , String s2){
        int ans =-1;
        int i, j;
        int currentL = 0;
        int maxL = 0 ;
        for(int l1 = 0 ; l1<s1.length();l1++){
            j=l1;
            i=0;
            currentL=0;
            int currentR=0;
            while(i<s2.length()&&j<s1.length()){
                if(s2.charAt(i)==s1.charAt(j)){
                    i++;
                    j++;
                    currentL++;
                }
                else{
                    i++;
                }
            }
            j=l1;
            i=0;
            while(i<s2.length()&&j<s1.length()){
                if(s2.charAt(i)==s1.charAt(j)){
                    i++;
                    j++;
                    currentR++;
                }
                else{
                    j++;
                }
            }
            if(currentL>maxL&&currentL>currentR){
                maxL=currentL;
            }
            else if(currentR>maxL){
                maxL=currentR;
            }


        }
        return maxL ;
    }
    public static int LCSR(String s1 , String s2){
        if(s1.length()==0||s2.length()==0){
            return 0;
        }
        else if(s1.charAt(0)==s2.charAt(0)){
            return 1+LCSR(s1.substring(1),s2.substring(1));
        }
        else{
            int L = LCSR(s1,s2.substring(1));
            int R= LCSR(s1.substring(1),s2);
            return Math.max(L,R);
        }
    }
    public static int LCSDP(String s1 , String s2){
        int[][] storage = new int[s1.length()+1][s2.length()+1];
        storage[s1.length()][s2.length()]=0;

        for(int i  =s1.length() ;i>=0;i--){
            for(int j = s2.length() ; j>=0;j--){
                if(i==s1.length()||j==s2.length()){
                    storage[i][j]=0;
                }else{
                    if(s1.charAt(i)==s2.charAt(i)){
                        storage[i][j]=1+storage[i+1][j+1];
                    }else{
                        storage[i][j]=Math.max(storage[i+1][j],storage[i][j+1]);
                    }
                }

            }
        }
        return storage[0][0];
    }
    public static int editDistance(String word1 , String word2){
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        String ros1 = word1.substring(1);
        String ros2 = word2.substring(1);
        if(word1.charAt(0)==word2.charAt(0)){
            return editDistance(ros1,ros2);
        }
        else{
            int f1 = 1+editDistance(ros1,ros2);
            int f2 = 1+editDistance(word1,ros2);
            int f3 = 1+editDistance(ros1,word2);

            return Math.min(f1 , Math.min(f2,f3));
        }
    }
    public static int editDistanceDp(String word1 , String word2){
        int[][] storage = new int[word1.length()+1][word2.length()+1];
        storage[word1.length()][word2.length()]= 0;

        for(int i=word1.length();i>=0;i--){
            for(int j = word2.length();j>=0;j--){
                if(i==word1.length()){
                    storage[i][j]=word2.length()-j;
                    continue;
                }
                if(j==word1.length()){
                    storage[i][j]=word1.length()-i;
                }
                else{
                    if(word1.charAt(i)==word2.charAt(j)){
                        storage[i][j] = storage[i+1][j+1];
                    }
                    else{
                        storage[i][j]=1+Math.min(storage[i+1][j],Math.min(storage[i][j+1],storage[i+1][j+1]));
                    }

                }
            }
        }
        return storage[0][0];
    }
    public static long countBinary(int n){
        long[] zero = new long[n];
        long[] one = new long[n];
        zero[0]= 1;
        one[0]=1;
        for(int i =1 ; i<n;i++){
            zero[i]=(zero[i-1]+one[i-1]);
            one[i]= zero[i-1];
        }
        return (zero[n-1]+one[n-1]);
    }
    //GFG ka ek test case hi galat hai jisme n ki value 43 hai
    //how can the no. count can be less then the previous count false logic
    //42=701408733
    //43=
    public static long countBinaryGFG(int n ){
        long mod  =1000000007;
        long[] a = new long[n+1];
        a[0]=0;
        a[1]=2;
        a[2]=3;
        for(int i=3;i<=n;i++){
            a[i]=(a[i-1]+a[i-2])%mod;
        }
        return a[n];
    }

    public static int LIS(int[] arr){
        if(arr.length<=1){
            return arr.length;
        }
        int[] lis = new int[arr.length];
        lis[0]=1;
        for(int i = 1 ;i<arr.length;i++){
            lis[i]=1;
            for(int j = 0 ; j<i;j++){

                if(arr[i]>arr[j]){
                    if(lis[i]<(lis[j]+1)){
                        lis[i]=lis[j]+1;
                    }
                }
            }
        }
        int max = lis[0];
        for(int a : lis){
            if(max<a){
                max = a;
            }
        }
        return max;
    }
    public static int WSDPSE(int[] arr,int n   ){
        int[][] storage = new int[n][n];

        for(int slide = 0;slide<arr.length;slide++){
            for(int si = 0 ;si<=n-slide-1;si++){
                int ei = si+slide;
                int year = n-(ei - si + 1) + 1;
                if(si==ei){
                    storage[si][ei] = arr[si]*year;
                }
                else{
                    int left = storage[si+1][ei] + arr[si]*year;
                    int right = storage[si][ei-1] + arr[ei]*year;
                    storage[si][ei]=Math.max(left,right);

                }

            }

        }
       // System.out.println(Arrays.deepToString(storage));
        return storage[0][n-1];
    }
    public static int MCMDPTD(int[] arr  , int n){
        int[][] storage = new int[n][n];
        for(int slide =1 ; slide<n;slide++){
            for(int si = 0 ; si < n-slide;si++){
                int ei = si+slide;
                if(si+1 == ei){
                    storage[si][ei]=0;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for (int k = si+1;k<=ei-1;k++){
                        int lf = storage[si][k];
                        int rt = storage[k][ei];
                        int sw = arr[ei]*arr[k]*arr[si];
                        int total = lf+rt+sw;
                        if(total<min){
                            min=total;
                        }
                    }
                    storage[si][ei]= min;


                }

            }

        }
        System.out.println(Arrays.deepToString(storage));
        return storage[0][n-1];
    }
    public static int knapsac(int[] wt , int[] pr , int cap){
        int[][] strg = new int[wt.length+1][cap+1];
        int n =wt.length;

        for(int vindx = n-1;vindx>= 0;vindx--){
            for(int changingcap= 1;changingcap<=cap;changingcap++){
                int e = strg[vindx+1][changingcap];
                int i  = 0;
                if(changingcap>=wt[vindx]){
                    i = strg[vindx+1][changingcap-wt[vindx]]+pr[vindx];

                }
                strg[vindx][changingcap]= Math.max(e,i);
            }
        }
        System.out.println(Arrays.deepToString(strg));
        return strg[0][cap];
    }
    public static int mixture (int[] arr){

        int[][] storage = new int[arr.length][arr.length];
        int n = arr.length;
        for(int slide =0 ; slide<n;slide++){
            for(int si = 0; si<n-slide;si++ ){
                int ei = si+slide;
                if(si==ei){
                    storage[si][ei]=0;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k = si ;k<ei;k++){
                        int l = storage[si][k];
                        int r = storage[k+1][ei];

                        int sw = color(arr,si,k)*color(arr,k+1,ei);
                        int total = l+r+sw;

                        if(total<min){
                            min=total;
                        }
                    }
                    storage[si][ei]= min;
                }

            }
        }
        return storage[0][n-1];
    }
    public static  int color(int[] arr , int si , int ei ){
        int mod = 100;
        int sum = 0;

        for(int i = si ; i<=ei;i++){
            sum += arr[i];

        }
        return sum%mod;
    }
    public static void LICprint(int[] arr){
        ArrayList<Integer> aux2=new ArrayList<>();
        ArrayList<ArrayList<Integer>> aux_str2=new ArrayList<>();
        aux2.add(0,arr[0]);
        aux_str2.add(0,new ArrayList<>(aux2));

        int length=1;


        for(int i = 1 ;i<arr.length;i++){
            int it = binarySearch(0,aux2.size()-1,aux2,arr[i]);
            if(it == length){

                aux2.add(length,arr[i]);

                aux_str2.add(length,new ArrayList<>(aux_str2.get(length-1)));

                aux_str2.get(length).add(length,arr[i]);
                length++;
            }
            else{
                aux2.set(it,arr[i]);
                aux_str2.get(it).set(aux_str2.get(it).size()-1,arr[i]);
            }
        }
        System.out.println(length);
        System.out.println(aux_str2.get(length-1));
    }
    public static int binarySearch(int s , int e , ArrayList<Integer> arr,int element){
        int low = s ;
        int high = e;
        while(low<=high){
            int mid= (low+high)/2;
            if(arr.get(mid)>element){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int cutRod(int price[], int n) {
        int[] ansArray = new int[n+1];
        ansArray[0]= 0;
        ansArray[1]= price[0];

        for(int i =1 ;i<n;i++){
            int left = 1;
            int right = i;
            int max = price[i];
            while(left<=right){
                int lp = ansArray[left];
                int rp = ansArray[right];
                int sum = lp+rp;
                if(max<sum){
                    max=sum;
                }
                left++;
                right--;
            }
            ansArray[i+1]=max;
        }
        return ansArray[n];
    }
    public static boolean isMatch(String s, String p) {
       boolean[][] strg = new boolean[s.length()+1][p.length()+1];
       strg[s.length()][p.length()]=true;
       for(int i = s.length();i>=0;i--){
           for(int j = p.length()-1;j>=0;j--){
               if(i==s.length()){
                   if(p.charAt(j)=='*'){
                       strg[i][j]=strg[i][j + 1];
                   }
                   else{
                       strg[i][j]=false;
                   }
               }else{
                   char chs = s.charAt(i);
                   char chp = p.charAt(j);
                   boolean ans = false;
                   if((chs==chp)||chp=='?'){
                       ans = strg[i+1][j+1];
                   }else if(chp=='*'){
                       boolean blankspace= strg[i][j+1];
                       boolean multicharactor = strg[i+1][j];
                      ans=blankspace||multicharactor;
                   }
                   strg[i][j]=ans;
               }
           }
       }
       return strg[0][0];

    }
    public static int numBinaryTrees(int n) {
        int[] strg = new int[n+1];
        strg[0]= 1;
        strg[1]=1;
        for(int i=2 ; i<=n;i++){
            int total = 0;
            for(int j =1 ; j<=i;j++  ){
                int l = j-1;
                int r = i-j;
                int lint =strg[l];
                int rint= strg[r];
                total+=strg[l]*strg[r];

            }
            strg[i]=total;
        }
        return strg[n];

    }
    public static int minCut(String s) {
        int[][] arr = new int[s.length()][s.length()];
        boolean[][] isStringPalindrome=isisPalindromeList(s);
        for(int slide=1;slide<s.length();slide++){
            for(int si = 0;si<s.length()-slide;si++){
                int ei = si+slide;
                if(isStringPalindrome[si][ei]){
                    arr[si][ei]=0;
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = si ; k<ei;k++){
                        int lp = arr[si][k];
                        int rp = arr[k+1][ei];

                        int sw= lp + rp + 1;
                        if(min>sw){
                            min = sw;
                        }

                    }
                    arr[si][ei]= min;

                }

            }
        }
        return arr[0][s.length()-1];


    }

    private static boolean isPalindrome(int si, int ei, String s) {
        while(si<ei){
            if(s.charAt(si)==s.charAt(ei)){
                si++;
                ei--;
            }else{
                return false;
            }
        }
        return true;
    }
    private static boolean[][] isisPalindromeList(String s){
        boolean[][] isStringPalindrome=new boolean[s.length()][s.length()];
        for(int slide = 0 ; slide<s.length();slide++){
            for(int i=0;i<s.length()-slide;i++){
                int j = i+slide;
                if(i==j){
                    isStringPalindrome[i][j]=true;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        isStringPalindrome[i][j]=isStringPalindrome[i+1][j-1];
                    }
                    else{
                        isStringPalindrome[i][j]=false;
                    }
                }
            }
        }
       return isStringPalindrome;

    }

}

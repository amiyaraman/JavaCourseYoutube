package recursion;

import java.util.ArrayList;

public class PDISkips {
    public static void main(String[] args) {
        //System.out.println(permutationString("abc"));
        //permutationString("","abc");
       // toh(3,"A","B","C");
        //etBoardPath(10,"");
        //System.out.println(getMazePath(0,0,2,2));
        //printMazePath(0,0,2,2,"");
       // System.out.println(getMazePathDiag(0,0,2,2).size());
        printSubSeq("","abc");

    }
//    static void printDISkips(int n){
//        if(n-2<0){
//            System.out.println(1);
//            return;
//        } else if (n-2==0) {
//             System.out.println(n);
//            System.out.println(1);
//            return;
//
//        }
//        System.out.println(n);
//        printDISkips(n-2);
//        System.out.println(n-1);;
//
//    }
    static void printDISkips(int n){
        if(n<=0){
            return;
        }
        if(n%2==1){
            System.out.println(n);

        }
        printDISkips(n-1);
        if(n%2==0)
        {

            System.out.println(n);
        }

    }
    static long fact(int n){
        if(n<=1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int power(int x , int n){
        if(n==0){
            return 1;
        }
        return  x*power(x,n-1);
    }
    public static int fab(int n){
        if(n==1||n==0){
            return n;
        }
        return fab(n-1)+fab(n-2);
    }
    public static boolean isSorted(int[] arr , int sIndex){
        if(sIndex==arr.length-1){
            return true;
        }
        return arr[sIndex]<=arr[sIndex+1]&&isSorted(arr,sIndex+1);
    }
    public static ArrayList<String> getSubSeq(String p ,String up){
        ArrayList<String> ans = new ArrayList<>();
        if(up.isEmpty()){
            ans.add(p);
            //System.out.println(p);
            return ans;
        }
        String s = up.substring(0,1);
            ans.addAll(getSubSeq(p+s,up.substring(1)));
            ans.addAll(getSubSeq(p,up.substring(1)));



        return ans;
    }
    public static ArrayList<String> getSubSeq(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty()){
            ans.add(s);
            return ans;
        }
        char cc = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> getsub = getSubSeq(ros);
     //   System.out.println(getsub);
       // ans.addAll(getsub);
        for (String a:getsub) {
            ans.add(a);
            ans.add(cc+a);

        }
        return ans;

    }
    public static ArrayList<String> getASCIISubSeq(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty()){
            ans.add(s);
            return ans;
        }
        char cc = s.charAt(0);
        int ccint = cc;
        System.out.println(ccint);
        String ros = s.substring(1);
        ArrayList<String> getsub = getSubSeq(ros);
        //   System.out.println(getsub);
        // ans.addAll(getsub);
        for (String a:getsub) {
            ans.add(a);
            ans.add(cc+a);
            ans.add(ccint+a);
        }
        return ans;

    }
    public static void printSubSeq(String p ,String up){
        if(up.isEmpty()){
            System.out.print(p);
            System.out.print(" ,");
            return ;
        }
        String s = up.substring(0,1);
        printSubSeq(p+s,up.substring(1));
        printSubSeq(p,up.substring(1));




    }
    public static ArrayList<String> permutationString(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty()){
            ans.add(s);
            return ans;
        }
        char cc = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> rr = permutationString(ros);
        for (String rsm : rr){
            for (int i = 0; i <= rsm.length(); i++) {
                String temp= rsm.substring(0,i) + cc+rsm.substring(i);
                ans.add(temp);
            }
        }
        return ans;
    }
    public static void permutationString(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        for (int i = 0; i < up.length(); i++) {
            char cc =up.charAt(i);
            String ros =up.substring(0,i)+up.substring(i+1);
            permutationString(p+cc,ros);
        }
    }
    public static void toh(int n , String src ,String dest , String helper  ){
        if(n==0){
            return;
        }
        toh(n-1,src , helper , dest);
        System.out.println("move"+ n+ "th disc from"+src + "to" + dest);
        toh(n-1,helper,dest,src);
    }

    public static  int countToh(int n , String src ,String dest , String helper  ){
        int ans =0;
        if(n==0){
            return ans ;
        }
        ans = ans+countToh(n-1,src , helper , dest);
        System.out.println("move"+ n+ "th disc from"+src + "to" + dest);
        ans++;
        ans = ans+countToh(n-1,helper,dest,src);
        return ans;
    }
    public static  ArrayList<String> getBoardPath(int cur , int end){
        ArrayList<String> ans = new ArrayList<>();
        if(end==cur){

            ans.add("");
            return ans;
        }
        if(cur>end){
            return new ArrayList<>();
        }

        for (int i = 1; i < 7; i++) {
            ArrayList<String> ral= getBoardPath(cur+i,end);
            for (String rsm:ral) {
                ans.add(rsm+i);
            }
        }
        return ans;
    }
    public static  void getBoardPath( int end,String res){
        ArrayList<String> ans = new ArrayList<>();
        if(end==0){
            System.out.println(res);
            return ;
        }
        if(end<0){
            return ;
        }

        for (int i = 1; i < 7; i++) {
            getBoardPath(end-i,res+i+",");
        }
    }
    public static ArrayList<String> getMazePath(int cr, int cc , int er,int ec){
        ArrayList<String> ans =new ArrayList<>();
        if(cr==er && cc==ec){
            ans.add("\n");
            return ans;
        }
        if(cr>er || cc>ec){
            return ans;
        }
        ArrayList<String> hrl =getMazePath(cr,cc+1,er,ec);
        for(String s:hrl) {
            ans.add("h"+s);
        }
        ArrayList<String> vrl =getMazePath(cr+1,cc,er,ec);
        for(String s:vrl) {
            ans.add("v"+s);
        }
        return ans;


    }
    public static void printMazePath(int cr, int cc , int er,int ec , String res ){
        ArrayList<String> ans =new ArrayList<>();
        if(cr==er && cc==ec){
            System.out.println(res);;
            return ;
        }
        if(cr>er || cc>ec){
            return ;
        }
        printMazePath(cr,cc+1,er,ec,res+"h");

        printMazePath(cr+1,cc,er,ec,res+"v");

        return ;
    }
    public static int getMazePathCount(int cr , int cc , int er , int ec  ){
        if(cr==er&&cc==ec){
            return 1;
        }
        if(cc>ec||cr>er){
            return 0;
        }
        int curHCount = getMazePathCount(cr,cc+1,er,ec);
        int curVCount = getMazePathCount(cr+1,cc,er,ec);
        return curHCount+curVCount;
    }
    public static ArrayList<String> getMazePathDiag(int cr, int cc , int er,int ec){
        ArrayList<String> ans =new ArrayList<>();
        if(cr==er && cc==ec){
            ans.add("\n");
            return ans;
        }
        if(cr>er || cc>ec){
            return ans;
        }
        ArrayList<String> hrl =getMazePathDiag(cr,cc+1,er,ec);
        for(String s:hrl) {
            ans.add("h"+s);
        }
        ArrayList<String> vrl =getMazePathDiag(cr+1,cc,er,ec);
        for(String s:vrl) {
            ans.add("v"+s);
        }
        ArrayList<String> drl =getMazePathDiag(cr+1,cc+1,er,ec);
        for(String s:drl) {
            ans.add("d"+s);
        }
        return ans;


    }


}


















































          //\\
         //  \\
        //    \\
       //      \\
      //        \\
     //          \\
    //============\\
   //              \\
  //                \\
 //                  \\
//                    \\
package backtracing;

import java.util.Arrays;

public class NQueenProblem {
    static int  count =0;
    public static void main(String[] args) {
        boolean[][] inputBoard = {{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
       //================================================================================================================================

        boolean[][] mazeInput = {{false,true,false,false},
                                 {false,false,false,false},
                                 {false,true,false,false},
                                 {false,false,true,false}};
        boolean[][] input2 = new boolean[3][3];
       // countNQueen(inputBoard,0 ,"");
       // System.out.println(countNQueen(input2,0));

        int[] nums = { 12, -13, -5, 25, -20, 30, 10};
        int[] coins = {2,3,5,6};
        int [] coins2 = {1,2};
        // System.out.println(findMax(nums,0,nums.length-1));
        //System.out.println("The maximum sum of the subarray is " +
        //        findMaximumSum(nums));
       // OneDQueenProblemPermutation(inputBoard[0],3,0,"");
      //  OneDQueenProblemCombination(inputBoard[0],2,0,"",-1);
        coinChange(coins2,100,0,0,"");
       // OneDQueenProblemWRTBox(new boolean[4],2,0,"",0);
        //coinChangeWRTCoin(coins,10,"",0);
        //coinChangeWRTCoin(coins2,4,"",0);
        //TwoDQueenProblemCombinationKill(input2,3,0,"",0,0);
        //nKnightProblem(input2,0,0,3,0,"");
        blockedMaze(mazeInput,0,0,inputBoard,3,3,"");

    }
    public static void coinChange(int[] coins , int maxSum , int currSum , int lastCoinUsed,String ans ){
        if(maxSum==currSum){
            System.out.println(ans);
            return;
        }
        if(currSum>maxSum){
            return;
        }
        for(int i = lastCoinUsed ;i<coins.length;i++){
            coinChange(coins,maxSum,currSum+coins[i],i,ans+coins[i]+",");
        }
    }
    public static void coinChangeWRTCoin(int[] coins , int maxSum  ,String ans,int index ){
        if(maxSum==0){
            System.out.println(ans);
            return;
        }
        if(0>maxSum){
            return;
        }
        if(index==coins.length){
            return;
        }
        coinChangeWRTCoin(coins ,maxSum -coins[index],ans+coins[index],index);
        coinChangeWRTCoin(coins ,maxSum,ans,index+1);

    }
    public static void OneDQueenProblemPermutation(boolean[] board , int tQueen , int queenPlaced , String ans){
        if(queenPlaced==tQueen){
            System.out.println(ans);
            return;
        }
        for(int i =0 ; i < board.length;i++){
            if(!board[i]){
                board[i] = true;
                OneDQueenProblemPermutation(board,tQueen,queenPlaced+1,ans + "b"+i+"q"+queenPlaced);
                board[i]=false;
            }
        }
    }
    public static  void TwoDQueenProblemCombination(boolean[][] board , int tQueen,int queenPlaced , String ans ,int col , int row){
        if(tQueen==queenPlaced){
            System.out.println(ans);
            return;
        }
        if(col>=board[0].length){
            col=0;
            row++;
            /*
            ye bhi shi hai but same hi kaam kr rha hai to is line ko likho yha phir return na daalo same cheez
            TwoDQueenProblemCombination(board,tQueen,queenPlaced,ans,col,row);
            return;

             */
        }
        if(row>=board.length){
            return;
        }

        board[row][col]=true;
        TwoDQueenProblemCombination(board, tQueen, queenPlaced+1, ans+"{" +row+"-"+ col+"}", col+1, row);
        board[row][col]=false;
        TwoDQueenProblemCombination(board,tQueen,queenPlaced,ans,col+1,row);

    }
    public static  void TwoDQueenProblemCombinationKill(boolean[][] board , int tQueen,int queenPlaced , String ans ,int col , int row){
        if(tQueen==queenPlaced){
            System.out.println(ans);
            return;
        }
        if(col>=board[0].length){
            col=0;
            row++;
            /*
            ye bhi shi hai but same hi kaam kr rha hai to is line ko likho yha phir return na daalo same cheez
            TwoDQueenProblemCombination(board,tQueen,queenPlaced,ans,col,row);
            return;

             */
        }
        if(row>=board.length){
            return;
        }
        if(canPlaced(board,row,col)){
            board[row][col]=true;
            TwoDQueenProblemCombinationKill(board, tQueen, queenPlaced+1, ans+"{" +row+"-"+ col+"}",0, row+1);
            board[row][col]=false;
        }
        TwoDQueenProblemCombinationKill(board,tQueen,queenPlaced,ans,col+1,row);





    }
    public static void OneDQueenProblemCombination(boolean[] board , int tQueen , int queenPlaced , String ans,int lastBoxUsed){
        if(queenPlaced==tQueen|| lastBoxUsed>=board.length){
            System.out.println(ans);
            return;
        }
        for(int i =lastBoxUsed +1; i < board.length;i++){

                board[i] = true;
                OneDQueenProblemCombination(board,tQueen,queenPlaced+1,ans + "b"+i+"q"+queenPlaced,i);
                board[i]=false;

        }
    }
    public static void OneDQueenProblemWRTBox(boolean[] board , int tQueen,int queenPlaced , String ans ,int index){
        if(tQueen==queenPlaced){
            System.out.println(ans);
            return;
        }
        if(index==board.length){
            return;
        }


        board[index] = true;
        OneDQueenProblemWRTBox(board,tQueen,queenPlaced+1,ans+"b"+index,index+1);
        board[index] =false;
        OneDQueenProblemWRTBox(board,tQueen,queenPlaced,ans,index+1);
    }





    public static int countNQueen(boolean[][] board ,int row ){
        int ans = 0;
        if(row==board.length){
            print2DArray(board);
            return 1;
        }
        for(int col =0;col<board[row].length;col++){
            if(canPlaced(board,row,col)){
                board[row][col]=true;
                ans = ans + countNQueen(board,row+1);
                board[row][col]=false;
            }
        }
        return ans;
    }
    public static void countNQueen(boolean[][] board ,int row ,String res){
        int ans = 0;
        if(row==board.length){
            //print2DArray(board);
            System.out.println(res);
            return ;
        }
        for(int col =0;col<board[row].length;col++){
            if(canPlaced(board,row,col)){
                board[row][col]=true;
               countNQueen(board,row+1,res+" , "+row+"-"+col);
                board[row][col]=false;
            }
        }
    }
    public static boolean canPlaced(boolean[][] board ,int row , int col){
        for (int i = row; i >=0; i--) {
            if(board[i][col]){
                return false;
            }
        }
        for(int i=row , j = col; i>=0&&j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for (int i=row , j = col;i>=0&&j<board[0].length;i--,j++){
            if (board[i][j]){
                return false;
            }
        }
        return true;
    }
    public static void print2DArray(boolean[][] arr){
        for (int i =0;i<arr.length;i++){
            System.out.print("[ ");
            for (int j =0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" , ");
            }
            System.out.println(" ]");
        }
    }
    public static int findMaximumSum(int[] nums, int left, int right)
    {
        // If the array contains 0 or 1 element
        if (right == left) {
            return nums[left];
        }

        // Find the middle array element
        int mid = (left + right) / 2;

        // Find maximum subarray sum for the left subarray,
        // including the middle element
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--)
        {
            sum += nums[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        // Find maximum subarray sum for the right subarray,
        // excluding the middle element
        int rightMax = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int i = mid + 1; i <= right; i++)
        {
            sum += nums[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        // Recursively find the maximum subarray sum for the left
        // and right subarray, and take maximum
        int maxLeftRight = Integer.max(findMaximumSum(nums, left, mid),
                findMaximumSum(nums, mid + 1, right));

        // return the maximum of the three
        return Integer.max(maxLeftRight, leftMax + rightMax);
    }

    // Wrapper over findMaximumSum() function
    public static int findMaximumSum(int[] nums)
    {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return findMaximumSum(nums, 0, nums.length - 1);
    }
    public static int findMax(int[] num , int s , int e){
        if(s==e){
            return num[s];
        }
        int mid = (s+e)/2;
        int maxL = findMax(num,s,mid);
        int maxR=findMax(num,mid+1,e);
        return Math.max(maxL,maxR);
    }
    public static void nKnightProblem(boolean[][] board , int row , int col,int tKnight,int knightPlaced,String ans){
        if(tKnight==knightPlaced){
            System.out.print(++count + ".");
            System.out.println(ans);
            return;
        }
        if(col>=board[0].length){
            col=0;
            row++;
        }
        if(row>=board.length){
            return;
        }


        if(canPlacedKnight(board,row,col)){
            board[row][col]=true;
            nKnightProblem(board,row,col+1,tKnight,knightPlaced+1,ans+"{" +row+"-"+ col+"}");
            board[row][col]=false;
        }
        nKnightProblem(board,row,col+1,tKnight,knightPlaced,ans);


    }
    public static boolean canPlacedKnight(boolean[][] board , int row , int col){
        int[] rowPos = {-1,-2,-2,-1};
        int[] colPos={2,1,-1,-2};
        for(int i = 0 ; i<4;i++){
            int r = row+rowPos[i];
            int c = col+colPos[i];
            if(r>=0&&r<board.length&&c>=0&&c<board[0].length){
                if(board[r][c]){
                    return false;
                }

            }
        }
        return true;
    }
    public static void blockedMaze(boolean[][] maze , int row , int col , boolean[][] traced , int eRow,int eCol,String ans){
        if(row==eRow&&col==eCol){
            System.out.println(ans);
            return;

        }
        if(row==-1||col==-1||col>=maze[0].length||row>=maze.length||maze[row][col]||traced[row][col]){
            return;
        }
        traced[row][col]=true;
        blockedMaze(maze,row-1,col,traced,eRow,eCol,ans+"U");
        blockedMaze(maze,row+1,col,traced,eRow,eCol,ans+"D");
        blockedMaze(maze,row,col-1,traced,eRow,eCol,ans+"L");
        blockedMaze(maze,row,col+1,traced,eRow,eCol,ans+"R");
        traced[row][col]=false;
    }



}

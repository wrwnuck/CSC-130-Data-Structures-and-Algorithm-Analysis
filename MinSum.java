// By: Warren Wnuck
// CSC 130 - 01
// 2/24/19
//
// This program finds the minimum sum
// of an array by using divide and
// conquer. 

public class MinSum {

   public static int minimumSum( int [] arr, int left, int right) {
      
      if (left == right){
         if (arr[left] > 0)
            return arr[left];
         else
            return 0;
      }
      
      int center = (left + right)/2;
      int minLeftSum = minimumSum(arr, left, center);
      int minRightSum = minimumSum(arr, center + 1, right);
      
      int minLeftBorderSum = 0, leftBorderSum = 0;
      for (int i = center; i >= left; i--){
         leftBorderSum += arr[i];
         if (leftBorderSum < minLeftBorderSum)
            minLeftBorderSum = leftBorderSum;
      }
      int minRightBorderSum = 0, rightBorderSum = 0;
      for (int i = center + 1; i <= right; i++){
         rightBorderSum += arr[i];
         if (rightBorderSum < minRightBorderSum)
            minRightBorderSum = rightBorderSum;
      }
      
      return min3(minLeftSum, minRightSum, minLeftBorderSum + minRightBorderSum);
     
  }
  public static int min3(int lS, int rS, int both){
      int first = Math.min(lS,rS);
      return Math.min(first, both);
  } 
  
   public static int minSubSum3( int [] arr){
      return minimumSum(arr, 0, arr.length-1);
   }  
   
   public static void main(String[] args){
   
      int[] arr = {4,-3,5,-2,-1,2,6,-2};
   
      int val = minSubSum3(arr);
      System.out.println(val);
      
   }
}

   
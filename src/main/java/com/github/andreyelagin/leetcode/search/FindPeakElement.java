package com.github.andreyelagin.leetcode.search;

// todo
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    return recSearch(0, nums.length - 1, nums);
  }

  private int recSearch(int left, int right, int[] nums) {
    if (left == right) {
      return left;
    } else if (left + 1 == right) {
      if (nums[left] > nums[left]) {
        return left;
      } else {
        return right;
      }
    } else {
      int mid = ((right - left) / 2) + left;

      if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
        return mid;
      } else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
        return recSearch(left, mid - 1, nums);
      } else {
        return recSearch(mid + 1, right, nums);
      } 
    }
  }
}

//public int findPeakElement(int[] num) {    
//    return helper(num,0,num.length-1);
//}
//
//public int helper(int[] num,int start,int end){
//    if(start == end){
//        return start;
//    }else if(start+1 == end){
//        if(num[start] > num[end]) return start;
//        return end;
//    }else{
//        
//        int m = (start+end)/2;
//        
//        if(num[m] > num[m-1] && num[m] > num[m+1]){
//
//            return m;
//
//        }else if(num[m-1] > num[m] && num[m] > num[m+1]){
//
//            return helper(num,start,m-1);
//
//        }else{
//
//            return helper(num,m+1,end);
//
//        }
//        
//    }
//}

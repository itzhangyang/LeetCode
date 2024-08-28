package com.leetcode.learning.arrays;

public class MergeSortedArrays {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1;// The last index of the first array
            int j = n-1;// The last index of the second array
            int k = m+n-1; // The last index of the merged array
            // Compare the last element of the two arrays and put the larger one at the end of the merged array
            while(i>=0 && j>=0){
                // If the first array has more elements, put them in the merged array
                if(nums1[i]>nums2[j]){
                    nums1[k--]=nums1[i--];
                }else{
                    nums1[k--]=nums2[j--];
                }
            }
            // If the second array has more elements, put them in the merged array
            while(j>=0){
                nums1[k--]=nums2[j--];
            }
        }
    }
}

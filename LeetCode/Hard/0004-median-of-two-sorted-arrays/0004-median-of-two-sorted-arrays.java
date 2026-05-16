import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2. length;

        int[] mergedArr = new int[m+n];
        for(int i=0; i<m; i++) {
            mergedArr[i] = nums1[i];
        }
        for(int i=m; i<m+n; i++) {
            mergedArr[i] = nums2[i-m];
        }

        Arrays.sort(mergedArr);
        int center = (m+n)/2;

        double answer = 0;
        
        if((m+n)%2 == 0) {
            answer = (double)(mergedArr[center]+mergedArr[center-1])/2;
        } else {
            answer = (double)(mergedArr[center]);
        }
        return answer;
    }
}
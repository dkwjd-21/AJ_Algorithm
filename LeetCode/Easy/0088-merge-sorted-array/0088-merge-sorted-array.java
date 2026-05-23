class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 3개의 포인터 
        int p1 = m - 1;         // nums1의 유효 데이터 맨 끝
        int p2 = n - 1;         // nums2의 맨 끝
        int p = m + n - 1;      // nums1 배열 전체의 맨 끝

        // nums2의 모든 요소가 처리될 때까지 반복
        while (p2 >= 0) {
            // nums1에 아직 비교할 데이터가 남아있고, nums1의 값이 더 큰 경우
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } 
            else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--; 
        }
    }
}
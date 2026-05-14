class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums의 두 요소를 합하여 target이 되는 인덱스 출력
        int[] answer = new int[2];

        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                sum = nums[i]+nums[j];
                if(sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }

        return answer;
    }
}
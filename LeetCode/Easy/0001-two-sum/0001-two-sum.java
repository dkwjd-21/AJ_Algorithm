class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums의 두 요소를 합하여 target이 되는 인덱스 출력
        int[] answer = new int[2];

        // 값을 key로, 인덱스를 value로 저장하는 해시맵
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int tmp = target - nums[i];

            if(map.containsKey(tmp)) {
                answer[0] = map.get(tmp);
                answer[1] = i;
                break;
            }
            
            map.put(nums[i], i);
        }


        return answer;
    }
}
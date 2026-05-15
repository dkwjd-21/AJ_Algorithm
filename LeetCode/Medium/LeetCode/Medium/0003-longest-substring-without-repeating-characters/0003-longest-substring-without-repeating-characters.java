class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        // 이미 나왔던 철자
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right<s.length(); right++){
            while (set.contains(s.charAt(right))) {
                // left~right 중복이 사라질 때까지 왼쪽에서부터 하나씩 빼기 
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(s.charAt(right));
            // 현재 길이와 저장된 길이 비교해서 큰 값을 저장
            maxLength = Math.max(maxLength, set.size());
        }


        return maxLength;
    }
}
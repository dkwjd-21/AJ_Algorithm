class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        
        // 비교의 기준점
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++) {
            String tmp = strs[i];

            while(!tmp.startsWith(prefix)) {
                if(prefix.length() > 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);  
                } else {
                    return "";
                }
            }
        }

        return prefix;
    }
}
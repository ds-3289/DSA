class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st=new HashSet<>();
        int size=0;
        int l=0;
        int r=0;
        int maxsize=0;
        while(r<s.length()){
            if(!st.contains(s.charAt(r))){
                st.add(s.charAt(r));
                size=r-l+1;
                maxsize=Math.max(size,maxsize);
                r++;
            }else{
                st.remove(s.charAt(l));
                l++;
            }
        }
        return maxsize;
    }
}
class Solution {
    public int maxPalindromes(String s, int k) {
        int i=0;
        int count=0;
        while (i<s.length()) {
            boolean found=false;
            int j=i+k-1;
            if (j<s.length() && isPalindrome(s,i,j)) {
                count++;
                i=j+1;
                found=true;
            }
            if (!found){
                j=i+k;
                if (j<s.length() && isPalindrome(s,i,j)) {
                    count++;
                    i=j+1;
                    found=true;
                }
            }
            if(!found){
                i++;
            }
        }
        return count;
    }
    public boolean isPalindrome(String s, int l, int r) {
    while (l<r) {
        if (s.charAt(l)!=s.charAt(r)) {
            return false;
        }
        l++;
        r--;
    }
    return true;
    }
}
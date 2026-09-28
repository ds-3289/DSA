class Solution {
    public int maxDepth(String s) {
        int open=0;
        int maxopen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
                maxopen=Math.max(open,maxopen);
            }else if(s.charAt(i)==')'){
                open--;
            }
        }
        return maxopen;
    }
}
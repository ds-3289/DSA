class Solution {
    public int minOperations(String s) {
        boolean sorted = true;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1)){
                sorted=false;
                break;
            }
        }
        if(sorted) return 0;
        if(s.length()==2) return -1;
        int minCount=0;
        int maxCount=0;
        char minChar=s.charAt(0);
        char maxChar=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<minChar){
                minChar=s.charAt(i);
            }
            if(s.charAt(i)>maxChar){
                maxChar=s.charAt(i);
            }
        }
         for(int i=0;i<s.length();i++){
            if(s.charAt(i)==minChar) minCount++;
            if(s.charAt(i)==maxChar) maxCount++;
        }
        boolean smallestAtFirst=(s.charAt(0)==minChar);
        boolean largestAtLast=(s.charAt(s.length()-1)==maxChar);
        if(smallestAtFirst || largestAtLast) return 1;
        if(s.charAt(0)==maxChar && s.charAt(s.length()-1)==minChar && minCount==1 && maxCount==1) return 3;
        return 2;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> sp=new HashMap<>();
        HashMap<Character,Integer> tp=new HashMap<>();
        int minLen=Integer.MAX_VALUE;
        int start=0;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!tp.containsKey(ch)){
                tp.put(ch,1);
            }else{
                tp.put(ch,tp.get(ch)+1);
            }
        }
        int l=0;
        int r=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            if(!sp.containsKey(ch)){
                sp.put(ch,1);
            }else{
                sp.put(ch,sp.get(ch)+1);
            }
            while(valid(sp,tp)){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    start=l;
                }
                if(sp.get(s.charAt(l))==1)sp.remove(s.charAt(l));
                else sp.put(s.charAt(l),sp.get(s.charAt(l))-1);
                l++;
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
    public boolean valid(HashMap<Character,Integer> sp ,HashMap<Character,Integer> tp){
        boolean valid=true;
        for(char c:tp.keySet()){
            if(!sp.containsKey(c) || sp.get(c)<tp.get(c)){
                valid=false;
                break;
            }
        }
        return valid;
    }
}
class Solution {
    public int ladderLength(String s, String e, List<String> l) {
        if(!l.contains(e) || s.equals(e)) return 0;
        Set<String>st=new HashSet<>();
        for(int i=0;i<l.size();i++){
            st.add(l.get(i));
        }
        Queue<String> q=new LinkedList<>();
        q.add(s);
        st.remove(s);
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String x=q.remove();
                char[] arr=x.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char original=arr[i];
                    for(char ch='a';ch<='z';ch++){
                        if(ch!=original)arr[i]=ch;
                        String newS=new String(arr);
                        if(st.contains(newS)){
                            if(newS.equals(e))return count+1;
                            q.add(newS);
                            st.remove(newS);
                        }
                        arr[i]=original;
                    }                   
                }
                    
            }
            count++;
        }
        return 0;
    }
}
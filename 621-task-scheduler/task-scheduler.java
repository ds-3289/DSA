class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(!mp.containsKey(tasks[i])){
                mp.put(tasks[i],1);
            }else{
                mp.put(tasks[i], mp.get(tasks[i]) + 1);
            }
        }
        int maxFreq=0;
        for(char ch:mp.keySet()){
            maxFreq=Math.max(maxFreq,mp.get(ch));
        }
        int countMax=0;
        for(char ch:mp.keySet()){
            if(mp.get(ch)==maxFreq){
                countMax++;
            }
        }
        return Math.max(tasks.length,((maxFreq-1)*(n+1)+countMax));
    }
}
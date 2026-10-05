class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int ch:s.toCharArray()){
            if(ch=='('){
                st.push(0);
            }else{
                int current=st.pop();
                int score=0;
                if(current==0){
                    score=1;
                }else{
                    score=2*current;
                }
                st.push(st.pop()+score);
            }
        }
        return st.pop();
    }
}
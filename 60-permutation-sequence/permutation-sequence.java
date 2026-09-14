class Solution {
    public String getPermutation(int n, int k) {
        int[] arr=new int[n];
        int size=n;
        int i=0;
        while(n>0){
            arr[i]=i+1;
            i++;
            n--;
        }
        k--;
        while(k > 0){
            int m = -1;
            for(int j = size - 2; j >= 0; j--){
                if(arr[j] < arr[j + 1]){
                m = j;
                break;
                }
            }
        if(m != -1){
        int l = size - 1;
        while(arr[l] <= arr[m]){
            l--;
        }
        int temp = arr[m];
        arr[m] = arr[l];
        arr[l] = temp;
        int s = m + 1;
        int e = size - 1;
        while(s < e){
            temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        }
        k--;
    }
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<arr.length;j++){
            sb.append(arr[j]);
        }
        return sb.toString();
        
    }
}
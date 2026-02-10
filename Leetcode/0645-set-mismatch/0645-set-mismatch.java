class Solution {
    public int[] findErrorNums(int[] arr) {
        int n=arr.length;
        int i=0;
        while(i<n){
            int value=arr[i]-1;
            if(arr[i]!=arr[value] && i!=value){
               int  temp=arr[i];
                arr[i]=arr[value];
                arr[value]=temp;
            
            }
            else{
                i++;
            }
        }
        int ans[]=new int[2];
        for(  i=0;i<arr.length;i++){
            if(i!=arr[i]-1){
                ans[0]=arr[i];
                ans[1]=i+1;

            }
        }
        return ans;
        
    }
}
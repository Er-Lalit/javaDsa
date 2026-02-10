class Solution {
    public int missingNumber(int[] arr) {
      int n=arr.length;
      int i=0;
      while(i<n){
        if(arr[i]<n &&i!=arr[i]){
            int temp=arr[i];
            arr[i]=arr[temp];
            arr[temp]=temp;
        }
        else{
         i++;
        }
      }
      for( i=0;i<n;i++){
        if(i!=arr[i]){
            return i;
        }
      }
        return n;
    }
}
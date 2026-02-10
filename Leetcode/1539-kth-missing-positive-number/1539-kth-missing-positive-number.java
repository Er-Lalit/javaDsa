class Solution {
    public int findKthPositive(int[] arr, int k) {
    //    int num=1;
    //    int n=arr.length;
    //    int i=0; 
    //    while(i<n && k>0){
    //     if(arr[i]==num){
    //         i++;
    //     }
    //     else{
    //         k--;
    //     }
    //     num++;
    //    }
    //    while(k>0){
    //     k--;
    //     num++;
    //    }
    //    return num-1;
    int low=0;
    int high=arr.length-1;
    while(low<=high){
        int mid=(low+high)/2;
        int missing=arr[mid]-(mid+1);
        if(missing <k){
            low=mid+1;
        }

        else{
            high=mid-1;
        }
    }
    return low+k;
    }
}
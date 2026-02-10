class Solution {
    public int specialArray(int[] arr) {
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
       
        // int i=0;
        // while(i<=max){
        //      int count=0;
        //     for(int j=0;j<arr.length;j++){
        //         if(arr[j]>=i){
        //             count++;
        //         }
        //     }
        //     if(count==i){
        //         return i;
        //     }
        //     i++;
            


        // }
        // return -1;
        // from here we can start the optimized approach 1 
        Arrays.sort(arr);
        int n=arr.length;
        int lb=0;
        int ub=max;
        while(lb<=ub){
            int mid=(lb+ub)/2;
             int idx=findSmallG(arr,mid);
             int count=n-idx;
             if(mid==count){
                return mid;
             }
            else if(count>mid){
                lb=mid+1;
             }
             else{
                ub=mid-1;
             }

        }
        // for(int i=0;i<=max;i++){
        //     int idx=findSmallG(arr,i);
        //     int count=n-idx;
        //     if(i==count){
        //         return i;
        //     }
            
        // }
        return -1;
        
    }
    static int findSmallG(int []arr,int target){
        int lb=0;
        int ub=arr.length-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
             if(arr[mid]>=target){
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return lb;

    }
}
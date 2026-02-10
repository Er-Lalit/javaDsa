class Solution {
    public int[] searchRange(int[] nums, int target) {
              // int ans[] = new int[2];
        // int j = 0;
        // boolean check = false;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         check = true;
        //         if (j == 0) {
        //             ans[j] = i;
        //             ans[j + 1] = i;
        //             j++;
        //         } else {
        //             ans[j] = i;
                   
        //         }

        //     }

        // }
        // if (check) {
        //     return ans;

        // } else {
        //     ans[0] = -1;
        //     ans[1] = -1;
        //     return ans;
        // }
        // second try
        // int firstPos=-1;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         firstPos=i;
        //         break;

        //     }
        // }
        // int lastPos=-1;
        // for(int i=nums.length-1;i>=0;i--){
        //     if(nums[i]==target){
        //         lastPos=i;
        //         break;

        //     }
        // }
        // ans[0]=firstPos;
        // ans[1]=lastPos;
        // return ans;
       int idx1=findLeft(nums,target);
       int idx2=findRight(nums,target);
return new int[] {idx1,idx2};
    }
    static int findLeft(int []nums,int target){
        int index=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int  mid=low+(high-low)/2;
            if(nums[mid]==target){
                index=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return index;

    }
    static int findRight(int nums[],int target){
     int index=-1;
        int low=0;
        int high=nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;   // possible answer
                low = mid + 1; // keep searching right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
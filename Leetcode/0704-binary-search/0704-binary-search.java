class Solution {
    public int search(int[] nums, int target) {
        int ans=recursiveMethod(nums,0,nums.length-1,target);
        return ans;        
    }
    static int recursiveMethod(int arr[],int start, int end,int target)
    {
        int mid=(start+end)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(start>end)
        {
            return -1;
        }
        else if(arr[mid]>target)
        {
           return recursiveMethod(arr,start,mid-1,target);
        }
        else if(arr[mid]<target)
        {
            return recursiveMethod(arr,mid+1,end,target);
        }
return -1;
    }
}   
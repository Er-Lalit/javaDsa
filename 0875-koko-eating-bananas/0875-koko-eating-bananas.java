class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int end=Integer.MIN_VALUE;
        int start=1;
        for(int i=0;i<arr.length;i++)
        {
            end=Math.max(end,arr[i]);

        }
        int ans=0;
        while(start<=end)
        {
            int mid=(start+end)/2;
            

            if(check(mid,h,arr))
            {
                ans=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;

            }
        }
        return ans;

        
    }
    static boolean check(int mid,int h,int arr[])
    {
        long hours=0;
        for(int i=0;i<arr.length;i++)
        {
            
            hours += (arr[i] + (long) mid - 1) / mid;
            if(hours>h)
            {
                return false;
            }
        }
        return true;
    } 
}
class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int start=Integer.MIN_VALUE;
        int end=0;
        for(int i=0;i<arr.length;i++)
        {
            start=Math.max(start,arr[i]);
            end+=arr[i];
        }
        int ans=0;
        while(start<=end)
        {
            int mid=(start+end)/2;

            if(check(mid,days,arr))
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
    static boolean check(int mid, int days,int arr[])
    {
        int d=1;
        int w=0;
        for(int i=0;i<arr.length;i++)
        {
            if(w+arr[i]<=mid)
            {
                w+=arr[i];
            }
            else
            {
                d++;
                w=arr[i];

            }

        }
        return d<=days;
    }
}
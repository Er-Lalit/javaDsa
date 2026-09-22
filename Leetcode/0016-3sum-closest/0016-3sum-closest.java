class Solution {
    public int threeSumClosest(int[] arr, int target) {

        // *** first i am use this approach to solve but i found that most of the test cases are not 
        // Arrays.sort(arr);
        // int i=0;
        // int j=arr.length-1;
        // while(j-i>2)
        // {
        //     if(arr[i]+arr[j]<=target)
        //     {
        //         i++;
        //     }
        //     else
        //     {
        //         j--;
        //     }
        // }
        // int ans=0;
        // for(int k=i;k<=j;k++)
        // {
        //     ans+=arr[k];
        // }
        // return ans;
        Arrays.sort(arr);
        int closestSum=arr[0]+arr[1]+arr[2];
        for(int i=0;i<arr.length-2;i++)
        {
            int left=i+1;
            int right=arr.length-1;
            while(left<right)
            {
                int sum=arr[i]+arr[left]+arr[right];
                if(Math.abs(target-sum)<Math.abs(target-closestSum))
                {
                    closestSum=sum;
                }
                if(sum<target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }

        }
        return closestSum;
        
    }
}
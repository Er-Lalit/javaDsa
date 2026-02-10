class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int num1=lessThanEqual(nums,k);
        int num2=lessThanK(nums,k);
        return num1-num2;
        
    }
    //find the number of the subarray with the >=k 
    int lessThanEqual(int nums[],int k)
    {
        int i=0;
        int j=0;
        int ans=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        while(j<nums.length)
        {
            int num=nums[j];
            if(hs.containsKey(num))
            {
                hs.put(num,hs.get(num)+1);
            }
            else
            {
                hs.put(num,1);
            }
            while(hs.size()>k)
            {
                int num1=nums[i];
                hs.put(num1,hs.get(num1)-1);
                if(hs.get(num1)==0)
                {
                    hs.remove(num1);
                }
                i++;
            }
            int len=j-i+1;
            ans+=len;
            j++;



        }
        return ans;

    }
    //create method for the less than k 
    int lessThanK(int nums[], int k)
    {
        int i=0;
        int j=0;
        int ans=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        while(j<nums.length)
        {
            int num=nums[j];
            if(hs.containsKey(num))
            {
                hs.put(num,hs.get(num)+1);
            }
            else
            {
                hs.put(num,1);
            }
            while(hs.size()>=k)
            {
                int num1=nums[i];
                hs.put(num1,hs.get(num1)-1);
                if(hs.get(num1)==0)
                {
                    hs.remove(num1);
                }
                i++;
            }
            int len=j-i+1;
            ans+=len;
            j++;



        }
        return ans;

    }
}
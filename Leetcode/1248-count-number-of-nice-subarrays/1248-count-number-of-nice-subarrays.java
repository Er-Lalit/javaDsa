class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                arr[i]=0;
            }
            else
            {
                arr[i]=1;
            }
        }
        int cumsum=0;
        int count=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        for(int j=0;j<arr.length;j++)
        {
            cumsum+=arr[j];
            if(hs.containsKey(cumsum-k))
            {
                count+=hs.get(cumsum-k);

            }
            if(hs.containsKey(cumsum))
            {
                hs.put(cumsum,hs.get(cumsum)+1);
            }
            else
            {
                hs.put(cumsum,1);
            }

        }
        return  count;
    }
}
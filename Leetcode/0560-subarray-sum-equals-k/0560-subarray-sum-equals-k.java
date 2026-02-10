class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        int cumsum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            cumsum+=nums[i];
            if(hs.containsKey(cumsum-k))
            {

                int num=cumsum-k;
                count+=hs.get(num);
               
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
        return count;
    }
}
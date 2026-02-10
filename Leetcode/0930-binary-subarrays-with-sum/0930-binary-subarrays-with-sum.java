    class Solution {
        public int numSubarraysWithSum(int[] nums, int k) {
            // int ans=0;
            // for(int i=0;i<nums.length;i++)
            // {
            //     if(nums[i]==goal)
            //     {
            //         ans++;
            //     }
            //     for(int j=i+1;j<nums.length;j++)
            //     {
            //         int sum=0;
            //         for(int k=i;k<=j;k++)
            //         {
            //             sum+=nums[k];
            //         }
            //         if(sum==goal)
            //         {
            //             ans++;
            //         }

            //     }
            // }
            // return ans;
            //optimal 
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
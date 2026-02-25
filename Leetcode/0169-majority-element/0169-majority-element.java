class Solution {
     public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int frequency=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                frequency+=1;
                if(frequency>nums.length/2)
                {
                    return nums[i];
                }
            }
            else
            {
                frequency=1;
            }
        }
        return nums[0];
    }

    // THIS IS BRUTFORCE APPROACH
    // public int majorityElement(int[] nums) {
    //     HashMap<Integer,Integer> map=new HashMap();
    //     for(int i=0;i<nums.length;i++)
    //     {
    //         if(map.containsKey(nums[i]))
    //         {
    //             map.put(nums[i],map.get(nums[i])+1);
    //         }
    //         else
    //         {
    //             map.put(nums[i],1);
    //         }
    //     }
    //     for(int key:map.keySet())
    //     {
    //         if(map.get(key)>nums.length/2)
    //         {
    //             return key;
    //         }
    //     }
    //     return 0;
        
    // }
}
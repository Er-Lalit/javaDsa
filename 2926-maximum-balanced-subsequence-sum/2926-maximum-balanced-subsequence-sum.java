class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
       
        return recursive(nums);
        
    }
    public  static long recursive(int arr[])
    {
        TreeMap<Integer,Long> map=new TreeMap<>();

        long result=Long.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {

            long sum=arr[i];
            int currKey=arr[i]-i;
            Integer floor=map.floorKey(currKey);

            if(floor!=null)
            {
                sum=Math.max(sum,arr[i]+map.get(floor));
            }

            // now we store sum at the key 

            
            
            map.put(currKey,Math.max(map.getOrDefault(currKey,Long.MIN_VALUE),sum));

            Integer ceil=map.higherKey(currKey);

            while(ceil!=null && map.get(ceil)<=map.get(currKey))
            {
                map.remove(ceil);

                ceil=map.higherKey(currKey);
            }

            result=Math.max(result,map.get(currKey));

        }
        return result;
    }
}
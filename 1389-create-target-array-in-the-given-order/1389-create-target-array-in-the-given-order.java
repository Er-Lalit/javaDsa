class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int idx=index[i];
            int element=nums[i];

            if(idx>list.size()-1)
            {
                list.add(element);
            }
            else
            {
                list.add(idx,element);
            }
        }
        int ans[]=new int[nums.length];
        int i=0;
        for(int val:list)
        {
            ans[i]=val;
            i++;
        }
        return ans;
        
    }
}
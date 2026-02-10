class Solution {
     int count;
    public int countArrangement(int n) {
        count=0;
        int nums[]=new int [n];
        for(int i=0;i<n;i++)
        {
            nums[i]=i+1;
        }
        backtrack(nums,0);
        return count;
        
    }
     void backtrack(int nums[],int idx)
    {
        if(idx==nums.length)
        {
           count++;
           return ;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(idx, i, nums);
           int pos = idx + 1;
           if (nums[idx] % pos == 0 || pos % nums[idx] == 0)
           {
              
            backtrack(nums, idx+1);
             
           }
            swap(idx, i, nums);

        }
        
    }
    void swap(int a,int b,int nums[])
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;

    }
}
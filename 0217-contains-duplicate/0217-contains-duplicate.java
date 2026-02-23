class Solution {
    public boolean containsDuplicate(int[] nums) {
        //quickSort(0,nums.length-1,nums);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                return true;
            }
        }
        return false;
        
    }
  static void quickSort(int lb,int ub,int[] arr)
{
    if(lb >= ub)
        return;

    int j = partition(lb, ub, arr);

    quickSort(lb, j-1, arr);
    quickSort(j+1, ub, arr);
}

static int partition(int lb,int ub,int arr[])
{
    int pivot = arr[lb];
    int p = lb + 1;
    int q = ub;

    while(p <= q)
    {
        while(p <= ub && arr[p] <= pivot) p++;
        while(q > lb && arr[q] >= pivot) q--;

        if(p < q)
            swap(p, q, arr);
    }

    swap(lb, q, arr);
    return q;
}
static void swap(int i,int j,int arr[])
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
}
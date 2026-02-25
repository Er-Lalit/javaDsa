class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st=new HashSet<>();
        for(int i:nums1)
        {
            st.add(i);
        }
        mergeSort(0, nums2.length, nums2);
        List<Integer> ls=new ArrayList<>();
       for(int i:st)
       {
          if(search(nums2, i, 0, nums2.length-1))
            {
             ls.add(i);
            }
       }        
       int arr[]=new int[ls.size()];
       for(int i=0;i<ls.size();i++)
       {
         arr[i]=ls.get(i);
       }
       return arr;
    }
     static void mergeSort(int s,int end, int arr[])
    {
        if(end-s==1)
        {
            return ;
        }
        int mid=(s+end)/2;
        mergeSort(s, mid, arr);
        mergeSort(mid,end,arr);
        merge(s,mid,end,arr);
    }
    static void merge(int s,int mid,int end,int arr[])
    {
        int i=s;
        int j=mid;
        int k=0;
        int mix[]=new int[end-s];
        while(i<mid && j<end)
        {
            if(arr[i]<=arr[j])
            {
                mix[k]=arr[i];
                i++;
            }
            else
            {
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        //copy remaining element 
        while(i<mid)
        {
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<end)
        {
            mix[k]=arr[j];
            j++;
            k++;            
        }
        for(int l=0;l<mix.length;l++)
        {
            arr[s+l]=mix[l];
        }
    }
    static boolean search(int arr[],int target,int start,int end)
    {
        
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            if(arr[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
                    
        }
        return false;
    
    }
}
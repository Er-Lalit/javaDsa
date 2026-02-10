class Solution {
    public int[] findRightInterval(int[][] intervals) {
       
        // int ans[]=new int[intervals.length];
        // for(int i=0;i<intervals.length;i++){
        //     int idx=-1;
        //     int min=Integer.MAX_VALUE;
        //     for(int j=0;j<intervals.length;j++){
        //         if(intervals[i][1]<=intervals[j][0]){
        //             if(min>intervals[j][0]){
        //                 min=intervals[j][0];
                        
        //                 idx=j;
        //             }
        //         }
        //     }
        //     ans[i]=idx;
        // }
        // return ans;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int arr[]=new int[intervals.length];
        int ra[]=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            hm.put(intervals[i][0],i);
            arr[i]=intervals[i][0];
        }
        Arrays.sort(arr);
        for(int i=0;i<intervals.length;i++){
           int value= minimizedBS(arr,intervals[i][1]);
           if(value!=-1){
           if(hm.get(arr[value])!=null){
            ra[i]=hm.get(arr[value]);
           }
           }
           else{
            ra[i]=-1;
           }

        }
        return ra;
    }
    static int minimizedBS(int arr[],int target){
        int lb=0;
        int ub=arr.length-1;
         int ans=-1;
    while(lb<=ub){
        int mid=(lb+ub)/2;
        if(arr[mid]>=target){
           ans=mid;

           ub=mid-1;
        }
        else{
            lb=mid+1;

        }
    
    }
    return ans;
    }
}
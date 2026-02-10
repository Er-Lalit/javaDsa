class Solution {
    public List<Integer> findDuplicates(int[] arr) {
         int n=arr.length;
        int i=0;
        while(i<n){
            int value=arr[i]-1;
            if(arr[i]!=arr[value] && i!=value){
               int  temp=arr[i];
                arr[i]=arr[value];
                arr[value]=temp;
            
            }
            else{
                i++;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(i=0;i<n;i++){
        if(i!=arr[i]-1){
            list.add(arr[i]);
        }
        }
        return list;
    }
}
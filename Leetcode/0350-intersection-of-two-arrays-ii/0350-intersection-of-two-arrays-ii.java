class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l1=new ArrayList();
        for(int i=0;i<nums1.length;i++){
            l1.add(nums1[i]);
        }
         List<Integer> l2=new ArrayList();
        for(int i=0;i<nums2.length;i++){
            l2.add(nums2[i]);
        }
        List<Integer> ans=new ArrayList();
        for(int i=0;i<l1.size();i++){
            int element=l1.get(i);
            if(l2.contains(element)){
                ans.add(element);
                int idx=l2.indexOf(element);
                l2.set(idx,-1);


            }
        }
        int arr[]=new int[ans.size()];
        int i=0;
        for(int a:ans){
            arr[i++]=a;
        }
        return arr;
        
    }
}
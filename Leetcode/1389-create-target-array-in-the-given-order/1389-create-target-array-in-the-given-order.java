class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int target[]=new int[nums.length];
        int ub=-1;
    for(int i=0;i<nums.length;i++){
        int element=nums[i];
        int idx=index[i];
        ub=addTarget(target,ub,element,idx);

    }
    return target;

    }
    static int addTarget(int target[],int ub,int element,int index){
        int i=ub;
        while(index<=i){
            target[i+1]=target[i];
            i--;
        }
        target[i+1]=element;
        ub++;
        return ub;



    }
}
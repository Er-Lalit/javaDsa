/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
    //     int low=0;
    //     int high=mountainArr.length()-1;
    //    // int ans=-1;
    //     while(low<=high){
    //         int mid=(low+high)/2;
    //         if(mountainArr.get(mid)==target){
    //             return mid;
    //         }
    //         else if(mountainArr.get(mid)>target){
    //             high=mid-1;

    //         }
    //         else
    //     {
    //         low=mid+1;
    //     }
    //     }
    //     return -1;
  int  length=mountainArr.length()-1;
    int peakInd=peakElement(0,length,mountainArr);
    int idx=binarySearchAssending(0,peakInd,mountainArr,target);
    if(idx!=-1){
        return idx;
    }
    else{
        return binarySearchDecending(peakInd+1,length,mountainArr,target);
    }


    }
    static int peakElement(int lb,int ub,MountainArray mountainArr){
        while(lb<ub){
            int mid=(lb+ub)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                ub=mid;
            }
            else{
                lb=mid+1;
            }
        }
        return lb;
    }
    static int binarySearchAssending(int lb, int ub,MountainArray mountainArr,int target){
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(target==mountainArr.get(mid)){
                return mid;
            }
            else if(mountainArr.get(mid)<target){
                lb=mid+1;

            }
            else{
                ub=mid-1;
            }
        }
        return -1;
    }
    static int binarySearchDecending(int lb, int ub,MountainArray mountainArr,int target){
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(target==mountainArr.get(mid)){
                return mid;
            }
            else if(mountainArr.get(mid)<target){
                ub=mid-1;

            }
            else{
                lb=mid+1;
            }
        }
        return -1;
    }

}
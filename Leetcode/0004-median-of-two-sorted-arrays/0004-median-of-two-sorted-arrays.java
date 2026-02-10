class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0;
        int j=0;
        int k=0;
        int size=m+n;
        int idx1=(size-1)/2;
        int idx2=size/2;
        int element1=-1;
        int element2=-1;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                if(k==idx1){
                    element1=nums1[i];

                }
                 if(k==idx2){
                    element2=nums1[i];
                }
                i++;

            }
            else{
                if(k==idx1){
                    element1=nums2[j];
                }
                 if(k==idx2){
                    element2=nums2[j];
                }
                j++;
            }
            k++;

        }
        while(i<n){
             if(k==idx1){
                    element1=nums1[i];

                }
                 if(k==idx2){
                    element2=nums1[i];
                }
                i++;
                k++;
            
        }
        while(j<m){
            if(k==idx1){
                    element1=nums2[j];
                }
                 if(k==idx2){
                    element2=nums2[j];
                }
                j++;
                k++;
        }
        if(size%2!=0){
            return (float) element2;
        }
        else{
            double value=(double) (element1+element2)/2;
            
            return value;
        }

    }
}
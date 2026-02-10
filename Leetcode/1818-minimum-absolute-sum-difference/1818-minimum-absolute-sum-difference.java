class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long total = 0;
         int MOD = 1000000007;
        for (int i = 0; i < nums1.length; i++) {
            total += Math.abs(nums1[i] - nums2[i]);

        }
        int [] sorted=nums1.clone();
        Arrays.sort(sorted);
        long maxImpDiff=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            // if(nums1[i]==nums2[i]){
            //     continue;
            // }
            long target=nums2[i];
            long improveDiff=binarySearch(target, sorted);
            long previousDiff = Math.abs(nums1[i] - nums2[i]);
            long improvedDiff = Math.abs(improveDiff - target);
            long changeDiff = previousDiff - improvedDiff;
            maxImpDiff = Math.max(maxImpDiff, changeDiff);

            
        }

        long result = (total - maxImpDiff) % MOD;
        return (int) result;
    }

    public int binarySearch(long target, int arr[]) {
        int lb = 0;
        int ub = arr.length - 1;
        if (target < arr[lb]) {
            return arr[lb];
        }
        if (target > arr[ub]) {
            return arr[ub];
        }
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (target < arr[mid]) {
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        if(lb>=arr.length){
            lb=arr.length-1;
        }
        if(ub<0){
            ub=0;
        }
            long lbdiff=Math.abs(target-arr[lb]);
            long ubdiff=Math.abs(target-arr[ub]);
            return lbdiff<ubdiff?arr[lb]:arr[ub];
    }
}
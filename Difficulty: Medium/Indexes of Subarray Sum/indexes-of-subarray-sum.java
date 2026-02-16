import java.util.*;

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int start = 0;
        int currentSum = 0;
        
        for (int end = 0; end < arr.length; end++) {
            
            currentSum += arr[end];
            
            // If sum becomes greater than target, shrink window
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }
            
            // If sum equals target
            if (currentSum == target) {
                result.add(start + 1);  // 1-based index
                result.add(end + 1);    // 1-based index
                return result;
            }
        }
        
        result.add(-1);
        return result;
    }
}
// User function Template for Java

class Solution {
    static int minSteps(int d) {
        // code here
       d=Math.abs(d);
        int sum=0;
        int step=0;
        while(sum<d)
        {
            step++;
            sum+=step;
        }
        // if sum is greater then the target
        while((sum-d)%2!=0)
        {
            step++;
            sum+=step;
        }
        return step;
        
    }
}
class Solution {
    public int reachNumber(int target) {
        int step=0;
        int sum=0;
        target=Math.abs(target);
        while(sum<target ||(target-sum)%2!=0){
            step++;
            sum+=step;
        }
        return step;
    }
}
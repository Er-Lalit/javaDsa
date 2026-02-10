class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long lb=1;
        long ub=0;
        long result=0;
        for(int i=0;i<piles.length;i++){
            ub=Math.max(ub,piles[i]);
        }
       while(lb<=ub){
        long mid=lb+(ub-lb)/2;
        long count=0;
        for(int i=0;i<piles.length;i++){
            count+=Math.ceil((double)((double)piles[i]/(double)mid));
            // count += (piles[i] + mid - 1) / mid;
            // int value=piles[i];
            // if(value<=mid){
            //     count++;
            //     continue;
            // }
            // while(value>0){
            // value-=mid;
            // count++;
            // }

        }
        if(count<=h){
            result=mid;
            ub=mid-1;

        }
        else{
            lb=mid+1;
        }

    }

       return (int)result; 
    }
}